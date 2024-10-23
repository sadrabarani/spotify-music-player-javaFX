package model;

import model.Audio.Audio;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private String creatorUsername;
    private ArrayList<Audio> audios;
    private static int idcounter;

    //cons???
    public Playlist(int id, String name, String creatorUsername) {
        this.id = id;
        this.name = name;
        this.creatorUsername = creatorUsername;
        this.audios = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("play list name : ");
        res.append(name).append(", id : ").append(id).append(", creator user name : ").append(creatorUsername).append(" my audio : \n");
        for (Audio audio:audios){
            res.append(audio.getTitle()).append(" , ");
        }
        return String.valueOf(res);
    }
    public static int getIdcounter() {
        return idcounter;
    }

    public static void setIdcounter(int idcounter) {
        Playlist.idcounter = idcounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
}
