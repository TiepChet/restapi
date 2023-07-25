package com.example.demo.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(long maKhachHang){
        super("Can not find object with id: "+maKhachHang);
    }

}
