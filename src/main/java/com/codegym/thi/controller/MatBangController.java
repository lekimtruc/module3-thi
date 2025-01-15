package com.codegym.thi.controller;

import com.codegym.thi.model.MatBang;
import com.codegym.thi.service.MatBangService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MatBangController", urlPatterns = {"/matbang", "/matbang/them"})
public class MatBangController extends HttpServlet {

    private MatBangService matBangService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        matBangService = new MatBangService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/matbang":
//                req.setAttribute("matbang", matBangService.getStudents());
                req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);
                break;

            case "/matbang/them":
                req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/matbang/them":
                req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);

                String maMatBang = req.getParameter("maMatBang");
                String trangThai = req.getParameter("trangThai");
                float dienTich = Float.parseFloat(req.getParameter("dienTich"));
                int tang = Integer.parseInt(req.getParameter("tang"));
                String loaiMatBang = req.getParameter("loaiMatBang");
                double giaTien = Double.parseDouble(req.getParameter("giaTien"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat databaseFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date ngayBatDau = null;
                Date ngayKetThuc = null;
                try {
                    Date displayNgayBatDau = dateFormat.parse(req.getParameter("ngayBatDau"));
                    Date displayNgayKetThuc = dateFormat.parse(req.getParameter("ngayKetThuc"));

                    String databaseNgayBatDau = databaseFormat.format(displayNgayBatDau);
                    String databaseNgayKetThuc = databaseFormat.format(displayNgayKetThuc);

                    ngayBatDau = databaseFormat.parse(databaseNgayBatDau);
                    ngayKetThuc = databaseFormat.parse(databaseNgayKetThuc);
                } catch (ParseException e) {
                    e.printStackTrace();
                    req.setAttribute("errorMessage1", "Định dạng ngày không hợp lệ.");
                    req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);
                    return;
                }

                if (matBangService.kiemTraMatBang(maMatBang)) {
                    req.setAttribute("errorMessage2", "Mã mặt bằng vừa thêm đã tồn tại.");
                    req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);
                }else {
                    MatBang matBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);
                    matBangService.themMatBang(matBang);
                    req.setAttribute("message", "Thêm mặt bằng thành công");
                    req.getRequestDispatcher("/WEB-INF/view/matbang/them_mat_bang.jsp").forward(req, resp);
                }
                break;
        }
    }
}