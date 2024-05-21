package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import model.Audio.Audio;
import org.example.firstprojphase2.HelloApplication;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class PlayBar implements Initializable {
    private static PlayBar playBar;
    private static Audio audio=null;
    private static ArrayList<Audio> audioArrayList=new ArrayList<>();
    public static PlayBar getPlayBar() {
        if (playBar == null) {
            playBar=new PlayBar();
        }
        return playBar;
    }

    public static Audio getAudio() {
        return audio;
    }

    public static void setAudioArrayList(ArrayList<Audio> audioArrayList) {
        PlayBar.audioArrayList = audioArrayList;
    }

    public static void setPlayBar(PlayBar playBar) {
        PlayBar.playBar = playBar;
    }

    public static ArrayList<Audio> getAudioArrayList() {
        return audioArrayList;
    }

    public static void setAudio(Audio audio) {
        PlayBar.audio = audio;
    }

    private static int index;
    private static String path;
    private static Media media;
    private static MediaPlayer mediaPlayer;
    private static int playing=0;

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        PlayBar.index = index;
    }

    @FXML
    private Label musicNamelbl;

    @FXML
    private Button nextBtn;
    @FXML
    private ImageView coverImg;

    @FXML
    private Button playBtn;

    @FXML
    private Button prevBtn;

    @FXML
    private Separator sep1;



    @FXML
    private VBox vbox;

    private boolean running;

    @FXML
    void nextMusic(ActionEvent event) {
        mediaPlayer.stop();
        if (++index>=audioArrayList.size())
           index=0;
        playing=0;
        playMedia();
    }

    @FXML
    void playMedia() {
        if (playing!=1){
            playBtn.setText("PAUSE");
            if (playing==0){
                musicNamelbl.setText(audioArrayList.get(index).getTitle());
                String path1= HelloApplication.class.getResource("images/"+audioArrayList.get(index).getCover()).toExternalForm();
                coverImg.setImage(new Image(path1));
                path = audioArrayList.get(index).getAudioFileLink();
                media = new Media(path);
                mediaPlayer = new MediaPlayer(media);
            }
            mediaPlayer.play();
            playing=1;
        }
        else {
            playBtn.setText("PLAY");
            musicNamelbl.setText(audioArrayList.get(index).getTitle());
            mediaPlayer.pause();
            playing=0;
        }
    }

    @FXML
    void prevMusic(ActionEvent event) {
        mediaPlayer.stop();
        if (--index<0)
            index=audioArrayList.size()-1;
        playing=0;
        playMedia();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playMedia();
    }

}

