package com.cg.module3.finalexamination_module3.service;

import com.cg.module3.finalexamination_module3.DBContext.DBContext;
import com.cg.module3.finalexamination_module3.Model.Classroom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    public List<Classroom> getAllClassroom(){
        List<Classroom> classrooms = new ArrayList<>();
        String query = "SELECT * " +
                "FROM classroom";
        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Classroom c = new Classroom();
                c.setId(resultSet.getInt("id"));
                c.setName(resultSet.getString("name"));
                classrooms.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }
}
