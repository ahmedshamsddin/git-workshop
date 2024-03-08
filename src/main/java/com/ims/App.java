package com.ims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static final String DATABASE_URL = "jdbc:sqlite:ims.db";

    @Override
    public void start(Stage stage) throws IOException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            System.out.println("Connection to database has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("add_item.fxml"));
        
        // loader.setController(new AddItemController());
        Parent root = loader.load();

        scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }
        
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}