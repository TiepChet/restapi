package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.HangKhachHangService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HangKhachHangService hangKhachHangService;


    @GetMapping("/hangkh")
    public ResponseEntity hienThiHKH() {
        return new ResponseEntity(hangKhachHangService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/hien-thi")
    public ResponseEntity<List<KhachHang>> getAll() {
        hangKhachHangService.getAll();
        List<KhachHang> khachHangs = khachHangService.getAll();
        return ResponseEntity.ok().body(khachHangs);
    }

    @GetMapping("/{maKhachHang}")
    public ResponseEntity<KhachHang> getById(@PathVariable("maKhachHang") long maKhachHang) throws ResourceNotFoundException {
        KhachHang khachHang = khachHangService.getOne(maKhachHang);
        return ResponseEntity.ok().body(khachHang);
    }

    @PostMapping("/add")
    public ResponseEntity<KhachHang> add(@RequestBody KhachHang khachHang) {
        KhachHang add = khachHangService.add(khachHang);
        return ResponseEntity.ok().body(add);
    }

    @PutMapping("/update/{maKhachHang}")
    public ResponseEntity<KhachHang> update(@PathVariable("maKhachHang") long maKhachHang,
                                            @RequestBody KhachHang khachHang) throws ResourceNotFoundException {
        KhachHang saveKhachHang = khachHangService.update(maKhachHang, khachHang);
        return ResponseEntity.ok().body(saveKhachHang);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public ResponseEntity<?> delete(@PathVariable("maKhachHang") long maKhachHang) {
        khachHangService.delete(maKhachHang);
        return ResponseEntity.ok().build();
    }

}
