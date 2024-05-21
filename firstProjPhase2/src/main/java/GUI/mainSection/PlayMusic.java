package GUI.mainSection;

import GUI.*;
import controller.ListenerControler;
import exeptions.FreeAccountLimitException;
import exeptions.NotFoundExeption;
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
    public static Audio audio=null;
    private static PlayMusic playMusic;
    public  void setAudio(Audio audio) {
        this.audio = audio;
    }
    public static Audio getAudio() {
        return audio;
    }
    public static PlayMusic getPlayMusic() {
        if (playMusic == null) {
            playMusic=new PlayMusic();
        }
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
    private ImageView likeBtn;

    @FXML
    private Label lyricLbl;

    @FXML
    private Label musicNameLbl;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(IsLogin.isIsLogin()) {
            if (ListenerControler.getListenerControler().getListenerr().getPlaylists() != null) {
                for (Playlist playlist : ListenerControler.getListenerControler().getListenerr().getPlaylists()) {
                    MenuItem menuItem = new MenuItem(playlist.getName());
                    menuItem.setOnAction(e -> {
                        try {
                            ListenerControler.getListenerControler().AddAudio(playlist.getName(), audio.getId());
                        } catch (FreeAccountLimitException ex) {
                            Warning.warning(String.valueOf(ex.getClass()),ex.getMessage());
                        } catch (NotFoundExeption ex) {
                            Warning.warning(String.valueOf(ex.getClass()),ex.getMessage());
                        }
                    });
                    addPlayList.getItems().add(menuItem);
                }
            }
        }
        artistLbl.setText(audio.getArtistName());
        musicNameLbl.setText(audio.getTitle());
        if(audio instanceof Podcast)
            lyricLbl.setText(((Podcast) audio).getCaption());
        else if (audio instanceof Music)
            lyricLbl.setText(((Music) audio).getCaption());
        likeBtn.setOnMouseClicked(e->{
            if(!IsLogin.isIsLogin())
                IsLogin.notLogin();
            else {
                ListenerControler.getListenerControler().likeAudio(audio.getId());
                SuccesPopUp.showSuccessfulMessage();
            }
        });
        genreLbl.setText(String.valueOf(audio.getGenre()));
        String path1= HelloApplication.class.getResource("images/"+audio.getCover()).toExternalForm();
        Image image1=new Image(path1);
        cover.setFill(new ImagePattern(image1));
        backBtn.setOnMouseClicked(e->{
            try {
                HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
