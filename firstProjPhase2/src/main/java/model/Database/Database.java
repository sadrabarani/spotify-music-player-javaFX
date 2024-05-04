package model.Database;

import model.Audio.Audio;
import model.Report;
import model.UserAccount.*;

import java.util.ArrayList;

public class Database {
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Report> reports;
    private static Database database;
    private Database() {
        audios=new ArrayList<>();
        users=new ArrayList<>();
        reports=new ArrayList<>();
    }
    public static Database getDatabase(){
        if(database==null)
            database=new Database();
        return database;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
}
