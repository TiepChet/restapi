package com.example.demo.service;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    HangKhachHang getOne(int maHang) throws ResourceNotFoundException;

    HangKhachHang add(HangKhachHang hangKhachHang);

    HangKhachHang update(int maHang, HangKhachHang hangKhachHang) throws ResourceNotFoundException;

    void delete(int maHang);
}
