package com.example.demo.service.impl;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DanhSachYeuThichRepo;
import com.example.demo.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhSachYeuThichServiceImpl implements DanhSachYeuThichService {

    @Autowired
    DanhSachYeuThichRepo danhSachYeuThichRepo;

    @Override
    public List<DanhSachYeuThich> getAll() {
        return danhSachYeuThichRepo.findAll();
    }

    @Override
    public DanhSachYeuThich getOne(UUID maDanhSach) throws ResourceNotFoundException {
        Optional<DanhSachYeuThich> findID = danhSachYeuThichRepo.findById(maDanhSach);
        if (findID.isPresent()) {
            return findID.get();
        }
        throw new ResourceNotFoundException("DanhSachYT not find with id: " + maDanhSach);
    }

    @Override
    public DanhSachYeuThich add(DanhSachYeuThich danhSachYeuThich) {
        return danhSachYeuThichRepo.save(danhSachYeuThich);
    }

    @Override
    public DanhSachYeuThich update(UUID maDanhSach, DanhSachYeuThich danhSachYeuThich) throws ResourceNotFoundException {
        Optional<DanhSachYeuThich> findID = danhSachYeuThichRepo.findById(maDanhSach);
        if (findID.isPresent()) {
            DanhSachYeuThich updateDSYT = findID.get();
            updateDSYT.setKhachHang(danhSachYeuThich.getKhachHang());
            updateDSYT.setNgayCapNhap(danhSachYeuThich.getNgayCapNhap());
            updateDSYT.setNgayTao(danhSachYeuThich.getNgayTao());
            return danhSachYeuThichRepo.save(updateDSYT);
        }
        throw new ResourceNotFoundException("DanhSachYT not find with id: " + maDanhSach);
    }

    @Override
    public void delete(UUID maDanhSach) {
        danhSachYeuThichRepo.deleteById(maDanhSach);
    }

    @Override
    public List<DanhSachYeuThich> search(String ngayTao) {
        return danhSachYeuThichRepo.search(ngayTao);
    }
}
