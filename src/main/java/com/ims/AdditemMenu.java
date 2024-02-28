package com.ims;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class AdditemMenu extends Application {

    
    private TextField createTextField(String prompt, double width, double height, double translateY, double translateX) {
        TextField textField = new TextField();
        textField.setPromptText(prompt);
        textField.setPrefWidth(width);
        textField.setPrefHeight(height);
        textField.setTranslateY(translateY);
        textField.setTranslateX(translateX);
        textField.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black;");
        return textField;
    }

    private Button createButton(String text, double width, double height, double translateX, double translateY, String style) {
        Button button = new Button(text);
        button.setPrefHeight(height);
        button.setPrefWidth(width);
        button.setTranslateX(translateX);
        button.setTranslateY(translateY);
        button.setStyle(style);
        return button;
    }


    @Override
     public void start(Stage primaryStage) throws Exception {
          Group root = new Group();
          Scene scene = new Scene(root,600,600,Color.WHITE);
          primaryStage.setScene(scene); 
          primaryStage.setHeight(700);
          primaryStage.setWidth(750);
          primaryStage.setResizable(false);


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
                middleBox.setFill(Color.SKYBLUE);
                middleBox.setArcHeight(20);
                middleBox.setArcWidth(20);
                

         // Bind middleBox size to 60% of the smaller dimension of the scene
        middleBox.widthProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).multiply(0.6));
        middleBox.heightProperty().bind(middleBox.widthProperty());

        // Bind middleBox position to center of the scene
        middleBox.xProperty().bind(scene.widthProperty().subtract(middleBox.widthProperty()).divide(2));
        middleBox.yProperty().bind(scene.heightProperty().subtract(middleBox.heightProperty()).divide(2)); 

             
        TextField itemID = createTextField("Enter Item ID please", 170, 70, 160, 200);
        TextField itemName = createTextField("Enter Item Name", 170, 70, 240, 200);
        TextField itemCount = createTextField("Enter Item quantity", 170, 70, 320, 200);
        TextField itemDescription = createTextField("Enter Item description", 300, 110, 400, 200);

        Button addButton = createButton("Add", 65, 65, 490, 160, "-fx-background-color: green; -fx-text-fill: white;");
        addButton.setOnAction(event -> handleAddButtonClick());

        Button deleteButton = createButton("Delete", 65, 65, 410, 160, "-fx-background-color: red; -fx-text-fill: white;");
        deleteButton.setOnAction(event -> handleDeleteButtonClick());
          

          root.getChildren().addAll(topBar,Text1,lowerBar,Text2,middleBox,itemID,itemName,itemCount,itemDescription,addButton,deleteButton);                
          primaryStage.setScene(scene); 
          primaryStage.show(); 
     }
    

     private void handleAddButtonClick() {
        System.out.println("Add button clicked!");
    }

    private void handleDeleteButtonClick() {
        System.out.println("Delete button clicked!");
    }

     public static void main(String[] args) {
        launch(args);
    }

}

/*
            TextField itemID = new TextField();
            itemID.setPromptText("Enter Item ID please");
            itemID.setPrefWidth(170);
            itemID.setPrefHeight(70);
            itemID.setTranslateY(160);
            itemID.setTranslateX(200);
            itemID.setStyle("-fx-background-color: #CCCCCC;-fx-text-fill: black;");  

            TextField itemName = new TextField();
            itemName.setPromptText("Enter Item Name");
            itemName.setPrefWidth(170);
            itemName.setPrefHeight(70);
            itemName.setTranslateY(240);
            itemName.setTranslateX(200);
            itemName.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black;"); 


            TextField itemCount = new TextField();
            itemCount.setPromptText("Enter Item quantity");
            itemCount.setPrefWidth(170);
            itemCount.setPrefHeight(70);
            itemCount.setTranslateY(320);
            itemCount.setTranslateX(200);
            itemCount.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black;"); 
          
            TextField itemDescription = new TextField();
            itemDescription.setPromptText("Enter Item description");
            itemDescription.setPrefWidth(300);
            itemDescription.setPrefHeight(110);
            itemDescription.setTranslateY(400);
            itemDescription.setTranslateX(200);
            itemDescription.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black;");
             
            Button addButton = new Button("Add"); 
            addButton.setPrefHeight(65);
            addButton.setPrefWidth(65);
            addButton.setTranslateX(490);
            addButton.setTranslateY(160);
            addButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
           
            Button deleteButton = new Button("Delete"); 
            deleteButton.setPrefHeight(65);
            deleteButton.setPrefWidth(65);
            deleteButton.setTranslateX(410);
            deleteButton.setTranslateY(160);
            deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
 */