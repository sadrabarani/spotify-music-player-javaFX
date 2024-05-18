package controller;

import GUI.IsLogin;
import GUI.SuccesPopUp;
import GUI.Warning;
import exeptions.*;
import model.*;
import model.Audio.Audio;
import model.Audio.Music;
import model.Audio.Podcast;
import model.Database.Database;
import model.UserAccount.*;
import model.Report;
import model.Genre;
import org.example.firstprojphase2.HelloApplication;

import java.util.*;

public class ListenerControler {
    private Listener listenerr;
    private static ListenerControler listenerControler;
    Map<Genre,Integer>genreScore;
    Map<Artist,Integer>artistScore;
    private ListenerControler() {
        genreScore=new HashMap<>();
        artistScore=new HashMap<>();
    }

    public static ListenerControler getListenerControler() {
        if (listenerControler == null)
            listenerControler = new ListenerControler();
        return listenerControler;
    }


    public Listener getListenerr() {
        return listenerr;
    }

    public void setListenerr(Listener listenerr) {
        this.listenerr = listenerr;
    }

    public String signUpListener(String username, String pasword, String name, String email, String phoneNum, Date birthDate){
        if(!Regex.emailRegex(email))
            throw new InvalidFormatException("use  valid email");
        if (!Regex.passwordRegex(pasword))
           throw new InvalidFormatException(" use harder password with more than 8 character");
        if(!Regex.phoneRegex(phoneNum))
            throw new InvalidFormatException("use valid phone number");
        ArrayList<User>users=Database.getDatabase().getUsers();
        for(User user:users){
            if(user.getUsername().equals(username)){
                throw new SameExistExption("user name already exist");
            }
        }
        listenerr=new Listener(username,pasword,name,email,phoneNum,birthDate,50);
        setListenerr(listenerr);
        Database.getDatabase().getUsers().add(listenerr);
        listenerr.setIsLogin(true);
        IsLogin.setIsLogin(true);
        return "sign uped";
    }
    String showgenre(){
        return Genre.Country+","+Genre.Pop+","+Genre.HipHop+","+Genre.History+","+Genre.Interview+","+Genre.Jazz+","+Genre.TrueCrime+","+Genre.Society+","+Genre.Rock;
    }
    public String chooseFavoriteGenre(String genre1,String genre2,String genre3,String genre4){
        if(genre2.equals("")&&genre3.equals("")&&genre4.equals("")){
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre1));
        } else if (genre3.equals("")&&genre4.equals("")) {
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre1));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre2));
        } else if (genre4.equals("")){
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre1));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre2));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre3));
        }else {
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre1));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre2));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre3));
            listenerr.getFavoriteGenre().add(Genre.valueOf(genre4));
        }
        return "listener accaount successfully created .";
    }
    public void chooseFavoriteGenre(String genre1,String genre2,String genre3){
        chooseFavoriteGenre(genre1,genre2,genre3,"");
    }
    public void chooseFavoriteGenre(String genre1,String genre2){
        chooseFavoriteGenre(genre1,genre2,"","");
    }
    public void chooseFavoriteGenre(String genre1){
        chooseFavoriteGenre(genre1,"","","");
    }

    public String login(String username,String password) throws UserNotFoundException {
        ArrayList<User>users=Database.getDatabase().getUsers();
        int counter=0;
        for(User user:users) {
            if (user.getUsername().equals(username))
                break;
            counter++;
        }
        if (counter==users.size())
            throw new UserNotFoundException();
        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                IsLogin.setIsLogin(true);
                return "login successful .";
            }
        }
        throw new WrongPaswordException();
    }

    public String logout(){
        ArrayList<User>users=Database.getDatabase().getUsers();
        listenerr.setIsLogin(false);
        return "logout successfull";
    }

    public Playlist makePlaylist(String playlistName) throws FreeAccountLimitException{
        for (Playlist playlist : listenerr.getPlaylists()) {
            if (playlist.getName().equals (playlistName)) {
                throw new SameExistExption("same play list name exist");
            }
        }
        if (!(listenerr instanceof PrimiumListener)) {
            if (listenerr.getPlaylistcounter() >= 3) {
                throw new FreeAccountLimitException();
            }
        }
        listenerr.setPlaylistcounter(listenerr.getPlaylistcounter(), 1);
        Playlist playlist0=new Playlist(generateIdPlaylist(), playlistName, listenerr.getFullName());
        listenerr.getPlaylists().add(playlist0);
        return playlist0;
    }

    public boolean islogin(){
        return listenerr.getIsLogin();
    }

    private int generateIdPlaylist(){
        return listenerr.getPlaylistcounter()+ Playlist.getIdcounter();
    }

    public void AddAudio(String playListname,int auidioId) throws FreeAccountLimitException, NotFoundExeption {
        int tmpInd=0;
        for (Playlist playlist : listenerr.getPlaylists()) {
            if (playlist.getName().equals(playListname)) {
                if (listenerr instanceof RegularListener) {
                    if (playlist.getAudios().size() >= ((RegularListener) listenerr).getAddLimit()) {
                        Warning.warning( "FreeAccountLimitException","maximum add is 10.");
                    }
                }
                for (Audio audio : Database.getDatabase().getAudios()) {
                    if (audio.getId() == auidioId) {
                    if(playlist.getAudios().contains(audio)){
                        Warning.warning("SameExistExption", "its already added");
                    }else {
                        listenerr.getPlaylists().get(tmpInd).getAudios().add(audio);
                        SuccesPopUp.showSuccessfulMessage();
                    }
                    }
                }
            }
            tmpInd++;
        }
    }
    public String playAudio(int audioId){
        for (Audio audio:Database.getDatabase().getAudios()){
            if(audio.getId()==audioId){
                audio.setPlayCount(audio.getPlayCount()+1);
                listenerr.getListeningHistory().putIfAbsent(audioId,0);
                listenerr.getListeningHistory().put(audioId,listenerr.getListeningHistory().get(audioId)+1);
                return "playing "+audio.getTitle()+ "        "+audio.getAudioFileLink();
            }
        }
        return "not found";
    }
    public String followArtist(String artistusername){
        for(User user:Database.getDatabase().getUsers()){
            if(user.getUsername().equals(artistusername)){
                if(user instanceof Artist){
                    if(((Artist) user).getFollowers().contains(listenerr))
                        return "already followed";
                    ((Artist) user).getFollowers().add(listenerr);
                    listenerr.getFollowings().add((Artist) user);
                    return "followed";
                }
            }
        }
        return "error";
    }
    public String likeAudio(int audioId){
        for (Audio audio:Database.getDatabase().getAudios()){
            if(audio.getId()==audioId){
                audio.setLikes(audio.getLikes()+1);
                if(genreScore.containsKey(audio.getGenre())) {
                    genreScore.put(audio.getGenre(), genreScore.get(audio) + 1);
                }else
                    genreScore.put(audio.getGenre(),1);
                return "liked "+audio.getTitle();
            }
        }
        return "not found";
    }
    public String showFollowing(){
        StringBuilder result=new StringBuilder("you are following :\n");
        for(Artist artist:listenerr.getFollowings()){
            result.append(artist.getFullName()).append("\n");
        }
        return String.valueOf(result);
    }
    public String reportArtist(String artistusername,String explanation){
        for(User artist:Database.getDatabase().getUsers()){
            if(artist instanceof Artist){
                if (artist.getUsername().equals(artistusername)){
                    ArrayList<Report> reports=Database.getDatabase().getReports();
                    Report report=new Report(listenerr, (Artist) artist,explanation);
                    Database.getDatabase().getReports().add(report);
                    return "report send";
                }
            }
        }
        return "error";
    }
    public  ArrayList<Artist> showArtists(){
        ArrayList<Artist> artistArrayList=new ArrayList<>();
        for(User artist:Database.getDatabase().getUsers()) {
            if (artist instanceof Artist) {
                artistArrayList.add((Artist) artist);
            }
        }
        return artistArrayList;
    }
    public String showArtist(String userName){
        StringBuilder result=new StringBuilder("Artist:\n");
        for(User artist:Database.getDatabase().getUsers()) {
            if(userName.equals(artist.getUsername())) {
                if (artist instanceof Artist) {
                    result.append("artist name :").append(artist.getFullName()).append(" followers : ").append(((Artist) artist).getFollowers().size()).append("\n");
                    if (artist instanceof Singer) {
                        result.append("musics : ");
                        for (Music album : ((Singer) artist).getAlbums()) {
                            result.append(album.toString());
                        }
                    }

                    if (artist instanceof Podcaster) {
                        result.append("podcasts : ");
                        for (Podcast podcast : ((Podcaster) artist).getPodcasts()) {
                            result.append(podcast.getTitle());
                        }
                    }
                }
            }
        }
        return String.valueOf(result);
    }
    public String userInfo(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(listenerr.getEndSubDate());
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        listenerr.setEndSubDate(calendar.getTime());
        if(listenerr instanceof  PrimiumListener) {
            ((PrimiumListener) listenerr).setNumOfSub(((PrimiumListener) listenerr).getNumOfSub() - 1);
            if(((PrimiumListener) listenerr).getNumOfSub()<=0){
                RegularListener tmplistenerr=new RegularListener(listenerr.getUsername(),listenerr.getPassword(),listenerr.getFullName(),listenerr.getEmail(),listenerr.getPhoneNumber(),listenerr.getDateOfBirth(),listenerr.getCredit());
                listenerr=tmplistenerr;
            }
        }
        return listenerr.toString();
    }
    public String showmyPlaylist(){
        ArrayList<Playlist>myList=listenerr.getPlaylists();
        StringBuilder result=new StringBuilder("my play list : \n");
        for(Playlist playlist:myList){
            result.append(playlist.getName()).append(" , ");
        }
        return String.valueOf(result);
    }
    public  String myListInfo(String playlistName){
        ArrayList<Playlist>myList=listenerr.getPlaylists();
        for(Playlist playlist:myList){
            if(playlistName.equals(playlist.getName())){
                StringBuilder result=new StringBuilder("my song on this  play list : \n");
                for (Audio audio:playlist.getAudios()){
                    result.append(audio.getTitle()).append(" , ");
                }
                return String.valueOf(result);
            }
        }
        return "error : not foound play llist";
    }

    public String filterDate( Date startDate,Date endDate){
        StringBuilder result=new StringBuilder(" song publish between this to date : \n");
        for (Audio audio:Database.getDatabase().getAudios()){
            if(audio.getReleaseDate().after(startDate)&&audio.getReleaseDate().before(endDate)){
                result.append(" title :").append(audio.getTitle()).append("artist name: ").append(audio.getArtistName()).append(" , ");
            }
        }
        return String.valueOf(result);
    }
    public String filterDate( Date startDate){
        StringBuilder result=new StringBuilder(" song publish after this date : \n");
        for (Audio audio:Database.getDatabase().getAudios()){
            if(audio.getReleaseDate().after(startDate)){
                result.append(" title :").append(audio.getTitle()).append("artist name: ").append(audio.getArtistName()).append(" , ");
            }
        }
        return String.valueOf(result);
    }

    public String filterbyGenre(String genreName){
        StringBuilder result=new StringBuilder(genreName);
        for (Audio audio:Database.getDatabase().getAudios()){
            if(audio.getGenre().equals(Genre.valueOf(genreName))){
                result.append(" title : ").append(audio.getTitle()).append(" artist name: ").append(audio.getArtistName()).append(" | ");
            }
        }
        return String.valueOf(result);
    }
    public String filterArtist(String name){
        StringBuilder result=new StringBuilder("artists\n");
        for(User user:Database.getDatabase().getUsers()){
            if(user instanceof Artist){
                if(name.equals(user.getFullName()) || name.equals(user.getUsername())){
                    result.append("user name ").append(user.getUsername()).append(" name : ").append(user.getFullName()).append(" follower : ").append(((Artist) user).getFollowers()).append("\n");
                }
            }
        }
        return String.valueOf(result);
    }
    public ArrayList<Artist> searchByArtistName(String name){
        ArrayList<Artist> artistArrayList=new ArrayList<>();
        for(User user:Database.getDatabase().getUsers()){
            if(user instanceof Artist){
                if(name.equals(user.getFullName()) || name.equals(user.getUsername())){
                    artistArrayList.add((Artist) user);
                }
            }
        }
        return artistArrayList;
    }
    public ArrayList<Audio> searchByAudio(String name){
        ArrayList<Audio> audioArrayList=new ArrayList<>();
        for(Audio audio:Database.getDatabase().getAudios()){
            if(audio.getTitle().equals(name)){
                audioArrayList.add(audio);
            }
        }
        return audioArrayList;
    }

    public ArrayList<Audio> sortLikes(){
        ArrayList<Audio> audioArrayList=Database.getDatabase().getAudios();
        Audio tmpAudio;
        for (int i = 0; i < audioArrayList.size()-1; i++) {
            for (int j = 0; j < audioArrayList.size()-1-i; j++) {
                if(audioArrayList.get(j).compareTo(audioArrayList.get(j+1))>0){
                    tmpAudio=audioArrayList.get(j);
                    audioArrayList.set(j,audioArrayList.get(j+1));
                    audioArrayList.set(j+1,tmpAudio);
                }
            }
        }
        return audioArrayList;
    }
    public String sortPlay(){
        ArrayList<Audio> audioArrayList=Database.getDatabase().getAudios();
        Audio tmpAudio;
        for (int i = 0; i < audioArrayList.size()-1; i++) {
            for (int j = 0; j < audioArrayList.size()-1-i; j++) {
                if(audioArrayList.get(j).getPlayCount()<audioArrayList.get(j+1).getPlayCount()){
                    tmpAudio=audioArrayList.get(j);
                    audioArrayList.set(j,audioArrayList.get(j+1));
                    audioArrayList.set(j+1,tmpAudio);
                }
            }
        }
        StringBuilder result=new StringBuilder("audios :\n");
        for(Audio audio:audioArrayList) {
            result.append(audio.getTitle()).append(", ").append("played : ").append(audio.getLikes()).append("\n");
        }
        return String.valueOf(result);
    }
    public  String increaseCredit(int increaseAmount){
        listenerr.setCredit(listenerr.getCredit()+increaseAmount);
        return "increased";
    }
    public void buySub(SubscriptionPlan subscriptionPlan){
        if(subscriptionPlan.getPrice()>listenerr.getCredit()){
            throw new LowCreditExeption("not enough credit . ");
        }
        listenerr.setCredit(listenerr.getCredit()-subscriptionPlan.getPrice());
        String str=listenerr.getEndSubDate().toString();
        if(!(listenerr instanceof  PrimiumListener)){
            int tmpindex=0;
            ArrayList<User> users=new ArrayList<>();
            for(User user : Database.getDatabase().getUsers()){
                if(user.getUsername().equals(listenerr.getUsername())){
                    PrimiumListener tmplistenerr=new PrimiumListener(listenerr.getUsername(),listenerr.getPassword(),listenerr.getFullName(),listenerr.getEmail(),listenerr.getPhoneNumber(),listenerr.getDateOfBirth(),listenerr.getCredit());
                    tmplistenerr.setSubscription(subscriptionPlan);
                    Calendar calendar=Calendar.getInstance();
                    calendar.setTime(tmplistenerr.getEndSubDate());
                    if(subscriptionPlan.equals(SubscriptionPlan.OneMonth)){
                        calendar.add(Calendar.MONTH,1);
                        tmplistenerr.setEndSubDate(calendar.getTime());
                    }else if(subscriptionPlan.equals(SubscriptionPlan.TwoMonth)){
                        calendar.add(Calendar.MONTH,2);
                        tmplistenerr.setEndSubDate(calendar.getTime());
                    } else if (subscriptionPlan.equals(SubscriptionPlan.SixMonth)) {
                        calendar.add(Calendar.MONTH,6);
                        tmplistenerr.setEndSubDate(calendar.getTime());
                    }
                    listenerr=tmplistenerr;
                    users.add(listenerr);
                }else
                    users.add(user);
                tmpindex++;
            }
            Database.getDatabase().setUsers(users);
        }
        else if(listenerr instanceof  PrimiumListener){
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(listenerr.getEndSubDate());
            if(subscriptionPlan.equals(SubscriptionPlan.OneMonth)){
                calendar.add(Calendar.MONTH,1);
                listenerr.setEndSubDate(calendar.getTime());
            }else if(subscriptionPlan.equals(SubscriptionPlan.TwoMonth)){
                calendar.add(Calendar.MONTH,2);
                listenerr.setEndSubDate(calendar.getTime());
            } else if (subscriptionPlan.equals(SubscriptionPlan.SixMonth)) {
                calendar.add(Calendar.MONTH,6);
                listenerr.setEndSubDate(calendar.getTime());
            }
        }
    }

    public ArrayList<Audio> suggestAudio(int n){
        Map.Entry<Integer,Integer>[] arrmap=listenerr.getListeningHistory().entrySet().toArray(new Map.Entry[listenerr.getListeningHistory().size()]);
        for (int i = 0; i <arrmap.length-1 ; i++) {
            for (int j = 0; j < arrmap.length-1-i; j++) {
                if (arrmap[j].getValue()<arrmap[j+1].getValue()) {
                    Map.Entry<Integer,Integer>tmp=arrmap[j];
                    arrmap[j]=arrmap[j+1];
                    arrmap[j+1]=tmp;
                }
            }
        }
        for(Genre genre:listenerr.getFavoriteGenre()){
            genreScore.putIfAbsent(genre,1);
        }
        for(Map.Entry<Integer,Integer> entrymap1:arrmap){
            for(Audio audio:Database.getDatabase().getAudios()){
                if(entrymap1.getKey()==audio.getId()) {
                    if (genreScore.containsKey(audio.getGenre())){
                        genreScore.put(audio.getGenre(),entrymap1.getValue()+1);
                    }else{
                        genreScore.putIfAbsent(audio.getGenre(),1);
                    }
                }
            }
        }
        for(Artist artist:listenerr.getFollowings()){
            if(artistScore.containsKey(artist)){
                artistScore.put(artist,artistScore.get(artist)+1);
            }else
                artistScore.putIfAbsent(artist,1);
        }

        int score=0;
        ArrayList<Integer>scores=new ArrayList<>();
        ArrayList<Audio>audioArrayList=Database.getDatabase().getAudios();
        int tmpIndex=0;
        for(Audio audio:audioArrayList) {
            for(User user:Database.getDatabase().getUsers()){
                if(user.getUsername().equals(audio.getArtistName())){
                    if(!(artistScore.containsKey(user))){
                        artistScore.putIfAbsent((Artist) user,1);
                    }else
                        score+=artistScore.get(user);
                    if(genreScore.get(audio.getGenre())!=null)
                    score+=genreScore.get(audio.getGenre());
                    scores.add(score);
                }
            }
        }
        for (int i = 0; i < scores.size()-1; i++) {
            for (int j = 0; j < scores.size()-1-i; j++) {
                if(scores.get(j)>scores.get(j+1)){
                    Audio tmp=audioArrayList.get(j+1);
                    audioArrayList.set(j+1,audioArrayList.get(j));
                    audioArrayList.set(j,tmp);
                }
            }
        }
        StringBuilder str=new StringBuilder("suggest:\n");
        ArrayList<Audio> retArrAudio=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            retArrAudio.add(audioArrayList.get(i));
            str.append("title : ").append(audioArrayList.get(i).getTitle()).append(" artist name : ").append(audioArrayList.get(i).getArtistName()).append("\n");
        }
        return retArrAudio;
    }
    public String lyric(int audioId){
        for(Audio audio:Database.getDatabase().getAudios()){
            if(audioId==audio.getId()){
                if(audio instanceof Music)
                return ((Music) audio).getCaption();
                if(audio instanceof Podcast)
                    return ((Music) audio).getCaption();
            }
        }
        return "error : not found";
    }
}
