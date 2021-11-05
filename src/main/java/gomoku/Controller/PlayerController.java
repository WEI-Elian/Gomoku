package gomoku.Controller;


import com.jfoenix.controls.JFXButton;
import gomoku.Fuction.Drawstaff;
import gomoku.Fuction.PlayChess;
import gomoku.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class PlayerController {

    public JFXButton button1;
    public JFXButton button2;
    public JFXButton button3;


    Drawstaff drawstaff = new Drawstaff();
    PlayChess playChess = new PlayChess();
    BeforeGameController beforeGameController = new BeforeGameController();
    ReadBoardController readBoardController=new ReadBoardController();

    public PlayerController() {


        Main.primaryStage.setX(240);
        Main.primaryStage.setY(10);
        Main.anchorPane = new AnchorPane();
        Main.anchorPane.setStyle("-fx-background-color:#E5C992;");
       /* Canvas canvas = new Canvas(900, 900);
        Main.anchorPane.getChildren().add(canvas);*/

        Scene scene = new Scene(Main.anchorPane);
        scene.getStylesheets().add("/style.css");



        JFXButton button1 = new JFXButton("开始游戏");
        //button1.getStylesheets().add("/style.css");
        this.button1 = button1;
        button1.setLayoutY(300);
        button1.setLayoutX(850);
        Main.anchorPane.getChildren().add(button1);
        JFXButton button2 = new JFXButton("查看存档");
        this.button2 = button2;
        button2.setLayoutY(350);
        button2.setLayoutX(850);
        Main.anchorPane.getChildren().add(button2);
        JFXButton button3 = new JFXButton("退出登录");
        this.button3 = button3;
        button3.setLayoutY(400);
        button3.setLayoutX(850);
        Main.anchorPane.getChildren().add(button3);


        Main.primaryStage.setScene(scene);
        Main.primaryStage.setTitle("五子棋");
        Main.primaryStage.setWidth(1000);
        Main.primaryStage.setHeight(900);
        Main.primaryStage.setResizable(false);
        Main.primaryStage.show();

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*Canvas canvas = new Canvas(900, 900);
                Main.anchorPane.getChildren().add(canvas);
                drawstaff.drawChessPane(canvas);*/
                //选择棋手
                beforeGameController.Chose();
                //开始游戏
                /*play(scene);*/
            }
        });
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                readBoardController.Chose();
            }
        });
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Parent parent = null;
                try {
                    parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Login.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(parent);
                Main.primaryStage.setScene(scene);

            }
        });
    }




}







