package com.cg.module3.finalexamination_module3.controller;

import com.cg.module3.finalexamination_module3.Model.Classroom;
import com.cg.module3.finalexamination_module3.Model.Student;
import com.cg.module3.finalexamination_module3.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteServlet",  urlPatterns = "/delete-student")
public class DeleteServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    protected void doPost(HttpServletRequest request2, HttpServletResponse response1) throws ServletException, IOException {
        int id = Integer.parseInt(request2.getParameter("id"));
        studentService.deleteStudent(id);
        response1.sendRedirect(request2.getContextPath()+"/students");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
