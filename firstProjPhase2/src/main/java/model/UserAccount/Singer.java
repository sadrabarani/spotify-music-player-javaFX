package model.UserAccount;

import model.Album;
import model.Audio.Music;

import java.util.ArrayList;
import java.util.Date;

public class Singer extends Artist{
    private ArrayList<Music> albums;
    private String bio;


    public Singer(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth, String bio ) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth);
        this.albums = new ArrayList<>();
        this.bio=bio;
    }
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("biography : ");
        res.append(bio).append(" albums : ");
        for(Music album:albums){
            res.append(album.toString());
        }
        return super.toString()+"\n"+String.valueOf(res);
    }

    public void setAlbums(ArrayList<Music> albums) {
        this.albums = albums;
    }

    public ArrayList<Music> getAlbums() {
        return albums;
    }
}
