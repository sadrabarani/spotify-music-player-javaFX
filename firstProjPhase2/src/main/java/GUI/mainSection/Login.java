package GUI.mainSection;

import GUI.IsLogin;
import GUI.SetMainScene;
import GUI.SuccesPopUp;
import GUI.Warning;
import controller.ArtistControler;
import controller.GeneralOperation;
import controller.ListenerControler;
import exeptions.FailedLoginException;
import exeptions.InvalidFormatException;
import exeptions.SameExistExption;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Login implements Initializable , GeneralOperation {

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
        listenerItem.setOnAction(e -> {
            userType = 0;
        });
        listenerItem1.setOnAction(e -> {
            userType = 0;
        });
        singerItem.setOnAction(e1 -> {
            userType = 1;
        });
        podcasterItem.setOnAction(e2 -> {
            userType = 2;
        });
        singerItem1.setOnAction(e1 -> {
            userType = 1;
        });
        podcasterItem1.setOnAction(e2 -> {
            userType = 2;
        });
        loginBtn.setOnMouseClicked(e -> {
            if (menuBtn.getItems().contains(listenerItem)) {
                if (userNameTxt.getText().isEmpty() || passField.getText().isEmpty()) {
                    Warning.warning("please compeletee every field .", "Field is empty ");
                } else {
                    try {
                        ListenerControler.getListenerControler().login(userNameTxt.getText(), passField.getText());
                        login();
                    } catch (FailedLoginException | IOException e1) {
                        Warning.warning(String.valueOf(e1.getClass()), e1.getMessage());
                    }
                }
                HelloApplication.whereAmI.add(10);
                SetMainScene.setMainSection(10);
            }
        });

        backBtn.setOnMouseClicked(e -> {
            try {
                HelloApplication.whereAmI.add(9);
                SetMainScene.setScene(9);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        try {
            signInBtn.setOnMouseClicked(e -> {
                if (userType == 0) {
                    try {
                        if (dateBirth.getValue() == null) ;
                    } catch (DateTimeParseException dateTimeException) {
                        Warning.warning("please choose date from date peaker.", "Field is empty ");
                        try {
                            SetMainScene.setScene(2);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (userNameTxt1.getText().isEmpty() || passTxt.getText().isEmpty() || fulNameTxt.getText().isEmpty() ||
                            emailTxt.getText().isEmpty() || phoneNimberTxt.getText().isEmpty()) {
                        Warning.warning("please compelete every field .", "Field is empty ");
                    } else {
                        try {
                            Date date = null;
                            try {
                                date = DateUtils.asDate(dateBirth.getValue());
                                ListenerControler.getListenerControler().signUpListener(userNameTxt1.getText(), passTxt.getText(), fulNameTxt.getText(), emailTxt.getText(), phoneNimberTxt.getText(), date);
                            } catch (Exception exception) {
                                Warning.warning(String.valueOf(exception.getClass()), exception.getMessage());
                            }
                            HelloApplication.whereAmI = new ArrayList<>();
                            signup();
                        } catch (InvalidFormatException | IOException | SameExistExption formatException) {
                            Warning.warning(String.valueOf(formatException.getClass()), formatException.getMessage());
                        }
                    }
                }
                else if (userType == 1 || userType==2) {
                    try {
                        if (dateBirth.getValue() == null) ;
                    } catch (DateTimeParseException dateTimeException) {
                        Warning.warning("please choose date from date peaker.", "Field is empty ");
                        try {
                            SetMainScene.setScene(2);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (userNameTxt1.getText().isEmpty() || passTxt.getText().isEmpty() || fulNameTxt.getText().isEmpty() ||
                            emailTxt.getText().isEmpty() || phoneNimberTxt.getText().isEmpty()) {
                        Warning.warning("please compelete every field .", "Field is empty ");
                    } else {
                        try {
                            Date date = null;
                            try {
                                date = DateUtils.asDate(dateBirth.getValue());
                            } catch (DateTimeException exception) {
                                Warning.warning(String.valueOf(exception.getClass()), exception.getMessage());
                            }
                            if(userType==1)
                            ArtistControler.getArtistControler().signUpArtist(userNameTxt1.getText(), passTxt.getText(), fulNameTxt.getText(), emailTxt.getText(), phoneNimberTxt.getText(), date,"compelete in panel","S");
                            if (userType==2)
                                ArtistControler.getArtistControler().signUpArtist(userNameTxt1.getText(), passTxt.getText(), fulNameTxt.getText(), emailTxt.getText(), phoneNimberTxt.getText(), date,"compelete in panel","P");
                            HelloApplication.whereAmI = new ArrayList<>();
                            SuccesPopUp.showSuccessfulMessage();
                            Warning.warning("logout","no panel");
                            HelloApplication.whereAmI=new ArrayList<>();
                            HelloApplication.whereAmI.add(9);
                            SetMainScene.setScene(9);
                        } catch (InvalidFormatException | SameExistExption formatException) {
                            Warning.warning(String.valueOf(formatException.getClass()), formatException.getMessage());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
        } catch (Exception e) {
            Warning.warning("please choose date from date peaker.", "Field is empty ");
        }

        backBtn.setOnMouseClicked(e -> {
            try {
                SetMainScene.setScene(backTo());
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

