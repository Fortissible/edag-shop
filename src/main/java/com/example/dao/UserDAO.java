package com.example.dao;

import com.example.model.User;
import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"));
        }
        return null;
    }
}
