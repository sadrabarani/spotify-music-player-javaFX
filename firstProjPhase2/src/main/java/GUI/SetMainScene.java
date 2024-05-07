package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;

public class SetMainScene {
    public static FXMLLoader setMainSection(int secNum){
        switch (secNum) {
            case 1: //listener panel
                FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
                return fxmlLoader;
            case 2: //login panel
                FXMLLoader fxmlLoader2=new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                return fxmlLoader2;
            case 3: //favorite genre
                FXMLLoader fxmlLoader3=new FXMLLoader(HelloApplication.class.getResource("fav_Genre.fxml"));
                return fxmlLoader3;
            case 4: // play music
                FXMLLoader fxmlLoader4=new FXMLLoader(HelloApplication.class.getResource("play_music.fxml"));
                return fxmlLoader4;
            case 5: //sign in panel
                FXMLLoader fxmlLoader5=new FXMLLoader(HelloApplication.class.getResource("signInPg.fxml"));
                return fxmlLoader5;
            case 6: //all audios
                FXMLLoader fxmlLoader6=new FXMLLoader(HelloApplication.class.getResource("all-AudiosFxml.fxml"));
                return fxmlLoader6;
            case 7: //all artist
                FXMLLoader fxmlLoader7=new FXMLLoader(HelloApplication.class.getResource("all_ArtistsFxml.fxml"));
                return fxmlLoader7;
            case 8: // artist info
                FXMLLoader fxmlLoader8=new FXMLLoader(HelloApplication.class.getResource("signInPg.fxml"));
                return fxmlLoader8;
            case 9: // home page for not login people
                FXMLLoader fxmlLoader9=new FXMLLoader(HelloApplication.class.getResource("home_sortLikeListFxml.fxml"));
                return fxmlLoader9;
            case 10: //home page for login people
                FXMLLoader fxmlLoader10=new FXMLLoader(HelloApplication.class.getResource("home_SugestForLogin.fxml"));
                return fxmlLoader10;
        }
        return new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
    }

    public static Parent setScene(int secNum) throws IOException {
        FXMLLoader fxmlLoader= SetMainScene.setMainSection(secNum);
        FXMLLoader sideFxml=new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader playBarFxml=new FXMLLoader(HelloApplication.class.getResource("play_bar.fxml"));
        HBox splitPane = new HBox();
        VBox vBox = new VBox();
        splitPane.getChildren().add(sideFxml.load());
        splitPane.getChildren().add(fxmlLoader.load());
        vBox.getChildren().addAll(splitPane,playBarFxml.load());
        return vBox;
    }
}
