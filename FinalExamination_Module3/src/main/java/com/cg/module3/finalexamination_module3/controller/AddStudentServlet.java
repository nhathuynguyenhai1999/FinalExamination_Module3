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

@WebServlet(name = "AddStudentServlet",  urlPatterns = "/add-student")
public class AddStudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private ClassroomService classroomService = new ClassroomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Classroom> classrooms = classroomService.getAllClassroom();

        req.setAttribute("classrooms", classrooms);
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob")); // Chú ý kiểm tra định dạng ngày
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setDob(dob);
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        student.setClassroomId(classroomId);
        studentService.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
