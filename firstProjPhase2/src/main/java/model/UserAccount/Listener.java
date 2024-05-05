package model.UserAccount;

import model.Audio.Audio;
import model.Genre;
import model.Playlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Listener extends User{
    private Date endSubDate;
    private ArrayList<Playlist> playlists;
    private Map<Integer, Integer> listeningHistory;
    private int credit;
    private ArrayList<Genre> favoriteGenre;
    private  int playlistcounter;
    private ArrayList<Artist>followings;
    private ArrayList<Audio>likes;
    public Listener(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth,int credit) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth);
        this.credit=credit;
        playlists=new ArrayList<>();
        favoriteGenre=new ArrayList<>();
        followings=new ArrayList<>();
        endSubDate=new Date();
        listeningHistory=new HashMap<>();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("favorite genre : ");
        for(Genre genre:favoriteGenre){
            res.append(String.valueOf(genre));
        }
        return super.toString()+"\n"+" credit:  "+credit+"\n"+String.valueOf(res);
    }
    public ArrayList<Genre> getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setPlaylistcounter(int playlistcounter) {
        this.playlistcounter = playlistcounter;
    }

    public void setEndSubDate(Date endSubDate) {
        this.endSubDate = endSubDate;
    }

    public Date getEndSubDate() {
        return endSubDate;
    }

    public void setFavoriteGenre(ArrayList<Genre> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public ArrayList<Artist> getFollowings() {
        return followings;
    }

    public void setFollowings(ArrayList<Artist> followings) {
        this.followings = followings;
    }

    public int getPlaylistcounter() {
        return playlistcounter;
    }

    public void setPlaylistcounter(int playlistcounter,int i) {
        this.playlistcounter = playlistcounter+i;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setListeningHistory(Map<Integer, Integer> listeningHistory) {
        this.listeningHistory = listeningHistory;
    }



    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public Map<Integer, Integer> getListeningHistory() {
        return listeningHistory;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
