package controller;

import model.Album;
import model.Audio.Audio;
import model.Audio.Music;
import model.Audio.Podcast;
import model.Database.Database;
import model.Genre;
import model.UserAccount.*;

import java.util.ArrayList;
import java.util.Date;

public class ArtistControler {
    private static ArtistControler artistControler;
    Artist artist;
    public  String publishPodcast(String title, String genre, String caption, String link, String cover){
        if (artist instanceof Podcaster){
            Podcast podcast0=new Podcast(Podcast.getIdcounter(),title,artist.getUsername(),0,0,new Date(), Genre.valueOf(genre),link,cover,caption);
            Audio.setIdcounter(Audio.getIdcounter()+1);
            ((Podcaster) artist).getPodcasts().add(podcast0);
            Database.getDatabase().getAudios().add(podcast0);
        }
        return "podcast added";
    }
    public  String publishMusic(String title, String genre, String caption, String link, String cover, int albumId){
        if (artist instanceof Singer){
            Music music0=new Music(Audio.getIdcounter(),title,artist.getUsername(),0,0,new Date(), Genre.valueOf(genre),link,cover,caption);
            int tmpindex=0;
            Audio.setIdcounter(Audio.getIdcounter()+1);
            for(Album album: ((Singer) artist).getAlbums()){
                if(albumId==album.getId()){
                    ((Singer) artist).getAlbums().get(tmpindex).getSongs().add(music0);
                }else
                    tmpindex++;
            }
            Database.getDatabase().getAudios().add(music0);
        }
        return "music added";
    }
    public String newAlbum(String name){
        Album album0=new Album(Album.getAlbumCounter(),name,artist.getUsername());
        Album.setAlbumCounter(Album.getAlbumCounter()+1);
        ((Singer)artist).getAlbums().add(album0);
        return "album created";
    }
    public ArtistControler() {
    }

    public static ArtistControler getArtistControler() {
        if (artistControler == null)
            artistControler=new ArtistControler();
        return artistControler;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String signUpArtist(String username, String pasword, String name, String email, String phoneNum, Date birthDate,String bio,String type){
        if(!Regex.emailRegex(email))
            return "use valid email";
        if (!Regex.passwordRegex(pasword))
            return "use harder password";
        if(!Regex.phoneRegex(phoneNum))
            return "use valid phone number";
        ArrayList<User> users= Database.getDatabase().getUsers();
        for(User user:users){
            if(user.getUsername().equals(username)){
                return "error : this user name already exist .";
            }
        }
        if(type.equals("S")) {
            Singer artistt = new Singer(username, pasword, name, email, phoneNum, birthDate, bio);
            setArtist(artistt);
        }else if(type.equals("P")) {
            Podcaster artistt=new Podcaster(username,pasword,name,email,phoneNum,birthDate);
            setArtist(artistt);
        }
        Database.getDatabase().getUsers().add(artist);
        return  "artist accaount successfully created .";
    }
    public String login(String username,String password){
        ArrayList<User>users=Database.getDatabase().getUsers();
        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                setArtist((Artist) user);
                return "login successful .";
            }
        }
        return "error : user name or password is wrong";
    }
    public String logout(){
        ArrayList<User>users=Database.getDatabase().getUsers();
        return "logout successfull";
    }
    public  String artistInfo(){
        return artist.toString();
    }
    public String showFollowers(){
        StringBuilder result=new StringBuilder(" followers : ");
        for(User user: artist.getFollowers()){
            result.append(user.getUsername()).append(" ");
        }
        return artist.getFollowers().size()+String.valueOf(result);
    }
    public String viewStatic(){
        StringBuilder str=new StringBuilder(" view static: \n");
        int totalplayCount=0;
        if(artist instanceof Singer){
            for(Album album:((Singer) artist).getAlbums()){
                for(Music music:album.getSongs()) {
                    str.append(" music name :").append(music.getTitle()).append(" view : ").append(music.getPlayCount());
                    totalplayCount += music.getPlayCount();
                }
            }
        }
        if(artist instanceof Podcaster){
            for(Podcast podcast:((Podcaster) artist).getPodcasts()){
                str.append(" podcast name :").append(podcast.getTitle()).append(" view : ").append(podcast.getPlayCount());
                totalplayCount+= podcast.getPlayCount();
            }
        }
        return "total view : "+ totalplayCount+String.valueOf(str);
    }
    public String calculateEarning(){
        double total=0;
        if(artist instanceof Singer){
            for(Album album:((Singer) artist).getAlbums()){
                for(Music music:album.getSongs()) {
                total+= music.getPlayCount()*0.4;
                }
            }
        }
        if(artist instanceof Podcaster){
            for(Podcast podcast:((Podcaster) artist).getPodcasts()){
                total+= podcast.getPlayCount()*0.5;
            }
        }
        return String.valueOf(total);
    }

}
