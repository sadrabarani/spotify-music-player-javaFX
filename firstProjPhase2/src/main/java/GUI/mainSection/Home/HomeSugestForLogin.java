package GUI.mainSection.Home;

import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.mainSection.PlayMusic;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeSugestForLogin implements Initializable {

    @FXML
    private ListView sugestList;

    private int numberOfSugestion=0;

    //todo change number
    //todo add Audio to data base

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Audio> audioArrayList=ListenerControler.getListenerControler().suggestAudio(numberOfSugestion);
        for (int i = 0; i < numberOfSugestion; i++) {
            sugestList.getItems().add(audioArrayList.get(i));
            PlayBar.setAudio(audioArrayList.get(i));
            PlayMusic.audio=audioArrayList.get(i);
            sugestList.setOnMouseClicked(e->{
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
