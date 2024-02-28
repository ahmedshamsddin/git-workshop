package com.ims;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



class itemlist extends Application {

    private TableView<InventoryItem> tableView;
    private final ObservableList<InventoryItem> data = FXCollections.observableArrayList();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) throws IOException{

        Parent root = new FXMLLoader(this.getClass().getResource("view.fxml")).load();
        //  Stage.setTitle("");
          stage.setScene(new Scene(root));
          stage.show();


        // Create table columns
        TableColumn<InventoryItem, String> itemNumberColumn = new TableColumn<>("#item_num");
        //itemNumberColumn.setCellValueFactory();

        TableColumn<InventoryItem, String> itemNameColumn = new TableColumn<>("#item_name");
        //itemNameColumn.setCellValueFactory();

        TableColumn<InventoryItem, String> itemPriceColumn = new TableColumn<>("#item_price");
         //itemNumberColumn.setCellValueFactory();
        TableColumn<InventoryItem, String> countColumn = new TableColumn<>("count");
          //itemNumberColumn.setCellValueFactory();

        // Create table view
        tableView = new TableView<>();
        tableView.getColumns().addAll(itemNumberColumn, itemNameColumn, itemPriceColumn, countColumn);
        tableView.setItems(data);

        // Create search field
        TextField searchField = new TextField();
        searchField.setPromptText("Search...");

        // Create buttons
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        // Add event handlers for buttons
        editButton.setOnAction(event -> {
            // Handle edit button click
            // ...
        });

        deleteButton.setOnAction(event -> {
            // Handle delete button click
            // ...
        });

        // Create layout
        HBox buttonBox = new HBox(10, searchField, editButton, deleteButton);
        VBox Root = new VBox(10, buttonBox, tableView);

        // Create scene and set stage
        Scene scene = new Scene(Root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Inventory Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class InventoryItem {

    private final String itemNumber;
    private final String itemName;
    private final String itemPrice;
    private final String count;

    public InventoryItem(String itemNumber, String itemName, String itemPrice, String count) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getCount() {
        return count;
    }

    public String getItemNumberProperty() {
        return itemNumber;
    }

    public String getItemNameProperty() {
        return itemName;
    }

    public String getItemPriceProperty() {
        return itemPrice;
    }

    public String getCountProperty() {
        return count;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}


