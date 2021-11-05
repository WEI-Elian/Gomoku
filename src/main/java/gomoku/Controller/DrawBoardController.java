package gomoku.Controller;

import gomoku.BasicClass.Board;
import gomoku.Fuction.Drawstaff;
import gomoku.Main;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DrawBoardController {

    Board board;
    Drawstaff drawstaff=new Drawstaff();
    AnchorPane anchorPane=new AnchorPane();
    int num=1;



    public DrawBoardController(Board board){
        this.board=board;

        AnchorPane anchorPane = new AnchorPane();
        this.anchorPane=anchorPane;
        Canvas canvas1 = new Canvas(900, 900);



        drawstaff.drawChessPane(canvas1);
        anchorPane.getChildren().add(canvas1);

        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add("/style.css");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        printchessboard(board);


    }

    public void printchessboard(Board board){
        int[][]chess=new int[16][16];
        chess=board.getChessboard();
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                if(chess[i][j]==1){
                    drawstaff.drawBlackChessUnit(anchorPane,i,j,num);
                    num++;
                }else if(chess[i][j]==2){
                    drawstaff.drawWhiteChessUnit(anchorPane,i,j,num);
                    num++;
                }
            }

        }



    }

}
