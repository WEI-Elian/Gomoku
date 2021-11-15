package gomoku.Controller;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Step;
import gomoku.Fuction.Drawstaff;
import gomoku.Time.HTimer2Plus;
import gomoku.Time.PlayWatcher2Plus;
import gomoku.Time.Unuseful;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReplayBoardControllerplus {
    Drawstaff drawstaff = new Drawstaff();

    public ReplayBoardControllerplus(Board board) {

        AnchorPane anchorPane = new AnchorPane();
        Canvas canvas1 = new Canvas(1100, 900);
        Button button1 = new Button("开始播放");
        Button button2 = new Button("暂停播放");
        Button button3 = new Button("快进播放");
        Button button4 = new Button("后退播放");


        button1.setLayoutX(950);
        button1.setLayoutY(300);
        button2.setLayoutX(950);
        button2.setLayoutY(350);
        button3.setLayoutX(950);
        button3.setLayoutY(400);
        button4.setLayoutX(950);
        button4.setLayoutY(450);


        drawstaff.drawChessPane(canvas1);
        anchorPane.getChildren().add(canvas1);
        anchorPane.getChildren().add(button1);
        anchorPane.getChildren().add(button2);
        anchorPane.getChildren().add(button3);
        anchorPane.getChildren().add(button4);

        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        HTimer2Plus hTimer2Plus = new HTimer2Plus();
        PlayWatcher2Plus playWatcher2Plus = new PlayWatcher2Plus(hTimer2Plus, anchorPane, board.getSteps());

        Unuseful unuseful=new Unuseful(hTimer2Plus, anchorPane, board.getSteps()) ;


        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                anchorPane.getChildren().clear();
                drawstaff.drawChessPane(canvas1);
                anchorPane.getChildren().add(canvas1);
                anchorPane.getChildren().add(button1);
                anchorPane.getChildren().add(button2);
                anchorPane.getChildren().add(button3);
                anchorPane.getChildren().add(button4);
                playWatcher2Plus.speed(1);
                playWatcher2Plus.watch();

            }
        });


        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playWatcher2Plus.pause();

            }
        });

        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                anchorPane.getChildren().clear();
                drawstaff.drawChessPane(canvas1);
                anchorPane.getChildren().add(canvas1);
                anchorPane.getChildren().add(button1);
                anchorPane.getChildren().add(button2);
                anchorPane.getChildren().add(button3);
                anchorPane.getChildren().add(button4);

                playWatcher2Plus.speed(2);
                playWatcher2Plus.watch();

            }
        });


        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                anchorPane.getChildren().clear();
                drawstaff.drawChessPane(canvas1);
                anchorPane.getChildren().add(canvas1);
                anchorPane.getChildren().add(button1);
                anchorPane.getChildren().add(button2);
                anchorPane.getChildren().add(button3);
                anchorPane.getChildren().add(button4);

                unuseful.speed(1);
                unuseful.watch();

            }
        });



    }


}
