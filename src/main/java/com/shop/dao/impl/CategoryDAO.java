package com.shop.dao.impl;

import com.shop.dao.ICategoryDAO;
import com.shop.model.CategoryModel;

import java.sql.*;
import java.util.*;

public class CategoryDAO implements ICategoryDAO {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
            String user = "root";
            String password = "123456789";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> results = new ArrayList<>();
        String sql = "SELECT * FROM category";
        //open connection
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql); // Truyền câu query vào
                resultSet = statement.executeQuery(); //execute câu query trả về ResultSet
                while(resultSet.next()) {
                    CategoryModel category = new CategoryModel();
                    category.setId(resultSet.getLong("id")); //truyền vào vị trí cột hoặc tên cột
                    category.setCode(resultSet.getString("code"));
                    category.setName(resultSet.getString("name"));
                    results.add(category);
                }
                return results;
            } catch (SQLException e) {
                return null;
            } finally {
                try {
                    if(connection != null){
                        connection.close();
                    }
                    if(statement != null){
                        statement.close();
                    }
                    if(resultSet != null){
                        resultSet.close();
                    }
                } catch (SQLException e){
                    return null;
                }
            }
        }
        return null;
    }
}
