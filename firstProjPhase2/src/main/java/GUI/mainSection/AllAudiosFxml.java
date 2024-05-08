package GUI.mainSection;
import GUI.PlayBar;
import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.Database.Database;
import model.UserAccount.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllAudiosFxml implements Initializable {

    @FXML
    private ListView allAudiosList;

    @FXML
    private Button backBtn;

    ArrayList<Audio> audioArrayList=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioArrayList= Database.getDatabase().getAudios();
        for(Audio audio:audioArrayList){
            allAudiosList.getItems().add(audio);
            allAudiosList.setOnMouseClicked(e->{
                PlayMusic.audio=audio;
                PlayBar.setAudio(audio);
                SetMainScene.setMainSection(4);
            });
        }
        backBtn.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(10);//todo is login
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


}

