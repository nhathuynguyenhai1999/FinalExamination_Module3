package com.cg.module3.finalexamination_module3.controller;

import com.cg.module3.finalexamination_module3.Model.Classroom;
import com.cg.module3.finalexamination_module3.service.ClassroomService;
import com.cg.module3.finalexamination_module3.service.StudentService;
import com.cg.module3.finalexamination_module3.Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update-student")
public class UpdateServlet extends HttpServlet {
    private StudentService studentService;
    private ClassroomService classroomService;
    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
        classroomService = new ClassroomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudentById(id);

        List<Classroom> classrooms = classroomService.getAllClassroom();
        req.setAttribute("student", student);
        req.setAttribute("classrooms", classrooms);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudentById(id);

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate dob = LocalDate.parse(req.getParameter("dob")); // Chú ý kiểm tra định dạng ngày
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        int classroomId = Integer.parseInt(req.getParameter("classroomId"));

        student.setName(name);
        student.setEmail(email);
        student.setAddress(address);
        student.setDob(dob);
        student.setPhoneNumber(phoneNumber);
        student.setClassroomId(classroomId);

        studentService.updateStudent(student);
        // Redirect back to students page
        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
