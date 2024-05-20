package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Audio.Audio;
import org.example.firstprojphase2.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class SongItemcontroller implements Initializable {

    @FXML
    private Rectangle coverRect;

    @FXML
    private Label songNamelbl;

    @FXML
    private Label artistNamelbl1;

    public void setData (Audio audio){
        songNamelbl.setText(audio.getTitle());
        artistNamelbl1.setText(audio.getArtistName());
        String path1= HelloApplication.class.getResource("images/"+audio.getCover()).toExternalForm();
        Image image1=new Image(path1);
        coverRect.setFill(new ImagePattern(image1));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
