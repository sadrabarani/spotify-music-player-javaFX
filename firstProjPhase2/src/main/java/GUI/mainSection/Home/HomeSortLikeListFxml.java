package GUI.mainSection.Home;

import GUI.PlayBar;
import GUI.SetMainScene;
import GUI.mainSection.PlayMusic;
import controller.ListenerControler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Audio.Audio;
import model.Database.Database;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeSortLikeListFxml implements Initializable {

    @FXML
    private ListView mostLikedList;

    private int numberOfMostLiked=8;
    //todo change number
    //todo add Audio to data base
    @FXML
    private Label artistnamelbl;

    @FXML
    private Label artistnamelbl0ss;

    @FXML
    private Label artistnamelbl1;

    @FXML
    private Label artistnamelbl2;

    @FXML
    private Label artistnamelbl3;

    @FXML
    private Label artistnamelbl4;

    @FXML
    private Label artistnamelbl5;

    @FXML
    private Label artistnamelbl6;

    @FXML
    private Rectangle cover1;

    @FXML
    private Rectangle cover11;

    @FXML
    private Rectangle cover12;

    @FXML
    private Rectangle cover13;

    @FXML
    private Rectangle cover14;

    @FXML
    private Rectangle cover15;

    @FXML
    private Rectangle cover16;

    @FXML
    private Rectangle cover2s;

    @FXML
    private Label musicname1lbl;

    @FXML
    private Label musicname1lbl1;

    @FXML
    private Label musicname1lbl2;

    @FXML
    private Label musicname1lbl3;

    @FXML
    private Label musicname1lbl4;

    @FXML
    private Label musicname1lbl5;

    @FXML
    private Label musicname1lbl6;

    @FXML
    private Label musicnamelbl2s;

    @FXML
    private AnchorPane moreAnchor;


    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Audio> audioArrayList= ListenerControler.getListenerControler().sortLikes();

        String path1= HelloApplication.class.getResource("images/"+audioArrayList.get(0).getCover()).toExternalForm();
        Image image1=new Image(path1);
        cover1.setFill(new ImagePattern(image1));
        artistnamelbl.setText(audioArrayList.get(0).getArtistName());
        musicname1lbl.setText(audioArrayList.get(0).getTitle());cover1.setOnMouseClicked(event->{
            setImageAct(audioArrayList,0);
        });

        String path2= HelloApplication.class.getResource("images/"+audioArrayList.get(1).getCover()).toExternalForm();
        Image image2=new Image(path2);
        cover2s.setFill(new ImagePattern(image2));
        artistnamelbl0ss.setText(audioArrayList.get(1).getArtistName());
        musicnamelbl2s.setText(audioArrayList.get(1).getTitle());cover2s.setOnMouseClicked(event->{
            setImageAct(audioArrayList,1);
        });
        String path3= HelloApplication.class.getResource("images/"+audioArrayList.get(2).getCover()).toExternalForm();
        Image image3=new Image(path3);
        cover11.setFill(new ImagePattern(image3));
        artistnamelbl1.setText(audioArrayList.get(2).getArtistName());
        musicname1lbl1.setText(audioArrayList.get(2).getTitle());cover1.setOnMouseClicked(event->{
            setImageAct(audioArrayList,2);
        });
        String path4= HelloApplication.class.getResource("images/"+audioArrayList.get(3).getCover()).toExternalForm();
        Image image4=new Image(path4);
        cover12.setFill(new ImagePattern(image4));
        artistnamelbl2.setText(audioArrayList.get(3).getArtistName());
        musicname1lbl2.setText(audioArrayList.get(3).getTitle());cover12.setOnMouseClicked(event->{
            setImageAct(audioArrayList,3);
        });
        String path5= HelloApplication.class.getResource("images/"+audioArrayList.get(4).getCover()).toExternalForm();
        Image image5=new Image(path5);
        cover13.setFill(new ImagePattern(image5));
        artistnamelbl3.setText(audioArrayList.get(4).getArtistName());
        musicname1lbl3.setText(audioArrayList.get(4).getTitle());cover1.setOnMouseClicked(event->{
            setImageAct(audioArrayList,4);
        });
        String path6= HelloApplication.class.getResource("images/"+audioArrayList.get(5).getCover()).toExternalForm();
        Image image6=new Image(path6);
        cover14.setFill(new ImagePattern(image6));
        artistnamelbl4.setText(audioArrayList.get(5).getArtistName());
        musicname1lbl4.setText(audioArrayList.get(5).getTitle());cover14.setOnMouseClicked(event->{
            setImageAct(audioArrayList,5);
        });
        String path7= HelloApplication.class.getResource("images/"+audioArrayList.get(6).getCover()).toExternalForm();
        Image image7=new Image(path7);
        cover15.setFill(new ImagePattern(image7));
        artistnamelbl5.setText(audioArrayList.get(6).getArtistName());
        musicname1lbl5.setText(audioArrayList.get(6).getTitle());cover15.setOnMouseClicked(event->{
            setImageAct(audioArrayList,6);
        });
        String path8= HelloApplication.class.getResource("images/"+audioArrayList.get(7).getCover()).toExternalForm();
        Image image8=new Image(path8);
        cover16.setFill(new ImagePattern(image8));
        artistnamelbl6.setText(audioArrayList.get(7).getArtistName());
        musicname1lbl6.setText(audioArrayList.get(7).getTitle());cover16.setOnMouseClicked(event->{
            setImageAct(audioArrayList,7);
        });
        moreAnchor.setOnMouseClicked(e->{
            try {
                HelloApplication.whereAmI.add(6);
                SetMainScene.setScene(6);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        });
    }
    private void setImageAct(ArrayList<Audio> audioArrayList,int num){
        PlayMusic.audio=audioArrayList.get(num);
        ArrayList<Audio> myArrayList = Database.getDatabase().getAudios();
        PlayBar.setAudioArrayList(myArrayList);
        PlayBar.setIndex(PlayBar.getAudioArrayList().indexOf(audioArrayList.get(num)));
        PlayBar.setAudio(audioArrayList.get(num));
        PlayMusic.audio=audioArrayList.get(num);
        try {
            HelloApplication.whereAmI.add(4);
            SetMainScene.setScene(4);
        } catch (IOException ex) {
                 throw new RuntimeException(ex);
        }
    }
}
