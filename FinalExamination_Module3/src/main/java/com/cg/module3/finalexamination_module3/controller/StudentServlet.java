package com.cg.module3.finalexamination_module3.controller;

import com.cg.module3.finalexamination_module3.service.StudentService;
import com.cg.module3.finalexamination_module3.Model.Student;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "StudentServlet",  urlPatterns = "/students")
//@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;
    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}