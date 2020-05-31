package com.geekbrains.java2.homework4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
        primaryStage.setTitle("Simple network chat v0.1");
        primaryStage.setScene(new Scene(parent, 300, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
