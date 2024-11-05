// src/main/java/org/example/App.java
package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.view.Navigator;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigator.showLoginView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
