package GUI.mainSection;

import GUI.IsLogin;
import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.SuccesPopUp;
import controller.ListenerControler;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.UserAccount.Artist;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AllArtistsFxml implements Initializable {

    @FXML
    private ListView allArtistsList;

    //todo add artist to data base
    @FXML
    private Button backBtn;

    ArrayList<Artist> artists=new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artists= ListenerControler.getListenerControler().showArtists();
        allArtistsList.getItems().addAll(artists);
        allArtistsList.setCellFactory(lv -> new ListCell<Artist>() {
            @Override
            protected void updateItem(Artist artist, boolean empty) {
                super.updateItem(artist, empty);
                if (empty || artist == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(artist.toString());
                    setStyle("-fx-background-color: black; -fx-text-fill: white;");
                }
            }
        });

        allArtistsList.setOnMouseClicked(e -> {
            Artist artist = (Artist) allArtistsList.getSelectionModel().getSelectedItem();
            if (artist != null) {
                ArtistInfofxml.artist = artist;
                HelloApplication.whereAmI.add(8);
                try {
                    SetMainScene.setScene(8);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        backBtn.setOnMouseClicked(e->{
            HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
            try {
                SuccesPopUp.showSuccessfulMessage();
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

