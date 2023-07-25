package com.example.demo.controller;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.entity.KhachHang;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.DanhSachYeuThichService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class DanhSachYeuThichController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    DanhSachYeuThichService danhSachYeuThichService;

    @GetMapping("/index")
    public ResponseEntity<List<DanhSachYeuThich>> hienThi() {
        khachHangService.getAll();
        List<DanhSachYeuThich> danhSachYeuThiches = danhSachYeuThichService.getAll();
        return ResponseEntity.ok().body(danhSachYeuThiches);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DanhSachYeuThich>> search(@RequestParam("ngayTao") String ngayTao) {
        khachHangService.getAll();
        List<DanhSachYeuThich> danhSachYeuThiches = danhSachYeuThichService.search(ngayTao);
        return ResponseEntity.ok().body(danhSachYeuThiches);
    }

    @PostMapping("/add")
    public ResponseEntity<DanhSachYeuThich> add(@RequestBody DanhSachYeuThich danhSachYeuThich) {
        DanhSachYeuThich danhSachYeuThichs = danhSachYeuThichService.add(danhSachYeuThich);
        return ResponseEntity.ok().body(danhSachYeuThichs);
    }

    @PutMapping("/update/{maDanhSach}")
    public ResponseEntity<DanhSachYeuThich> update(@PathVariable("maDanhSach") UUID maDanhSach,
                                                   @RequestBody DanhSachYeuThich danhSachYeuThich) throws ResourceNotFoundException {
        DanhSachYeuThich danhSachYeuThichs = danhSachYeuThichService.update(maDanhSach, danhSachYeuThich);
        return ResponseEntity.ok().body(danhSachYeuThichs);
    }

    @DeleteMapping("/delete/{maDanhSach}")
    public ResponseEntity<?> delete(@PathVariable("maDanhSach") UUID maDanhSach) {
        danhSachYeuThichService.delete(maDanhSach);
        return ResponseEntity.ok().build();
    }


}
