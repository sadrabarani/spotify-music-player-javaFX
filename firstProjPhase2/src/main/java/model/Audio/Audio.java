package model.Audio;
import model.Genre;

import java.util.Date;
public abstract class Audio {
    private int id;
    private String title;
    private String artistName;
    private int playCount;
    private int likes;
    private Date releaseDate;
    private Genre genre;
    private String audioFileLink;
    private String cover;
    private static int idcounter;

    //cuns???????????
    public Audio(int id, String title, String artistName, int playCount, int likes, Date releaseDate, Genre genre, String audioFileLink, String cover) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.playCount = playCount;
        this.likes = likes;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.audioFileLink = audioFileLink;
        this.cover = cover;
    }

    public static int getIdcounter() {
        return idcounter;
    }

    public static void setIdcounter(int idcounter) {
        Audio.idcounter = idcounter;
    }

    @Override
    public String toString(){
        StringBuilder result=new StringBuilder("artist name");
        result.append(artistName).append(" llikes : ").append(likes).append("play count").append(" title : ").append(title);
        return String.valueOf(result);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getPlayCount() {
        return playCount;
    }

    public int getLikes() {
        return likes;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAudioFileLink() {
        return audioFileLink;
    }

    public String getCover() {
        return cover;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setAudioFileLink(String audioFileLink) {
        this.audioFileLink = audioFileLink;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
