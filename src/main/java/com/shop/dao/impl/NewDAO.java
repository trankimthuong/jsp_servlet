package com.shop.dao.impl;

import com.shop.dao.INewDAO;
import com.shop.model.NewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO implements INewDAO {
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
    public List<NewModel> findByCategoryId(Long categoryId) {
        List<NewModel> results = new ArrayList<>();
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        //open connection
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                statement = connection.prepareStatement(sql); // Truyền câu query vào
                statement.setLong(1, categoryId);
                resultSet = statement.executeQuery(); //execute câu query trả về ResultSet
                while(resultSet.next()) {
                    NewModel newModel = new NewModel();
                    newModel.setId(resultSet.getLong("id")); //truyền vào vị trí cột hoặc tên cột
                    newModel.setTitle(resultSet.getString("title"));
                    newModel.setShortDescription(resultSet.getString("shortdescription"));
                    results.add(newModel);
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
