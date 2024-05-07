package GUI.mainSection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Audio.Audio;
import model.Playlist;

public class AudioOfPlayList {
    private static Playlist playlist=null;
    private static AudioOfPlayList audioOfPlayList;

    public static Playlist getPlaylist() {
        return playlist;
    }

    public static AudioOfPlayList getAudioOfPlayList() {
        if (audioOfPlayList == null) {
            audioOfPlayList=new AudioOfPlayList();
        }
        return audioOfPlayList;
    }

    public static void setPlaylist(Playlist playlist) {
        AudioOfPlayList.playlist = playlist;
    }

    @FXML
    private Button backBtn;

    @FXML
    private ListView<Audio> listAudiosPlayList;

}
