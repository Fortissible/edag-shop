package com.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.utils.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductController {
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, Double> priceColumn;
    @FXML private TableColumn<Product, String> descriptionColumn;

    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadProducts();
    }

    private void loadProducts() {
        try (Connection connection = Database.getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            ObservableList<Product> products = FXCollections.observableArrayList(productDAO.getAllProducts());
            productTable.setItems(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

