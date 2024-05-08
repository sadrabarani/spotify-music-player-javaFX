package GUI;

import GUI.mainSection.PlayMusic;
import GUI.mainSection.SearchPage;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.Audio.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SideBar implements Initializable {
    private Audio audio=null;
    SideBar sideBar;
    public void setAudio(Audio audio) {
        this.audio = audio;
    }
    public void setPlayMusic(SideBar playMusic) {
        this.sideBar = playMusic;
    }
    public Audio getAudio() {
        return audio;
    }
    public SideBar getPlayMusic() {
        return sideBar;
    }
    @FXML
    private AnchorPane anchor1;

    @FXML
    private AnchorPane anchor2;

    @FXML
    private AnchorPane anchor3;

    @FXML
    private AnchorPane anchor4;

    @FXML
    private Button artistBtn;

    @FXML
    private Button audiosBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button libraryBtn;

    @FXML
    private TextField searchField;

    @FXML
    private SplitPane splitPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        searchField.setOnKeyPressed(e->{
//            if(e.getCode()== KeyCode.ENTER){
//                if(searchField!=null) {
//                    SearchPage.setArrayList(ListenerControler.getListenerControler().searchByArtistName(searchField.getText()));
//                    SearchPage.setAudioArrayList(ListenerControler.getListenerControler().searchByAudio(searchField.getText()));
//                }
//            }
//        });
//        libraryBtn.setOnMouseClicked(e->{
//            if()//todo not login
//            {
//
//            }
//            else {
//                try {
//                    SetMainScene.setScene(1);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });
//        homeBtn.setOnMouseClicked(e1->{
//            if (){
//                try {
//                    SetMainScene.setScene(9);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }//todo not login
//            else //todo logined
//            {
//                try {
//                    SetMainScene.setScene(10);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });
//        audiosBtn.setOnMouseClicked(mouseEvent -> {
//            try {
//                SetMainScene.setScene(6);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        artistBtn.setOnMouseClicked(mouseEvent -> {
//            try {
//                SetMainScene.setScene(7);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }
}
