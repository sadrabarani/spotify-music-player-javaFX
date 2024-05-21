package GUI;

import GUI.mainSection.PlayMusic;
import GUI.mainSection.SearchPage;
import controller.GeneralOperation;
import controller.ListenerControler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.Audio.Audio;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SideBar implements Initializable , GeneralOperation {
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
    private Button logInOutBtn;

    @FXML
    private TextField searchField;

    @FXML
    private SplitPane splitPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeBtn.setOnMouseClicked(e->{
            if (IsLogin.isIsLogin()) {
                try {
                    HelloApplication.whereAmI.add(10);
                    SetMainScene.setScene(10);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                try {
                    HelloApplication.whereAmI.add(9);
                    SetMainScene.setScene(9);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchField.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.ENTER){
                if(!searchField.getText().isEmpty()) {
                    System.out.println(searchField.getText());
                    search(searchField.getText());
                }else{
                    Warning.warning("write somthing to search","null text");
                }
            }
        });
        libraryBtn.setOnMouseClicked(e->{
            if(!IsLogin.isIsLogin()){
                IsLogin.notLogin();
            }
            else {
                try {
                    HelloApplication.whereAmI.add(1);
                    SetMainScene.setScene(1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        audiosBtn.setOnMouseClicked(mouseEvent -> {
            try {
                HelloApplication.whereAmI.add(6);
                SetMainScene.setScene(6);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        artistBtn.setOnMouseClicked(mouseEvent -> {
            try {
                HelloApplication.whereAmI.add(7);
                SetMainScene.setScene(7);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        logInOutBtn.setOnMouseClicked(e->{
            if (IsLogin.isIsLogin()){
                HelloApplication.whereAmI=new ArrayList<>();
                logout();
                ListenerControler.getListenerControler().logout();
                try {
                    HelloApplication.whereAmI.add(9);
                    SetMainScene.setScene(9);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                try {
                    HelloApplication.whereAmI.add(2);
                    SetMainScene.setScene(2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        logInOutBtn.setOnMouseEntered(e->{
            logInOutBtn.setStyle("-fx-background-color: #252323;");
        });
        logInOutBtn.setOnMouseExited(e->{
            logInOutBtn.setStyle("-fx-background-color: #000000FF;");
        });

        libraryBtn.setOnMouseEntered(e->{
            libraryBtn.setStyle("-fx-background-color: #252323;");
        });
        libraryBtn.setOnMouseExited(e->{
            libraryBtn.setStyle("-fx-background-color: #000000FF;");
        });

        audiosBtn.setOnMouseEntered(e->{
            audiosBtn.setStyle("-fx-background-color: #252323;");
        });
        audiosBtn.setOnMouseExited(e->{
            audiosBtn.setStyle("-fx-background-color: #000000FF;");
        });

        artistBtn.setOnMouseEntered(e->{
            artistBtn.setStyle("-fx-background-color: #252323;");
        });
        artistBtn.setOnMouseExited(e->{
            artistBtn.setStyle("-fx-background-color: #000000FF;");
        });
    }
}
