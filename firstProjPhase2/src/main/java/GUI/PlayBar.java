package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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

    public static void setPlayBar(PlayBar playBar) {
        PlayBar.playBar = playBar;
    }

    public static void setAudio(Audio audio) {
        PlayBar.audio = audio;
    }

    private static int index=0;
    private static String path;
    private static Media media;
    private static MediaPlayer mediaPlayer;
    private static int playing=0;
    @FXML
    private Label musicNamelbl;

    @FXML
    private Button nextBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Button prevBtn;

    @FXML
    private Separator sep1;

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Slider soundSlid;

    @FXML
    private ComboBox<?> speedCombo;

    @FXML
    private VBox vbox;
    private Timer timer;
    private TimerTask task;
    private boolean running;

    @FXML
    void nextMusic(ActionEvent event) {
        mediaPlayer.stop();
        cancelTimer();
       // if (++index>=HelloApplication.getPlayList().size()) index=0; //todo adding path for media
        playing=0;
        playMedia();
    }

    @FXML
    void playMedia() {
        if (playing!=1){
            playBtn.setText("PAUSE");
            if (playing==0){
              //  path = HelloApplication.getPlayList().get(index);
                media = new Media(path);
                mediaPlayer = new MediaPlayer(media);
            }
            beginTimer();
            mediaPlayer.play();
            playing=1;
        }
        else {
            playBtn.setText("PLAY");
            cancelTimer();
            mediaPlayer.pause();
            playing=2;
        }
    }

    @FXML
    void prevMusic(ActionEvent event) {
        mediaPlayer.stop();
        cancelTimer();
   //     if (--index<0) index=HelloApplication.getPlayList().size()-1;
        playing=0;
        playMedia();
    }

    @FXML
    void speedMusic(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void beginTimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                progressBar.setProgress(current/end);
                if (current==end){
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task,1000,1000);
    }
    public void cancelTimer(){
        running = false;
        timer.cancel();
    }
}

