package com.example.demo.service;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface DanhSachYeuThichService {

    List<DanhSachYeuThich> getAll();

    DanhSachYeuThich getOne(UUID maDanhSach) throws ResourceNotFoundException;

    DanhSachYeuThich add(DanhSachYeuThich danhSachYeuThich);

    DanhSachYeuThich update(UUID maDanhSach, DanhSachYeuThich danhSachYeuThich) throws ResourceNotFoundException;

    void delete(UUID maDanhSach);

    List<DanhSachYeuThich> search(String ngayTao);

}
