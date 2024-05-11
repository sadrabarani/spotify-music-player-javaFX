package org.example.firstprojphase2;

import GUI.SetMainScene;
import GUI.SuccesPopUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Audio.Music;
import model.Database.Database;
import model.Genre;
import model.UserAccount.Singer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HelloApplication extends Application {

//    private static Stage stage;
//    private static Scene frsScene;
//    public static Stage getStage() {
//        return stage;
//    }
//    public static Scene getFrsScene() {
//        return frsScene;
//    }
//    public static void setStage(Stage stage) {
//        HelloApplication.stage = stage;
//    }
//    public static void setFrsScene(Scene frsScene) {
//        HelloApplication.frsScene = frsScene;
//    }
    public static ArrayList<Integer> whereAmI=new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        Singer singer=new Singer("sadr","23fyi!komr10>","sadra b","email@ofs.ocm","09876543212",new Date(1990,10,22),"agha ye seda");
        Music music=new Music(0,"title 1","sadr",12,11,new Date(1991,2,3),Genre.Country,"link","ad46dbb447cd0e9a6aeecd64cc2bd332b0cbcb79.jpeg","caption >>\n");
        Database.getDatabase().getUsers().add(singer);
        Database.getDatabase().getAudios().add(music);
//        setStage(stage);
        Scene scene = null;
        SuccesPopUp.setStage1(stage);
        SetMainScene.setStage(stage);
        try {
            SetMainScene.setScene(9);
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
//        try {
//            scene = new Scene(SetMainScene.setScene(3));
//        }catch (IOException ioException){
//            System.out.println(ioException.getMessage());
//        }
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
        stage.show();
//        try {
//            showSuccessfulMessage(stage);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }

    public static void main(String[] args) {
        launch();
    }
}