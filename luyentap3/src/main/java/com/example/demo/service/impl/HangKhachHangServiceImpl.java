package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HangKhachHangRepo;
import com.example.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {
    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public HangKhachHang getOne(int maHang) throws ResourceNotFoundException {
        Optional<HangKhachHang> findId = hangKhachHangRepo.findById(maHang);
        if (findId.isPresent()) {
            return findId.get();
        }
        throw new ResourceNotFoundException("HangKhachHang not found with id: " + maHang);
    }

    @Override
    public HangKhachHang add(HangKhachHang hangKhachHang) {
        return hangKhachHangRepo.save(hangKhachHang);
    }

    @Override
    public HangKhachHang update(int maHang, HangKhachHang hangKhachHang) throws ResourceNotFoundException {
        Optional<HangKhachHang> editHKH = hangKhachHangRepo.findById(maHang);
        if (editHKH.isPresent()) {
            HangKhachHang saveHKH = editHKH.get();
            saveHKH.setTenHang(hangKhachHang.getTenHang());
            saveHKH.setMoTa(hangKhachHang.getMoTa());
            saveHKH.setDiemToiThieu(hangKhachHang.getDiemToiThieu());
            saveHKH.setTrangThai(hangKhachHang.getTrangThai());
            return hangKhachHangRepo.save(saveHKH);
        }
        throw new ResourceNotFoundException("HangKhachHang not found with id" + maHang);
    }

    @Override
    public void delete(int maHang) {
        hangKhachHangRepo.deleteById(maHang);
    }
}
