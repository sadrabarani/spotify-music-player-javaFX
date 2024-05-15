package GUI.mainSection;

import GUI.IsLogin;
import GUI.SetMainScene;
import GUI.SuccesPopUp;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.UserAccount.Artist;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllArtistsFxml implements Initializable {

    @FXML
    private ListView allArtistsList;

    //todo add artist to data base
    @FXML
    private Button backBtn;

    ArrayList<Artist> artists=new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artists= ListenerControler.getListenerControler().showArtists();
        for(Artist artist:artists){
            allArtistsList.getItems().add(artist);
            allArtistsList.setOnMouseClicked(e->{
                ArtistInfofxml.artist=artist;
                SuccesPopUp.showSuccessfulMessage();
                HelloApplication.whereAmI.add(8);
                SetMainScene.setMainSection(8);
            });
        }

        backBtn.setOnMouseClicked(e->{
            HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
            try {
                SuccesPopUp.showSuccessfulMessage();
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

