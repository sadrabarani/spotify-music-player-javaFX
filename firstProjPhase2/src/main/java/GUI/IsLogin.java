package GUI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.firstprojphase2.HelloApplication;

import java.io.IOException;

public class IsLogin {
    private static IsLogin isLoginSingelton;
    private static boolean isLogin=false;


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

    public static void notLogin()  {
        try {
            Warning.warning("your not in your account", "please login or make new account !");
            HelloApplication.whereAmI.add(2);
            SetMainScene.setScene(2);
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}

class MyClass {

    public void showSuccessfulMessage(Stage primaryStage) {
       // primaryStage= HelloApplication.getStage();
        // Create a new Popup
        Popup popup = new Popup();

        // Create a Pane to hold the content
        Pane pane = new Pane();

        // Create a Rectangle
        Rectangle rectangle = new Rectangle(100, 50, 200, 100);
        rectangle.setFill(Color.LIGHTGREEN);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        // Create a Label with the text
        Label label = new Label("It is successful");
        label.setLayoutX(120);
        label.setLayoutY(120);

        // Add the Rectangle and Label to the Pane
        pane.getChildren().addAll(rectangle, label);

        // Set the content of the Popup to the Pane
        popup.getContent().add(pane);

        // Calculate position for bottom left corner
        double x = 0; // Left edge
        double y = primaryStage.getHeight() - rectangle.getHeight(); // Bottom edge

        // Set position of the Popup
        popup.setX(x);
        popup.setY(y);

        // Show the Popup
        popup.show(primaryStage);

        // Create a Timeline to close the Popup after 3 seconds
        Duration delay = Duration.seconds(3);
        Timeline timeline = new Timeline(new KeyFrame(delay, event -> popup.hide()));
        timeline.play();
    }
}
