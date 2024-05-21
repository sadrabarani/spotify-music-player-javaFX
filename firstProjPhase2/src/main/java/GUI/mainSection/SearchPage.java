package GUI.mainSection;

import GUI.PlayBar;
import GUI.SetMainScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.Database.Database;
import model.UserAccount.Artist;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchPage implements Initializable {
    private static ArrayList<Audio> audioArrayList=new ArrayList<>();
    private static ArrayList<Artist> artists=new ArrayList<>();

    public static void setAudioArrayList(ArrayList<Audio> audioArrayList) {
        SearchPage.audioArrayList = audioArrayList;
    }

    public static void setArrayList(ArrayList<Artist> artists) {
        SearchPage.artists = artists;
    }

    public static ArrayList<Audio> getAudioArrayList() {
        return audioArrayList;
    }

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    @FXML
    private ListView artistsListview;

    @FXML
    private ListView audiosListview;

    @FXML
    private Button backBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audiosListview.getItems().addAll(audioArrayList);
        audiosListview.setCellFactory(lv -> new ListCell<Audio>() {
            @Override
            protected void updateItem(Audio audio, boolean empty) {
                super.updateItem(audio, empty);
                if (empty || audio == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(audio.toString());
                    setStyle("-fx-background-color: black; -fx-text-fill: white;");
                }
            }
        });

        audiosListview.setOnMouseClicked(e -> {
            Audio audio = (Audio) audiosListview.getSelectionModel().getSelectedItem();
            if (audio != null) {
                PlayMusic.audio=audio;
                ArrayList<Audio> myArrayList = Database.getDatabase().getAudios();
                PlayBar.setAudioArrayList(myArrayList);
                PlayBar.setIndex(PlayBar.getAudioArrayList().indexOf(audio));
                PlayBar.setAudio(audio);
                PlayMusic.audio=audio;
                HelloApplication.whereAmI.add(4);
                try {
                    SetMainScene.setScene(4);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        artistsListview.getItems().addAll(artists);
        artistsListview.setCellFactory(lv -> new ListCell<Artist>() {
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

        artistsListview.setOnMouseClicked(e -> {
            Artist artist = (Artist) artistsListview.getSelectionModel().getSelectedItem();
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
    }
}
