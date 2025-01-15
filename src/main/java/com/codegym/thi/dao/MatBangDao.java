package com.codegym.thi.dao;

import com.codegym.thi.connection.JdbcConnection;
import com.codegym.thi.model.MatBang;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MatBangDao {
    private Connection connection;
    private List<MatBang> listMatBang;

    public MatBangDao(Connection connection) {
        this.connection = connection;
    }

    public List<MatBang> listMatBang() {
        listMatBang = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * FROM mat_bang LIMIT 10;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getFloat("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                listMatBang.add(matBang);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMatBang;
    }

    public List<MatBang> findMatBangByLoaiMatBang(String loaiMatBang) {
        listMatBang = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * " +
                    "FROM tcomplex WHERE loai_mat_bang = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loaiMatBang);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getFloat("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                listMatBang.add(matBang);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMatBang;
    }

    public List<MatBang> findMatBangByGiaTien(double giaTien) {
        listMatBang = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * " +
                    "FROM tcomplex WHERE gia_tien = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, giaTien);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getFloat("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                listMatBang.add(matBang);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMatBang;
    }

    public List<MatBang> findMatBangByTang(int tang) {
        listMatBang = new ArrayList<>();
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT * " +
                    "FROM tcomplex WHERE tang = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tang);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setDienTich(resultSet.getFloat("dien_tich"));
                matBang.setTang(resultSet.getInt("tang"));
                matBang.setLoaiMatBang(resultSet.getString("loai_mat_bang"));
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                listMatBang.add(matBang);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMatBang;
    }

    public boolean kiemTraMaMatBang(String maMatBang) {
        try {
            String query = "SELECT * FROM mat_bang WHERE ma_mat_bang = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maMatBang);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void themMatBang(MatBang matBang) throws SQLException {
        String query = "INSERT INTO mat_bang (ma_mat_bang, trang_thai, dien_tich, tang, loai_mat_bang, gia_tien, ngay_bat_dau, ngay_ket_thuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, matBang.getMaMatBang());
        ps.setString(2, matBang.getTrangThai());
        ps.setFloat(3, matBang.getDienTich());
        ps.setInt(4, matBang.getTang());
        ps.setString(5, matBang.getLoaiMatBang());
        ps.setDouble(6, matBang.getGiaTien());
        ps.setDate(7, new Date(matBang.getNgayBatDau().getTime()));
        ps.setDate(8, new Date(matBang.getNgayKetThuc().getTime()));
        ps.executeUpdate();
    }

    public boolean xoaMatBang(String maMatBang) {
        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "DELETE FROM mat_bang WHERE ma_mat_bang = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, maMatBang);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Xóa mặt bằng thành công");
                return true;
            } else {
                System.out.println("Xóa mặt bằng thất bại");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

