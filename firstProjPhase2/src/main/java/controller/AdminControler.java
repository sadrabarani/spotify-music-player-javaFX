package controller;

import model.Audio.Audio;
import model.Database.Database;
import model.Report;
import model.UserAccount.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;

public class AdminControler {
    Admin admin;
    private static AdminControler adminControler;

    public AdminControler() {
    }

    public static AdminControler getAdminControler() {
        if (adminControler == null)
            adminControler=new AdminControler();
        return adminControler;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String signUpAdmin(String username, String pasword, String name, String email, String phoneNum, Date birthDate){
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
        admin = Admin.getAdmin(username, pasword, name, email, phoneNum, birthDate);
        setAdmin(admin);
        Database.getDatabase().getUsers().add((Admin)admin);
        admin.setIsLogin(true);
        return  "admin accaount successfully created .";
    }
    public String login(String username,String password){
        ArrayList<User>users=Database.getDatabase().getUsers();
        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                if(admin.getIsLogin()==true)
                    return "you are in already in your profile .";
                setAdmin((Admin) user);
                admin.setIsLogin(true);
                return "login successful .";
            }
        }
        return "error : user name or password is wrong";
    }
    public String logout(){
        ArrayList<User>users=Database.getDatabase().getUsers();
        admin.setIsLogin(false);
        return "logout successfull";
    }
    public String accountInfo(){
        return admin.toString();
    }
    public String lookReport(){
        StringBuilder result=new StringBuilder("reports :\n");
        ArrayList<Report> reports= Database.getDatabase().getReports();
        for(Report report:reports) {
            result.append(" artist name : ").append(report.getReportedArtist().getUsername()).append(", reporter name : ").append(report.getReportingUser().getUsername()).append(" exeplenation: ").append(report.getDescription()).append("\n");
        }
        return String.valueOf(result);
    }
    public String lookArtists(){
        StringBuilder result=new StringBuilder("artists :\n");
        for(User user:Database.getDatabase().getUsers()){
            if(user instanceof Artist){
                result.append(user.getUsername()).append(", ");
            }
        }
        return String.valueOf(result);
    }
    public String lookAudios(){
        StringBuilder result=new StringBuilder("audios :\n");
        for(Audio audio:Database.getDatabase().getAudios()) {
            result.append(audio.getTitle()).append(", ").append(" , audio id : ").append(audio.getId()).append("  ");
        }
        return String.valueOf(result);
    }
    public String lookAudioInfo(int audioId){
        for(Audio audio:Database.getDatabase().getAudios()) {
            if(audio.getId()==audioId){
                return "artist name : "+audio.getArtistName()+
                        ", title"+audio.getTitle() +
                        ", play count "+audio.getPlayCount()+
                        ", file link"+audio.getAudioFileLink()+
                        ", likes : "+audio.getLikes();
            }
        }
        return "error : not found";
    }
    public String lookArtistInfo(String username){
        for(User user:Database.getDatabase().getUsers()){
            if(username.equals(user.getUsername())){
                return  "user name"+user.getUsername()+
                        " email: "+user.getEmail()+
                        " full namme : "+user.getFullName()+
                        " phone number ;"+user.getPhoneNumber();
            }
        }
        return "error : not found";
    }
    public String lookMostLikeAudio(){
        ArrayList<Audio> audioArrayList=Database.getDatabase().getAudios();
        Audio tmpAudio;
        for (int i = 0; i < audioArrayList.size()-1; i++) {
            for (int j = 0; j < audioArrayList.size()-1-i; j++) {
                if(audioArrayList.get(j).getLikes()<audioArrayList.get(j+1).getLikes()){
                    tmpAudio=audioArrayList.get(j);
                    audioArrayList.set(j,audioArrayList.get(j+1));
                    audioArrayList.set(j+1,tmpAudio);
                }
            }
        }
        StringBuilder result=new StringBuilder("audios :\n");
        for(Audio audio:audioArrayList) {
            result.append(audio.getTitle()).append(", ").append("likes : ").append(audio.getLikes()).append("\n");
        }
        return String.valueOf(result);
    }
}
