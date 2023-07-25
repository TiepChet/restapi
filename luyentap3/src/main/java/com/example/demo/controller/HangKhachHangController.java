package com.example.demo.controller;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HangKhachHangController {

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/hien-thi")
    public ResponseEntity<List<HangKhachHang>> hienThi() {
        List<HangKhachHang> hangKhachHangs = hangKhachHangService.getAll();
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @PostMapping("/add")
    public ResponseEntity<HangKhachHang> add(@RequestBody HangKhachHang hangKhachHang) {
        HangKhachHang hangKhachHangs = hangKhachHangService.add(hangKhachHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @PutMapping("/update/{maHang}")
    public ResponseEntity<HangKhachHang> update(@PathVariable("maHang") int maHang, @RequestBody HangKhachHang hangKhachHang) throws ResourceNotFoundException {
        HangKhachHang hangKhachHangs = hangKhachHangService.update(maHang, hangKhachHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @DeleteMapping("/delete/{maHang}")
    public ResponseEntity<?> delete(@PathVariable("maHang") int maHang) {
        hangKhachHangService.delete(maHang);
        return ResponseEntity.ok().build();
    }

}
