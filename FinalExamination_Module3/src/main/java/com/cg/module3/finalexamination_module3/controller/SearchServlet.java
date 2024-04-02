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
@WebServlet(name = "SearchServlet", urlPatterns = "/search-student")
public class SearchServlet extends HttpServlet {
    private StudentService studentService;
    @Override
    public void init() throws ServletException {
        super.init();
        studentService = new StudentService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Student> students1 = studentService.searchStudentsByName(name);
        if (name != null && !name.isEmpty()) {
            List<Student> students = studentService.searchStudentsByName(name);
            request.setAttribute("students", students);
        }
        request.getRequestDispatcher("/students").forward(request, response);
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Search Form</title></head><body>");
        out.println("<h1>Search Form</h1>");
        out.println("<form action='search-student?name=' method='post'>");
        out.println("<input type='text' name='txt'>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}