package gomoku.Controller;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Step;
import gomoku.Fuction.Drawstaff;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Timer;

public class ReadBoardController {

    Load load = new Load();


    Stage window = new Stage();
    Button button1 = new Button("查看比赛结果");
    Button button2 = new Button("回放比赛过程");
    Label label = new Label("下列是您的棋局，请选择读档的方式");
    ListView<String> listView = new ListView<>();
    ArrayList<String> names = new ArrayList<>();
    String boardname;
    Board board;
    ArrayList<Step> steps = new ArrayList<Step>();
    Drawstaff drawstaff = new Drawstaff();

    public ReadBoardController() {

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boardname = listView.getSelectionModel().getSelectedItem();
                board = load.loadBoard(boardname);
                DrawBoardController drawBoardController = new DrawBoardController(board);
                window.close();


            }
        });


        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boardname = listView.getSelectionModel().getSelectedItem();
                board = load.loadBoard(boardname);
                window.close();
                steps = board.getSteps();

                AnchorPane anchorPane = new AnchorPane();
                Canvas canvas1 = new Canvas(900, 900);


                drawstaff.drawChessPane(canvas1);
                anchorPane.getChildren().add(canvas1);


                Scene scene = new Scene(anchorPane);
                scene.getStylesheets().add("/style.css");
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Timer timer = new Timer();
                for (int i =0;i <steps.size(); i++) {
                    ReplayBoardController replayBoardController = new ReplayBoardController(anchorPane, steps.get(i),i%2,i+1);
                    timer.schedule(replayBoardController, steps.get(i).getTime());
                }

                  /*  ReplayBoardController replayBoardController = new ReplayBoardController(anchorPane);
                    replayBoardController.start();*/


            }
        });


    }

    public void Chose() {

        names = load.loadallBoard(Main.player);
        window.setTitle("选择");
        //modality要使用Modality.APPLICATION_MODEL
        /* window.initModality(Modality.APPLICATION_MODAL);*/
        window.setMinWidth(500);
        window.setMinHeight(500);
        ListView<String> listView = new ListView<>();
        for (String n : names) {
            listView.getItems().add(n);
        }
        this.listView = listView;
        listView.setPrefSize(200, 200);
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, listView, button1, button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.show();

    }


}
