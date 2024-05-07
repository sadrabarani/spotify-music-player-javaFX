package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.UserAccount.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistInfofxml implements Initializable {
    public static Artist artist;

    public static Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @FXML
    private Button followBtn;

    @FXML
    private Label artistInfoLbl;

    @FXML
    private Button backBtn;

    @FXML
    private ListView listMusicOfArtist;

    @FXML
    private TextArea reportDis;

    @FXML
    private Button subReport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subReport.setOnMouseClicked(e->{
            if(reportDis.getText().isEmpty()){

            }else{
                ListenerControler.getListenerControler().reportArtist(artist.getUsername(),reportDis.getText());
            }
        });
        artistInfoLbl.setText(artist.getFullName()+"\n"+artist.getUsername()+"\n"+artist.getFollowers()+"\n"+artist.getBiography()+"\n"+artist.getEmail());
        followBtn.setOnMouseClicked(e->{
            ListenerControler.getListenerControler().followArtist(artist.getUsername());
        });
        backBtn.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(10);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

