package GUI.mainSection;

import GUI.IsLogin;
import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.SongItemcontroller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Audio.Audio;
import model.Playlist;
import model.UserAccount.Podcaster;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private Button backBtn;

    @FXML
    private VBox vboxItems;

    @FXML
    private ListView<Audio> listAudiosPlayList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Object audio:playlist){
            FXMLLoader fxmlLoaderl=new FXMLLoader(HelloApplication.class.getResource("songItem.fxml"));
            try {
                AnchorPane parent=fxmlLoaderl.load();
                SongItemcontroller songItemcontroller=fxmlLoaderl.getController();
                songItemcontroller.setData((Audio) audio);
                vboxItems.getChildren().add(parent);
                parent.setOnMouseClicked(e->{
                    PlayMusic.audio=(Audio) audio;
                    PlayBar.setAudioArrayList(playlist.getAudios());
                    PlayBar.setIndex(PlayBar.getAudioArrayList().indexOf(audio));
                    PlayBar.setAudio((Audio) audio);
                    try {
                        HelloApplication.whereAmI.add(4);
                        SetMainScene.setScene(4);
                    } catch (IOException ex) {
                        // throw new RuntimeException(ex);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        backBtn.setOnMouseClicked( e-> {
            HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
            try {
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
              //  throw new RuntimeException(ex);
            }
        });

    }
}
