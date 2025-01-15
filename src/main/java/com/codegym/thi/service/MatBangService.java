package com.codegym.thi.service;

import com.codegym.thi.dao.MatBangDao;
import com.codegym.thi.model.MatBang;

import java.sql.SQLException;
import java.util.List;

public class MatBangService {
    private MatBangDao matBangDao;

    public boolean kiemTraMatBang(String maMatBang) {
        return matBangDao.kiemTraMaMatBang(maMatBang);
    }

    public void themMatBang(MatBang matBang){
        try {
            boolean isExist = kiemTraMatBang(matBang.getMaMatBang());
            if(!isExist){
                matBangDao.themMatBang(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MatBang> listMatBang(){
        return matBangDao.listMatBang();
    }

    public List<MatBang> findMatBangByLoaiMatBang(String loaiMatHang){
        return matBangDao.findMatBangByLoaiMatBang(loaiMatHang);
    }

    public List<MatBang> findMatBangByGiaTien(double giaTien){
        return matBangDao.findMatBangByGiaTien(giaTien);
    }

    public List<MatBang> findMatBangByTang(int tang){
        return matBangDao.findMatBangByTang(tang);
    }
}
