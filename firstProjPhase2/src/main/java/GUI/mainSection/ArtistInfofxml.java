package GUI.mainSection;

import GUI.*;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.Audio.Audio;
import model.UserAccount.Artist;
import model.UserAccount.Podcaster;
import model.UserAccount.Singer;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
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
            if(!IsLogin.isIsLogin())
                IsLogin.notLogin();
            else {
                if (reportDis.getText().isEmpty()) {
                    Warning.warning("input empty", "write cause of your report");
                } else {
                    ListenerControler.getListenerControler().reportArtist(artist.getUsername(), reportDis.getText());
                    SuccesPopUp.showSuccessfulMessage();
                }
            }
        });
        artistInfoLbl.setText(artist.getFullName()+"\n\n"+artist.getUsername()+"\n\n"+artist.getPhoneNumber()+"\n\n"+artist.getBiography()+"\n\n"+artist.getEmail());
        followBtn.setOnMouseClicked(e->{
            if(!IsLogin.isIsLogin()){
                IsLogin.notLogin();
            }else{
                SuccesPopUp.showSuccessfulMessage();
                ListenerControler.getListenerControler().followArtist(artist.getUsername());
            }
        });
        backBtn.setOnMouseClicked(e->{
            HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
            try {
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
                //  throw new RuntimeException(ex);
            }
        });
        if(artist instanceof Podcaster) {
            for (Audio audio : ((Podcaster) artist).getPodcasts()){
                listMusicOfArtist.getItems().add(audio);
                listMusicOfArtist.setOnMouseClicked(e->{
                    PlayMusic.audio=audio;
                    PlayBar.setAudio(audio);
                    try {
                        HelloApplication.whereAmI.add(4);
                        SetMainScene.setScene(4);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
        } else if (artist instanceof Singer) {
            for(Audio audio:((Singer) artist).getAlbums()){
                listMusicOfArtist.getItems().add(audio);
                listMusicOfArtist.setOnMouseClicked(e->{
                    PlayMusic.audio=audio;
                    PlayBar.setAudio(audio);
                    try {
                        HelloApplication.whereAmI.add(4);
                        SetMainScene.setScene(4);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
        }
    }
}

