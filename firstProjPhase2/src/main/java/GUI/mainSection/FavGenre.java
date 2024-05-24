package GUI.mainSection;

import GUI.IsLogin;
import GUI.SetMainScene;
import GUI.Warning;
import controller.ListenerControler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FavGenre implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private CheckBox country;

    @FXML
    private CheckBox hiphop;

    @FXML
    private CheckBox history;

    @FXML
    private CheckBox interview;

    @FXML
    private CheckBox jazz;

    @FXML
    private CheckBox pop;

    @FXML
    private CheckBox rock;

    @FXML
    private CheckBox society;

    @FXML
    private Button submitBtn;

    @FXML
    private CheckBox trueCrime;

    @FXML
    void rockOnAction(ActionEvent event) {
        if (rock.isSelected()) {
            rock.setStyle("-fx-background-color: black;");
        } else {
            rock.setStyle("-fx-background-color: green;");
        }
    }
    @FXML
    void countyOnAction(ActionEvent event) {
        if (country.isSelected()) {
            country.setStyle("-fx-background-color: black;");
        } else {
            country.setStyle("-fx-background-color: orange;");
        }
    }

    @FXML
    void hipHipOnAct(ActionEvent event) {
        if (hiphop.isSelected()) {
            hiphop.setStyle("-fx-background-color: black;");
        } else {
            hiphop.setStyle("-fx-background-color: Green;");
        }
    }

    @FXML
    void historyOnAct(ActionEvent event) {
        if (history.isSelected()) {
            history.setStyle("-fx-background-color: black;");
        } else {
            history.setStyle("-fx-background-color: Yellow;");
        }
    }

    @FXML
    void interviewOnAct(ActionEvent event) {
        if (interview.isSelected()) {
            interview.setStyle("-fx-background-color: black;");
        } else {
            interview.setStyle("-fx-background-color: purple;");
        }
    }

    @FXML
    void jazzOnAct(ActionEvent event) {
        if (jazz.isSelected()) {
            jazz.setStyle("-fx-background-color: black;");
        } else {
            jazz.setStyle("-fx-background-color: pink;");
        }
    }

    @FXML
    void popOnAct(ActionEvent event) {
        if (pop.isSelected()) {
            pop.setStyle("-fx-background-color: black;");
        } else {
            pop.setStyle("-fx-background-color: red;");
        }
    }

    @FXML
    void societyOnAct(ActionEvent event) {
        if (society.isSelected()) {
            society.setStyle("-fx-background-color: black;");
        } else {
            society.setStyle("-fx-background-color: #670000;");
        }
    }

    @FXML
    void trueOnaction(ActionEvent event) {
        if (trueCrime.isSelected()) {
            trueCrime.setStyle("-fx-background-color: black;");
        } else {
            trueCrime.setStyle("-fx-background-color: Blue;");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        submitBtn.setOnMouseClicked(e->{
            ArrayList<String> selectedItems=new ArrayList<>();
            int numberOfSelection = 0;
            if(society.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Society");
            }
            if(rock.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Rock");
            }
            if(pop.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Pop");
            }
            if(jazz.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Jazz");
            }
            if(interview.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Interview");
            }
            if(hiphop.isSelected()) {
                numberOfSelection++;
                selectedItems.add("HipHop");
            }
            if(history.isSelected()) {
                numberOfSelection++;
                selectedItems.add("History");
            }
            if(country.isSelected()) {
                numberOfSelection++;
                selectedItems.add("Country");
            }
            if(trueCrime.isSelected()) {
                numberOfSelection++;
                selectedItems.add("TrueCrime");
            }
            if(numberOfSelection>4)
                Warning.warning("Warning","you should choose 4 or less genre ");
            else{
                while(numberOfSelection<=0) {
                    ListenerControler.getListenerControler().chooseFavoriteGenre(selectedItems.get(numberOfSelection-1));
                    numberOfSelection--;
                }
                HelloApplication.whereAmI.add(10);
                IsLogin.setIsLogin(true);
                try {
                    SetMainScene.setScene(10);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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

