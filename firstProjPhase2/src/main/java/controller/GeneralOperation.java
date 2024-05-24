package controller;

import GUI.IsLogin;
import GUI.SetMainScene;
import GUI.mainSection.SearchPage;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;
import java.util.ArrayList;

public interface GeneralOperation {
    default int backTo (){
        HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
        return HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1);
    }
    default void logout (){
        IsLogin.setIsLogin(false);
    }
    default void login () throws IOException {
        IsLogin.setIsLogin(true);
        HelloApplication.whereAmI=new ArrayList<>();
        HelloApplication.whereAmI.add(10);
        IsLogin.setIsLogin(true);
        SetMainScene.setScene(10);
    }
    default void signup() throws IOException {
        HelloApplication.whereAmI=new ArrayList<>();
        HelloApplication.whereAmI.add(3);
        IsLogin.setIsLogin(true);
        SetMainScene.setScene(3);
    }
    default void search(String str){
        SearchPage.setArrayList(ListenerControler.getListenerControler().searchByArtistName(str));
        SearchPage.setAudioArrayList(ListenerControler.getListenerControler().searchByAudio(str));
        try {
            HelloApplication.whereAmI.add(12);
            SetMainScene.setScene(12);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}