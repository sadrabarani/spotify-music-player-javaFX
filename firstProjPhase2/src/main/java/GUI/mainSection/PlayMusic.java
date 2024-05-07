package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import model.Audio.Audio;
import model.Audio.Music;
import model.Audio.Podcast;
import model.Playlist;
import model.UserAccount.Listener;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMusic implements Initializable {
    private Audio audio=null;
    PlayMusic playMusic;
    public void setAudio(Audio audio) {
        this.audio = audio;
    }
    public void setPlayMusic(PlayMusic playMusic) {
        this.playMusic = playMusic;
    }
    public Audio getAudio() {
        return audio;
    }
    public PlayMusic getPlayMusic() {
        return playMusic;
    }

    @FXML
    private MenuButton addPlayList;

    @FXML
    private Label artistLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Rectangle cover;

    @FXML
    private Label genreLbl;

    @FXML
    private Button likeBtn;

    @FXML
    private Label lyricLbl;

    @FXML
    private Label musicNameLbl;

    @FXML
    private Label numerOfLikesLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Playlist playlist:ListenerControler.getListenerControler().getListenerr().getPlaylists()){
            MenuItem menuItem=new MenuItem(playlist.getName());
            menuItem.setOnAction(e->{
                ListenerControler.getListenerControler().AddAudio(playlist.getName(),audio.getId());
            });
            addPlayList.getItems().add(menuItem);
        }
        artistLbl.setText(audio.getArtistName());
        numerOfLikesLbl.setText(String.valueOf(audio.getLikes()));
        musicNameLbl.setText(audio.getTitle());
        if(audio instanceof Podcast)
            lyricLbl.setText(((Podcast) audio).getCaption());
        else if (audio instanceof Music)
            lyricLbl.setText(((Music) audio).getCaption());
        likeBtn.setOnMouseClicked(e->{
            ListenerControler.getListenerControler().likeAudio(audio.getId());
        });
        genreLbl.setText(String.valueOf(audio.getGenre()));
        String path1= HelloApplication.class.getResource(audio.getCover()).toExternalForm();
        Image image1=new Image(path1);
        cover.setFill(new ImagePattern(image1));
        backBtn.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(6);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
