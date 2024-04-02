package com.cg.module3.finalexamination_module3.controller;

import com.cg.module3.finalexamination_module3.service.StudentService;
import com.cg.module3.finalexamination_module3.Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "SearchServlet",  urlPatterns = "/search-student")
public class SearchServlet extends HttpServlet {
    private StudentService studentController;
    @Override
    public void init() throws ServletException {
        super.init();
        studentController = new StudentService();
    }
    @Override
    protected void doGet(HttpServletRequest request2, HttpServletResponse response2) throws ServletException, IOException{
        String name = request2.getParameter("name");
        List<Student> students = studentController.searchStudentsByName(name);
        request2.setAttribute("students",students);
        request2.getRequestDispatcher("/students").forward(request2,response2);
        response2.setContentType("text/html");
        PrintWriter out = response2.getWriter();
        out.println("<html><head><title>Search Form</title></head><body>");
        out.println("<h1>Search Form</h1>");
        out.println("<form action='search-student?name=' method='post'>");
        out.println("<input type='text' name='txt'>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request2, HttpServletResponse response2) throws ServletException,IOException{
        String name = request2.getParameter("name");
        if (name!=null&&!name.isEmpty()){
            System.out.println("Found the searching letter"+name);
        }else{
            System.out.println("Cannot found the searching word.");
        }
    }
}
