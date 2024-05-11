package GUI.mainSection;
import GUI.IsLogin;
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
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllAudiosFxml implements Initializable {

    @FXML
    private ListView allAudiosList;

    //todo add audio to data base
    @FXML
    private Button backBtn;

    ArrayList<Audio> audioArrayList=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioArrayList= Database.getDatabase().getAudios();
        for(Audio audio:audioArrayList){
            allAudiosList.getItems().add(audio);
            PlayMusic.audio=audio;
                PlayBar.setAudio(audio);
            allAudiosList.setOnMouseClicked(e->{
                try {
                    SetMainScene.setScene(4);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
//        for (int i = 0; i < audioArrayList.size(); i++) {
//            allAudiosList.getItems().add(audioArrayList.get(i));
//            PlayBar.setAudio(audioArrayList.get(i));
//            PlayMusic.audio=audioArrayList.get(i);
//            allAudiosList.setOnMouseClicked(e->{
//                try {
//                    SetMainScene.setScene(4);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            });
//        }
        backBtn.setOnMouseClicked(e->{
            HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
            try {
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


}

