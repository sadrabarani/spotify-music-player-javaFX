package GUI.mainSection;

import GUI.IsLogin;
import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.UserAccount.Artist;

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
                SetMainScene.setMainSection(8);
            });
        }

        backBtn.setOnMouseClicked(e->{
            if (IsLogin.isIsLogin()){
            try {
                SetMainScene.setScene(10);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            }else{
                try {
                    SetMainScene.setScene(9);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}

