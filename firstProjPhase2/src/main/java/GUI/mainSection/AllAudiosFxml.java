package GUI.mainSection;
import GUI.IsLogin;
import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.SongItemcontroller;
import controller.ListenerControler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    @FXML
    private VBox vboxItems;
    ArrayList<Audio> audioArrayList=new ArrayList<>();

    @FXML
    void back_event(ActionEvent event) {
        HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
        try {
            SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioArrayList= Database.getDatabase().getAudios();
        for(Audio audio:audioArrayList){
            FXMLLoader fxmlLoaderl=new FXMLLoader(HelloApplication.class.getResource("songItem.fxml"));
            try {
                AnchorPane parent=fxmlLoaderl.load();
                SongItemcontroller songItemcontroller=fxmlLoaderl.getController();
                songItemcontroller.setData(audio);
                vboxItems.getChildren().add(parent);
                parent.setOnMouseClicked(e-> {
                    PlayMusic.audio = audio;
                    PlayBar.setAudioArrayList(Database.getDatabase().getAudios());
                    PlayBar.setIndex(Database.getDatabase().getAudios().indexOf(audio));
                    PlayBar.setAudio(audio);
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
    }
}

