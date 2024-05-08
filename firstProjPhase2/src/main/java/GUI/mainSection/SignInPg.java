package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class SignInPg implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private DatePicker dateBirth;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField fulNameTxt;

    @FXML
    private MenuItem listenerItem;

    @FXML
    private TextField passTxt;

    @FXML
    private MenuButton menuItems;

    @FXML
    private TextField phoneNimberTxt;

    @FXML
    private MenuItem podcasterItem;

    @FXML
    private Button signInBtn;

    @FXML
    private MenuItem singerItem;

    @FXML
    private TextField userNameTxt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signInBtn.setOnMouseClicked(e->{
            //todo if one of them is empty or wrong
            //todo controler edit and if it has error return eception
            if(menuItems.getItems().contains(listenerItem)) {
                if (userNameTxt.getText().isEmpty() || passTxt.getText().isEmpty() || fulNameTxt.getText().isEmpty() ||
                        emailTxt.getText().isEmpty() || phoneNimberTxt.getText().isEmpty() || dateBirth.getValue() == null) {
                    //todo  Handle the case where any field is empty
                    // You can show an error message or do something else
                    return;
                }
                ListenerControler.getListenerControler().signUpListener(userNameTxt.getText(), passTxt.getText(), fulNameTxt.getText(), emailTxt.getText(), phoneNimberTxt.getText(), DateUtils.asDate(dateBirth.getValue()));
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


