package GUI.mainSection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.UserAccount.Artist;

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
    private ListView<?> artistsListview;

    @FXML
    private ListView<?> audiosListview;

    @FXML
    private Button backBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
