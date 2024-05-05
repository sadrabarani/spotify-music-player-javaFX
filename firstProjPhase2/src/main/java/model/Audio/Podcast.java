package model.Audio;

import model.Audio.Audio;
import model.Genre;

import java.util.Date;

public class Podcast extends Audio {
    private String caption;

    public Podcast(int id, String title, String artistName, int playCount, int likes, Date releaseDate, Genre genre, String audioFileLink, String cover, String caption) {
        super(id, title, artistName, playCount, likes, releaseDate, genre, audioFileLink, cover);
        this.caption = caption;
    }
    public String toString(){
        StringBuilder res=new StringBuilder(" podcast caption");
        return super.toString()+"\n"+String.valueOf(res);
    }
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}