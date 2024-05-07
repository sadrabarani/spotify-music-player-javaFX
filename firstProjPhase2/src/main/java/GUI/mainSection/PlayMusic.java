package GUI.mainSection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayMusic implements Initializable {

    @FXML
    private MenuButton addPlayList;

    @FXML
    private Label artistLbl;

    @FXML
    private Button backBtn;

    @FXML
    private Rectangle cover;

    @FXML
    private Label genreLbl;

    @FXML
    private Button likeBtn;

    @FXML
    private Label lyricLbl;

    @FXML
    private Label musicNameLbl;

    @FXML
    private Label numerOfLikesLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
