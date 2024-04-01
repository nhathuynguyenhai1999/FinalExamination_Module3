package com.cg.module3.finalexamination_module3.controller;

import com.cg.module3.finalexamination_module3.service.StudentService;
import com.cg.module3.finalexamination_module3.Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet",  urlPatterns = "/edit-student")
public class EditServlet extends HttpServlet {
    private StudentService studentController;
    @Override
    public void init() throws ServletException {
        super.init();
        studentController = new StudentService();
    }
    @Override
    protected void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(requ.getParameter("id"));
        Student student = studentController.getStudentById(id);
        requ.setAttribute("student", student);
        requ.getRequestDispatcher("/edit.jsp").forward(requ, resp);
    }
}
