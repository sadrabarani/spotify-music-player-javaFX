package GUI.mainSection;

import GUI.SetMainScene;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Login implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Button backBtn1;

    @FXML
    private DatePicker dateBirth;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField fulNameTxt;

    @FXML
    private MenuItem listenerItem;

    @FXML
    private MenuItem listenerItem1;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginLbl;

    @FXML
    private MenuButton menuBtn;

    @FXML
    private MenuButton menuItems;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField passTxt;

    @FXML
    private Label passlbl;

    @FXML
    private TextField phoneNimberTxt;

    @FXML
    private MenuItem podcasterItem;

    @FXML
    private MenuItem podcasterItem1;

    @FXML
    private Button signInBtn;

    @FXML
    private MenuItem singerItem;

    @FXML
    private MenuItem singerItem1;

    @FXML
    private Label userLbl;

    @FXML
    private TextField userNameTxt;

    @FXML
    private TextField userNameTxt1;

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


class DateUtils {

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

