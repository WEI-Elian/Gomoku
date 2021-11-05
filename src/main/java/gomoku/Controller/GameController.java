package gomoku.Controller;

import com.jfoenix.controls.JFXButton;
import gomoku.BasicClass.Board;
import gomoku.BasicClass.Step;
import gomoku.Fuction.Drawstaff;
import gomoku.Fuction.PlayChess;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import gomoku.SaveLoad.Save;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class GameController {

    Button button1;//保存存档按键
    Button button2;//退出到主界面


    private String player1;
    private String player2;

    PlayChess playChess = new PlayChess();
    Drawstaff drawstaff = new Drawstaff();
    int[][] chessboard = new int[16][16];
    ArrayList<Step> steps = new ArrayList<>();


    Save save = new Save();
    Load load = new Load();


    public GameController(String player1, String player2) {

        this.player1 = player1;
        this.player2 = player2;

        Canvas canvas = new Canvas(900, 900);
        Main.anchorPane.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Main.anchorPane.getChildren().removeAll(Main.anchorPane.getChildren());


        drawstaff.drawChessPane(canvas);
        Main.anchorPane.getChildren().add(canvas);


        letusplay(Main.primaryStage.getScene());

        Button button1 = new JFXButton("存档本局");
        this.button1 = button1;
        button1.setLayoutY(600);
        button1.setLayoutX(850);
        Main.anchorPane.getChildren().add(button1);
        Button button2 = new JFXButton("离开本局");
        this.button2 = button2;
        button2.setLayoutY(650);
        button2.setLayoutX(850);
        Main.anchorPane.getChildren().add(button2);


        button1.setOnAction(event -> {
            SaveBoardController saveBoardController = new SaveBoardController(player1, player2, chessboard, "", steps);

        });

        button2.setOnAction(event -> {
            PlayerController playerController = new PlayerController();

        });


    }

    public void letusplay(Scene scene) {
        final PlayChess[] go = {new PlayChess()};
        go[0].setStart(System.currentTimeMillis());
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                go[0].setEnd(System.currentTimeMillis());


                int[] d;


                if (go[0].getWin() == 0 && !go[0].me) {
                    /*if (choice[0] == 1) {*/

                    d = drawstaff.getPoint(event.getSceneX(), event.getSceneY());

                    if (d == null) {
                        return;
                    }
                    if (go[0].chessBoard[d[0]][d[1]] == 0) {
                        go[0].blackGo(d[0], d[1]);
                        System.out.println(go[0].getTime());
                        steps.add(new Step(d[0], d[1], go[0].getTime()));
                        drawstaff.drawPoint(d[0], d[1], Main.anchorPane, go[0].me,steps.size());
                        if (go[0].getWin() == 1) {
                            System.out.println("1");
                            showSuccess(Main.primaryStage, player1 + "获胜");
                            chessboard = go[0].chessBoard;

                        }
                        /*d = go[0].aiGo();
                        draw.drawPoint(d[0], d[1], anchorPane, canvas, go[0].me);*/
                        if (go[0].getWin() == 2) {
                            showSuccess(Main.primaryStage, player2 + "获胜");
                            System.out.println("2");
                            chessboard = go[0].chessBoard;


                        }
                    }

                }
                if (go[0].getWin() == 0 && go[0].me) {
                    /*if (choice[0] == 1) {*/
                    d = drawstaff.getPoint(event.getSceneX(), event.getSceneY());
                    if (d == null) {
                        return;
                    }
                    if (go[0].chessBoard[d[0]][d[1]] == 0) {
                        go[0].whiteGo(d[0], d[1]);
                        System.out.println(go[0].getTime());
                        steps.add(new Step(d[0], d[1], go[0].getTime()));
                        drawstaff.drawPoint(d[0], d[1], Main.anchorPane, go[0].me,steps.size());
                        if (go[0].getWin() == 1) {
                            System.out.println("1");
                            showSuccess(Main.primaryStage, player1 + "获胜");
                            chessboard = go[0].chessBoard;

                        }
                        /*d = go[0].aiGo();
                        draw.drawPoint(d[0], d[1], anchorPane, canvas, go[0].me);*/
                        if (go[0].getWin() == 2) {
                            showSuccess(Main.primaryStage, player2 + "获胜");
                            System.out.println("2");
                            chessboard = go[0].chessBoard;


                        }
                    }

                }
                go[0].setStart(System.currentTimeMillis());

            }

        });


    }


    public void showSuccess(Stage primaryStage, String text) {

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hBox);

        Label label = new Label();
        label.setText(text);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(Font.font(20));
        label.setTextFill(Paint.valueOf("#333"));
        hBox.getChildren().add(label);


        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(200);
        //获取primaryStage的屏幕位置
        primaryStage.getX();
        primaryStage.getY();
        stage.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - stage.getWidth() / 2);
        stage.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - stage.getHeight() / 2);
        stage.show();

    }


    /*public void savaBoard(String player1, String player2, int[][] chessboard, String Chessname) {
        Board board=new Board(player1,player2,chessboard,Chessname);
        save.add(board,Chessname);
    }*/


    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }
}
