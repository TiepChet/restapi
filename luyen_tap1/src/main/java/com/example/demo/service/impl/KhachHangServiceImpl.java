package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public KhachHang getOne(long maKhachHang) throws ResourceNotFoundException {
        Optional<KhachHang> optionalKhachHang = khachHangRepo.findById(maKhachHang);
        if (optionalKhachHang.isPresent()) {
            return optionalKhachHang.get();
        }
        throw new ResourceNotFoundException("Khach_Hang not found with id: " + maKhachHang);
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khachHangRepo.save(khachHang);
    }

    @Override
    public KhachHang update(long maKhachHang, KhachHang khachHang) throws ResourceNotFoundException {
        Optional<KhachHang> optionalKhachHang = khachHangRepo.findById(maKhachHang);
        if (optionalKhachHang.isPresent()) {
            KhachHang updateKhachHang = optionalKhachHang.get();
            updateKhachHang.setHangKhachHang(khachHang.getHangKhachHang());
            updateKhachHang.setTenKhachHang(khachHang.getTenKhachHang());
            return khachHangRepo.save(updateKhachHang);
        }
        throw new ResourceNotFoundException("Khach_Hang not found with id: " + maKhachHang);
    }

    @Override
    public void delete(long maKhachHang) {
        khachHangRepo.deleteById(maKhachHang);
    }
}
