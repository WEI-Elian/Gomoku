package gomoku;

import gomoku.BasicClass.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.util.Objects;

public class Main extends Application {


   public static Stage primaryStage;
   public static AnchorPane anchorPane;
   public static Scene scene;
   public static Player player;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Main.primaryStage = primaryStage;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Login.fxml")));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/style.css");
        Main.scene=scene;
        primaryStage.setTitle("五子棋");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
