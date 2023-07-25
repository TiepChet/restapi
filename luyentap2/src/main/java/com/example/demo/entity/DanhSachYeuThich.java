package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "danhsachyeuthich")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DanhSachYeuThich {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "madanhsach")
    private UUID maDanhSach;

    @Column(name = "ngaytao")
    private String ngayTao;

    @Column(name = "ngaycapnhap")
    private String ngayCapNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;



}
