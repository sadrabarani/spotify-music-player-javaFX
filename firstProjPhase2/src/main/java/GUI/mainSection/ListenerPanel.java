package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Playlist;
import model.SubscriptionPlan;
import model.UserAccount.Artist;
import model.UserAccount.Listener;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Button backBtn1;

    @FXML
    private Button backBtn4;

    @FXML
    private Button addPlayList;

    @FXML
    private Label creditLbl;

    @FXML
    private Label dateBirth;

    @FXML
    private Label emaillbl;

    @FXML
    private ListView folowingsListView1;

    @FXML
    private Label nameLbl;

    @FXML
    private Button oneMonSubBtn;

    @FXML
    private Label passlbl;

    @FXML
    private TextField playlistNameTxt;

    @FXML
    private Label phoneLbl;

    @FXML
    private ListView playListView;

    @FXML
    private Button sixMonSubBtn;

    @FXML
    private Button twoMonSubBtn;

    @FXML
    private Label userlbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Listener listener=ListenerControler.getListenerControler().getListenerr();
        creditLbl.setText("credit : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getCredit())+"$ ");
        dateBirth.setText("date birth : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getDateOfBirth()));
        phoneLbl.setText("phone number : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getPhoneNumber()));
        passlbl.setText("password : "+listener.getPassword());
        nameLbl.setText("Full name :"+listener.getFullName());
        userlbl.setText("user name : "+listener.getUsername());
        emaillbl.setText("email :"+ listener.getEmail());
        twoMonSubBtn.setOnMouseClicked(e->{
            ListenerControler.getListenerControler().buySub(SubscriptionPlan.TwoMonth); //todo eror or succes
            creditLbl.setText("credit : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getCredit())+"$ ");
        });
        sixMonSubBtn.setOnMouseClicked(e->{
            ListenerControler.getListenerControler().buySub(SubscriptionPlan.SixMonth); //todo eror or succes
            creditLbl.setText("credit : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getCredit())+"$ ");
        });
        oneMonSubBtn.setOnMouseClicked(e->{
            ListenerControler.getListenerControler().buySub(SubscriptionPlan.OneMonth); //todo eror or succes
            creditLbl.setText("credit : "+String.valueOf(ListenerControler.getListenerControler().getListenerr().getCredit())+"$ ");
        });
        for(Artist artist:listener.getFollowings()){
            folowingsListView1.getItems().add(artist);
            folowingsListView1.setOnMouseClicked(e->{
                ArtistInfofxml.artist=artist;
                try {
                    SetMainScene.setScene(8);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        for(Playlist playlist:ListenerControler.getListenerControler().getListenerr().getPlaylists()){
            playListView.getItems().add(playlist);
            playListView.setOnMouseClicked(e->{
                AudioOfPlayList.setPlaylist(playlist);
            });
        }
        addPlayList.setOnMouseClicked(e->{
            if(playlistNameTxt.getText()==null){
                //todo eror
            }else {
                ListenerControler.getListenerControler().makePlaylist(playlistNameTxt.getText());
            }
        });
        backBtn.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(10);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        backBtn1.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(10);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        backBtn4.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(10);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
