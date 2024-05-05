package GUI.mainSection;

import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class mainPage {
    public void setSideBar(){
        VBox root = new VBox();

        // Create HBox for horizontal layout
        HBox hbox = new HBox();

        // Create content for the left side of HBox
        // You can add any other components here
        // Example:
        // hbox.getChildren().add(new Button("Left Side"));

        // Create VerticalSplitPane for the right side of HBox
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefWidth(300); // Adjust width as needed

        // Add content to the split pane
        // Search TextField
        TextField searchField = new TextField();
        splitPane.getItems().add(searchField);

        // Button for home
        Button homeButton = new Button("Home");
        splitPane.getItems().add(homeButton);

        // Button for library items
        Button libraryButton = new Button("Library Items");
        splitPane.getItems().add(libraryButton);

        // Button for all artists
        Button artistsButton = new Button("All Artists");
        splitPane.getItems().add(artistsButton);
        Button audiosButton = new Button("All Audios");
        splitPane.getItems().add(audiosButton);
        splitPane.setDividerPositions(0.25, 0.5, 0.75);
        hbox.getChildren().add(splitPane);

        // Make the right side of HBox grow with the window
        HBox.setHgrow(splitPane, Priority.ALWAYS);

        // Add HBox to the VBox
        root.getChildren().add(hbox);
    }
}