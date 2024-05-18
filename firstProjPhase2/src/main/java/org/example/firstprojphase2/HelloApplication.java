package org.example.firstprojphase2;

import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.SuccesPopUp;
import GUI.Warning;
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
        Music music=new Music(0,"title 1","sadr",14,100,new Date(1991,2,3),Genre.Country,"http://dl.pmcmusic.tv/1397/08/Reza%20Pishro%20%26%20T-Dey%20-%20Aghrabe%20%28Ft%20Pedram%20Plus%29%20%5B128%5D.mp3","pishro1.jpg","caption >>\n");
        Music music1=new Music(0,"title 2","sadr",12,11,new Date(1991,2,3),Genre.Country,"http://dl.pmcmusic.tv/1397/07/Reza%20Pishro%20Ft%20Ali%20Owj%20%26%20Ghadar%20-%20Jaraghe%20%5B128%5D.mp3","pishro2.jpg","caption >>\n");
        singer.getAlbums().add(music);
        Database.getDatabase().getUsers().add(singer);
        Database.getDatabase().getAudios().add(music);
       // Database.getDatabase().getAudios().add(music1);
//        setStage(stage);
        Scene scene = null;
        PlayBar.setAudioArrayList(Database.getDatabase().getAudios());
        PlayBar.setAudio(Database.getDatabase().getAudios().get(0));

        SuccesPopUp.setStage1(stage);
        SetMainScene.setStage(stage);
        try {
            HelloApplication.whereAmI.add(9);
            SetMainScene.setScene(9);
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
//        try {
//            scene = new Scene(SetMainScene.setScene(3));
//        }catch (IOException ioException){
//            System.out.println(ioException.getMessage());
//        }
        stage.setTitle("music player");
//        stage.setScene(scene);
        stage.show();

//        stage.setOnCloseRequest(e->{
//            Warning.warning("have a good day","finished");
//        });
//        try {
//            showSuccessfulMessage(stage);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }
//todo  ezafe kardan be array to play bar sort bar asas like  my play list
//    todo data base
//    todo add song to singer
//    todo clean the shit
//    todo debug
    public static void main(String[] args) {
        launch();
    }
}