package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.util.ArrayList;

public class SetMainScene {
    public static FXMLLoader setMainSection(int secNum){
        switch (secNum) {
            case 1: //listener panel
                FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
                fxmlLoader.setRoot(new AnchorPane());
                return fxmlLoader;
            case 2: //login panel
                FXMLLoader fxmlLoader2=new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                fxmlLoader2.setRoot(new AnchorPane());
                return fxmlLoader2;
            case 3: //favorite genre
                FXMLLoader fxmlLoader3=new FXMLLoader(HelloApplication.class.getResource("fav_Genre.fxml"));
                //fxmlLoader3.setRoot(new AnchorPane());
                return fxmlLoader3;
            case 4: // play music
                FXMLLoader fxmlLoader4=new FXMLLoader(HelloApplication.class.getResource("play_music.fxml"));
              //  fxmlLoader4.setRoot(new AnchorPane());
                return fxmlLoader4;
//            case 5:  //todo singer panel
//                FXMLLoader fxmlLoader5=new FXMLLoader(HelloApplication.class.getResource());
//                return fxmlLoader5;
            case 6: //all audios
                FXMLLoader fxmlLoader6=new FXMLLoader(HelloApplication.class.getResource("all-AudiosFxml.fxml"));
               // fxmlLoader6.setRoot(new AnchorPane());
                return fxmlLoader6;
            case 7: //all artist
                FXMLLoader fxmlLoader7=new FXMLLoader(HelloApplication.class.getResource("all_ArtistsFxml.fxml"));
                //fxmlLoader7.setRoot(new AnchorPane());
                return fxmlLoader7;
            case 8: // artist info
                FXMLLoader fxmlLoader8=new FXMLLoader(HelloApplication.class.getResource("artist_infofxml.fxml"));
              //  fxmlLoader8.setRoot(new AnchorPane());
                return fxmlLoader8;
            case 9: // home page for not login people
                FXMLLoader fxmlLoader9=new FXMLLoader(HelloApplication.class.getResource("home_sortLikeListFxml.fxml"));
               // fxmlLoader9.setRoot(new AnchorPane());
                return fxmlLoader9;
            case 10: //home page for login people
                FXMLLoader fxmlLoader10=new FXMLLoader(HelloApplication.class.getResource("home_SugestForLogin.fxml"));
               // fxmlLoader10.setRoot(new AnchorPane());
                return fxmlLoader10;
            case 11: //Audio of play list
                FXMLLoader fxmlLoader11=new FXMLLoader(HelloApplication.class.getResource("audioOf_playList.fxml"));
                fxmlLoader11.setRoot(new AnchorPane());
                return fxmlLoader11;
            case 12: //search result
                FXMLLoader fxmlLoader12=new FXMLLoader(HelloApplication.class.getResource("search_page.fxml"));
              //  fxmlLoader12.setRoot(new AnchorPane());
                return fxmlLoader12;
        }
        return new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
    }
    public static Stage stage11;
    public static Parent setScene(int secNum) throws IOException {
//        HelloApplication.whereAmI.add(secNum);
        FXMLLoader fxmlLoader= SetMainScene.setMainSection(secNum);
        FXMLLoader sideFxml=new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader playBarFxml=new FXMLLoader(HelloApplication.class.getResource("play_bar.fxml"));
        HBox splitPane = new HBox();
        VBox vBox = new VBox();
        splitPane.getChildren().add(sideFxml.load());
        splitPane.getChildren().add(fxmlLoader.load());
        vBox.getChildren().addAll(splitPane,playBarFxml.load());
        stage11.setScene(new Scene(vBox));
        return vBox;
    }

    public static void setStage(Stage stage1){
        stage11=stage1;
    }
}
