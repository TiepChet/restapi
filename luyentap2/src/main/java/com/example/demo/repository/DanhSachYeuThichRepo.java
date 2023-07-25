package com.example.demo.repository;

import com.example.demo.entity.DanhSachYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DanhSachYeuThichRepo extends JpaRepository<DanhSachYeuThich, UUID> {

    @Query("SELECT p FROM DanhSachYeuThich p WHERE " + " p.ngayTao LIKE CONCAT('%',:ngayTao,'%')")
    List<DanhSachYeuThich> search(String ngayTao);


}
