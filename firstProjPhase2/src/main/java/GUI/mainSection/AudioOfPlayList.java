package GUI.mainSection;

import GUI.IsLogin;
import GUI.PlayBar;
import GUI.SetMainScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.Playlist;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AudioOfPlayList implements Initializable {
    private static Playlist playlist=null;
    private static AudioOfPlayList audioOfPlayList;

    public static Playlist getPlaylist() {
        return playlist;
    }

    public static AudioOfPlayList getAudioOfPlayList() {
        if (audioOfPlayList == null) {
            audioOfPlayList=new AudioOfPlayList();
        }
        return audioOfPlayList;
    }

    public static void setPlaylist(Playlist playlist) {
        AudioOfPlayList.playlist = playlist;
    }
    //todo get play list
    @FXML
    private Button backBtn;

    @FXML
    private ListView<Audio> listAudiosPlayList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Object audio:playlist){
            listAudiosPlayList.getItems().add((Audio) audio);
            listAudiosPlayList.setOnMouseClicked(e->{
                PlayMusic.audio= (Audio) audio;
                PlayBar.setAudio((Audio) audio);
                HelloApplication.whereAmI.add(4);
                SetMainScene.setMainSection(4);
            });
        }
        backBtn.setOnMouseClicked( e-> {
            if (IsLogin.isIsLogin()) {
                try {
                    HelloApplication.whereAmI.add(10);
                    SetMainScene.setScene(10);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    HelloApplication.whereAmI.add(9);
                    SetMainScene.setScene(9);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
