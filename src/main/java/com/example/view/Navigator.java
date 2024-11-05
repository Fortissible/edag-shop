package com.example.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigator {
    public static void showLoginView(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Navigator.class.getResource("/com/example/view/LoginView.fxml"));
        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Login");
        stage.show();
    }

    public static void showProductView(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Navigator.class.getResource("/com/example/view/ProductView.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Products");
        stage.show();
    }
}
