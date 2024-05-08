package GUI;

import java.io.IOException;

public class IsLogin {
    private static IsLogin isLoginSingelton;
    private static boolean isLogin;


    public static IsLogin getIsLoginSingelton() {
        if (isLoginSingelton == null) {
            isLoginSingelton=new IsLogin();
        }
        return isLoginSingelton;
    }

    public static void setIsLogin(boolean isLogin) {
        IsLogin.isLogin = isLogin;
    }

    public static boolean isIsLogin() {
        return isLogin;
    }

    public void notLogin() throws IOException {
        //todo alert
        SetMainScene.setScene(2);
    }

}
