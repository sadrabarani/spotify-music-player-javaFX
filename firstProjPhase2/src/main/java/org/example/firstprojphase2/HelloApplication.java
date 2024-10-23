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
import javafx.scene.image.Image;
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
        Music music=new Music(0,"title 1","sadr",14,10120,new Date(1991,2,3),Genre.Country,"http://dl.pmcmusic.tv/1397/08/Reza%20Pishro%20%26%20T-Dey%20-%20Aghrabe%20%28Ft%20Pedram%20Plus%29%20%5B128%5D.mp3","pishro1.jpg","caption >>\n");
        Music music1=new Music(1,"title 2","sadr",12,82221,new Date(1991,2,3),Genre.Country,"http://dl.pmcmusic.tv/1397/07/Reza%20Pishro%20Ft%20Ali%20Owj%20%26%20Ghadar%20-%20Jaraghe%20%5B128%5D.mp3","pishro2.jpg","caption >>\n");
        Music music2=new Music(2,"tabasom 2","tataloo",1112,121,new Date(1991,2,3),Genre.Rock,"https://dl.my-ahangha.ir/up/2023/Amir%20Tataloo%20-%20Tabassome%20Dard%20128.mp3","Amir Tataloo - Tabassome Dard.jpg","caption >>\n");
        Music music3=new Music(3,"chesmato beband","tataloo",12,11,new Date(1991,2,3),Genre.Country,"https://dl.my-ahangha.ir/up/2023/Amir%20Tataloo%20-%20Cheshmato%20Az%20Hame%20Bedozd%20128.mp3","Amir Tataloo - Cheshmato Az Hame Bedozd.jpg","caption >>\n");
        Music music4=new Music(4,"koche akhar","mohsen chavoshi",12,11,new Date(1991,2,3),Genre.Country,"https://dl.my-ahangha.ir/up/2024/Mohsen%20Chavoshi%20-%20Koocheye%20Akhar%20128.mp3","Mohsen Chavoshi - Koocheye Akhar.jpg","caption >>\n");
        Music music5=new Music(5,"jahan lahar ","mohsen chavoshi",12,11,new Date(1991,2,3),Genre.Pop,"https://dl.my-ahangha.ir/up/2024/Mohsen%20Chavoshi%20-%20Jahane%20Laghar%20128.mp3","Mohsen Chavoshi - Jahane Laghar.jpg","caption >>\n");
        Music music6=new Music(6,"zare bin","mohsen chavoshi",12,11,new Date(1991,2,3),Genre.Country,"https://dl.my-ahangha.ir/up/2023/Mohsen%20Chavoshi%20-%20Zarre%20Bin%20128.mp3","Mohsen Chavoshi - Zarre Bin.jpg","caption >>\n");
        Music music7=new Music(7,"yar juny","aron afshar",12,11,new Date(1991,2,3),Genre.Country,"https://dl.my-ahangha.ir/up/2024/Aron%20Afshar%20-%20Yare%20Jooni%20128.mp3","Aron Afshar - Yare Jooni.jpg","caption >>\n");
        Music music8=new Music(8,"dashe golam","sepehr khalse",12,11,new Date(1991,2,3),Genre.Country,"https://dl.my-ahangha.ir/up/2022/Sepehr%20Khalse%20-%20Dashe%20Golam%20128.mp3","Sepehr Khalse - Dashe Golam.jpg","caption >>\n");
        singer.getAlbums().add(music);
        Database.getDatabase().getUsers().add(singer);
        Database.getDatabase().getAudios().add(music);
        Database.getDatabase().getAudios().add(music1);
        Database.getDatabase().getAudios().add(music2);
        Database.getDatabase().getAudios().add(music3);
        Database.getDatabase().getAudios().add(music4);
        Database.getDatabase().getAudios().add(music5);
        Database.getDatabase().getAudios().add(music6);
        Database.getDatabase().getAudios().add(music7);
        Database.getDatabase().getAudios().add(music8);
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
        String path1= HelloApplication.class.getResource("images/icones.jpg").toExternalForm();
        Image image1=new Image(path1);
        stage.getIcons().add(image1);
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
