package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.repository.HangKhachHangRepo;
import com.example.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }
}
