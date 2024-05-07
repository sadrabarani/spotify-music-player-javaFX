package GUI.mainSection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.UserAccount.Artist;

public class ArtistInfofxml {
    public static Artist artist;

    public static Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @FXML
    private Button FollowBtn;

    @FXML
    private Label artistInfoLbl;

    @FXML
    private Button backBtn;

    @FXML
    private ListView<?> listMusicOfArtist;

    @FXML
    private TextArea reportDis;

    @FXML
    private Button subReport;

}

