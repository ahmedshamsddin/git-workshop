package com.ims;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;


public class AdditemMenu extends Application {

    
     @Override
     public void start(Stage primaryStage) throws Exception {
          Group root = new Group();
          Scene scene = new Scene(root,600,600,Color.WHITE);
          primaryStage.setScene(scene); 

          Rectangle topBar = new Rectangle();
          Text Text1 = new Text();

          topBar.setFill(Color.DARKBLUE); 
          topBar.setHeight(70);
          topBar.widthProperty().bind(scene.widthProperty());
   
          Text1.setText("IMS DASHBOARD\tHOME\tREPORTING\tCONFIGRATION");
          Text1.setX(40);
          Text1.setY(40);
          Text1.setFont(Font.font("Verdana",20));
          Text1.setFill(Color.WHITE);

          Rectangle lowerBar = new Rectangle(); 
          lowerBar.setFill(Color.DARKBLUE);
          lowerBar.setHeight(50);
          lowerBar.widthProperty().bind(scene.widthProperty()); 
          lowerBar.yProperty().bind(scene.heightProperty().subtract(lowerBar.getHeight()));;

          Text Text2 = new Text();
          Text2.setText("@Sater TEAM 2024");
          Text2.setFont(Font.font("Verdana", 15));
          Text2.setFill(Color.WHITE);
         

               
          // Set Text2 position in the middle of the lowerBar
          Text2.xProperty().bind(lowerBar.widthProperty().subtract(Text2.getBoundsInLocal().getWidth()).divide(2));
          Text2.yProperty().bind(lowerBar.yProperty().add(lowerBar.getHeight()/2).add(Text2.getBoundsInLocal().getHeight() / 2));

        // Make Text2 font size flexible with the scene's height
         Text2.fontProperty().bind(Bindings.createObjectBinding(() ->
                Font.font("Verdana", scene.getHeight() * 0.03), scene.heightProperty()));


                Rectangle middleBox= new Rectangle();
                middleBox.setFill(Color.LIGHTBLUE);
                middleBox.setArcHeight(20);
                middleBox.setArcWidth(20);
                

         // Bind middleBox size to 70% of the smaller dimension of the scene
        middleBox.widthProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).multiply(0.6));
        middleBox.heightProperty().bind(middleBox.widthProperty());

        // Bind middleBox position to center of the scene
        middleBox.xProperty().bind(scene.widthProperty().subtract(middleBox.widthProperty()).divide(2));
        middleBox.yProperty().bind(scene.heightProperty().subtract(middleBox.heightProperty()).divide(2));

          root.getChildren().addAll(topBar,Text1,lowerBar,Text2,middleBox);                
          primaryStage.setScene(scene);
          primaryStage.show(); 
     }

     public static void main(String[] args) {
        launch(args);
    }

}


