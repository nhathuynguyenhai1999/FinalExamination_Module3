package com.cg.module3.finalexamination_module3.service;

import com.cg.module3.finalexamination_module3.DBContext.DBContext;
import com.cg.module3.finalexamination_module3.Model.Classroom;
import com.cg.module3.finalexamination_module3.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT s.*, c.id as classroom_id, c.name AS classroom_name " +
                "FROM Student s " +
                "INNER JOIN Classroom c ON s.classroom_id = c.id";
        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setDob(resultSet.getDate("dob").toLocalDate());
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setClassroomId(resultSet.getInt("classroom_id"));
                int idClass = resultSet.getInt("classroom_id");
                String nameClass = resultSet.getString("classroom_name");
                Classroom classroom = new Classroom(idClass, nameClass);
                student.setClassroom(classroom); // Thêm thông tin về tên lớp học
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public Student getStudentById(int id) {
        Student student = null;
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Student WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setDob(resultSet.getDate("dob").toLocalDate());
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setClassroomId(resultSet.getInt("classroom_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void addStudent(Student student) {
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Student (name, email, dob, address, phone_number, classroom_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setDate(3, Date.valueOf(student.getDob()));
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setInt(6, student.getClassroomId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Student SET name = ?, email = ?, dob = ?, address = ?, phone_number = ?, classroom_id = ? WHERE id = ?")) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setDate(3, Date.valueOf(student.getDob()));
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setInt(6, student.getClassroomId());
            statement.setInt(7, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Student WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchStudentsByName(String name) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBContext.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Student WHERE name LIKE ?")) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setDob(resultSet.getDate("dob").toLocalDate());
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setClassroomId(resultSet.getInt("classroom_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

