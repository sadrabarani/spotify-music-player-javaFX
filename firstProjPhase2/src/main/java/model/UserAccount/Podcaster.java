package model.UserAccount;

import model.Audio.Podcast;

import java.util.ArrayList;
import java.util.Date;

public class Podcaster extends Artist{
    ArrayList<Podcast> podcasts;

    public Podcaster(String username, String password, String fullName, String email, String phoneNumber, Date dateOfBirth) {
        super(username, password, fullName, email, phoneNumber, dateOfBirth);
        this.podcasts =new ArrayList<>() ;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("podcasts : ");
        for(Podcast podcast:podcasts){
            res.append(podcast.getTitle());
        }
        return super.toString()+"\n"+String.valueOf(res);
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
