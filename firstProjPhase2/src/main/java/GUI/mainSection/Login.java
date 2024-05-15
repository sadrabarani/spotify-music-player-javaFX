package GUI.mainSection;

import GUI.SetMainScene;
import GUI.Warning;
import controller.ListenerControler;
import exeptions.FailedLoginException;
import exeptions.InvalidFormatException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    int userType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listenerItem.setOnAction(e->{
            userType=0;
        });
        listenerItem1.setOnAction(e->{
            userType=0;
        });
        singerItem.setOnAction(e1->{
            userType=1;
        });
        podcasterItem.setOnAction(e2->{
            userType=2;
        });
        singerItem1.setOnAction(e1->{
            userType=1;
        });
        podcasterItem1.setOnAction(e2->{
            userType=2;
        });
        loginBtn.setOnMouseClicked(e->{//todo exeption and controler
            if(menuBtn.getItems().contains(listenerItem) ){
                if (userNameTxt.getText().isEmpty() || passField.getText().isEmpty()) {
                    Warning.warning("please compeletee every field .","Field is empty ");
                }else{
                    try {
                        ListenerControler.getListenerControler().login(userNameTxt.getText(), passField.getText());
                        HelloApplication.whereAmI=new ArrayList<>();
                        HelloApplication.whereAmI.add(10);
                        SetMainScene.setScene(10);
                    }catch (FailedLoginException | IOException e1){
                        Warning.warning(String.valueOf(e1.getClass()), e1.getMessage());
                    }
                }
                HelloApplication.whereAmI.add(10);
                SetMainScene.setMainSection(10);
            }
        });

        backBtn.setOnMouseClicked(e->{
            try {
                HelloApplication.whereAmI.add(9);
                SetMainScene.setScene(9);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        signInBtn.setOnMouseClicked(e->{
            //todo if one of them is empty or wrong
            //todo controler edit and if it has error return eception
            if(userType==0) {
                if (userNameTxt.getText().isEmpty() || passTxt.getText().isEmpty() || fulNameTxt.getText().isEmpty() ||
                        emailTxt.getText().isEmpty() || phoneNimberTxt.getText().isEmpty() || dateBirth.getValue() == null) {
                    Warning.warning("please compelete every field .","Field is empty ");
                }else{
                    try {
                        ListenerControler.getListenerControler().signUpListener(userNameTxt.getText(), passTxt.getText(), fulNameTxt.getText(), emailTxt.getText(), phoneNimberTxt.getText(), DateUtils.asDate(dateBirth.getValue()));
                        HelloApplication.whereAmI=new ArrayList<>();
                        HelloApplication.whereAmI.add(10);
                        SetMainScene.setScene(10);
                    }catch (InvalidFormatException | IOException formatException){
                        Warning.warning(String.valueOf(formatException.getClass()),formatException.getMessage());
                    }
                }
            }
        });

        backBtn.setOnMouseClicked(e->{
            try {
                HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
                SetMainScene.setScene(HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1));
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

