package model;

import model.Audio.Audio;
import model.Audio.Music;

import java.util.ArrayList;

public class Album {
    private int id;
    private String name;
    private String singerName;
    private ArrayList<Music> songs;
    private static int albumCounter;

    //cons???
    public Album(int id, String name, String singerName) {
        this.id = id;
        this.name = name;
        this.singerName = singerName;
        this.songs = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(", album name : ");
        res.append(name).append(" singer name : ").append(singerName).append("Album id:  ").append(id);
        for(Audio audio : songs){
            res.append(" , songs:").append(audio.getTitle());
        }
        return String.valueOf(res);
    }

    public static void setAlbumCounter(int albumCounter) {
        Album.albumCounter = albumCounter;
    }

    public static int getAlbumCounter() {
        return albumCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSingerName() {
        return singerName;
    }

    public ArrayList<Music> getSongs() {
        return songs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void setSongs(ArrayList<Music> songs) {
        this.songs = songs;
    }
}
