package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private MenuItem listenerItem;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginLbl;

    @FXML
    private PasswordField passField;

    @FXML
    private Label passlbl;

    @FXML
    private MenuItem podcasterItem;

    @FXML
    private MenuItem singerItem;

    @FXML
    private MenuButton menuBtn;
    @FXML
    private Label userLbl;

    @FXML
    private TextField userNameTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnMouseClicked(e->{//todo exeption and controler
            if(menuBtn.getItems().contains(listenerItem) ){
                if (userNameTxt.getText().isEmpty() || passField.getText().isEmpty()) {
                    //todo exeption  Handle the case where any field is empty
                    // You can show an error message or do something else
                    return;
                }
                ListenerControler.getListenerControler().login(userNameTxt.getText(),passField.getText());
                SetMainScene.setMainSection(10);
            }
        });
        backBtn.setOnMouseClicked(e->{
            try {
                SetMainScene.setScene(9);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}


