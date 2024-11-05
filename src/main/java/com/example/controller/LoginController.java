// src/main/java/org/example/controller/LoginController.java
package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.dao.UserDAO;
import com.example.model.User;
import com.example.utils.Database;
import com.example.view.Navigator;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try (Connection connection = Database.getConnection()) {
            UserDAO userDAO = new UserDAO(connection);
            User user = userDAO.getUserByUsernameAndPassword(username, password); // Panggil Model
            if (user != null) {
                // Navigate to ProductView on successful login
                Navigator.showProductView((Stage) usernameField.getScene().getWindow());
            } else {
                errorLabel.setText("Invalid username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorLabel.setText("Database error occurred.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
