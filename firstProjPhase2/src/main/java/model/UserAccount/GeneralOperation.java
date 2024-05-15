package model.UserAccount;

import GUI.IsLogin;
import org.example.firstprojphase2.HelloApplication;

public interface GeneralOperation {
    default int backTo (){
        HelloApplication.whereAmI.remove(HelloApplication.whereAmI.size()-1);
        return HelloApplication.whereAmI.get(HelloApplication.whereAmI.size()-1);
    }
    default void logout (){
        IsLogin.setIsLogin(false);
    }
    default void login (){
        IsLogin.setIsLogin(true);
    }
    default void signup(){
        IsLogin.setIsLogin(true);
    }
    default void search(){
        
    }
}