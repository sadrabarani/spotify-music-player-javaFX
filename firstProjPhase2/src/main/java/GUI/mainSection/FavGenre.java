package GUI.mainSection;

import GUI.SetMainScene;
import GUI.Warning;
import controller.ListenerControler;
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

