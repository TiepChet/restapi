package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(long maKhachHang) throws ResourceNotFoundException;

    KhachHang add(KhachHang khachHang);

    KhachHang update(long maKhachHang, KhachHang khachHang) throws  ResourceNotFoundException;

    void  delete(long maKhachHang);
}
