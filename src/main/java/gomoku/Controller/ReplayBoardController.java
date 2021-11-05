package gomoku.Controller;

import com.sun.jmx.remote.protocol.iiop.ProxyInputStream;
import gomoku.BasicClass.Board;
import gomoku.BasicClass.Step;
import gomoku.Fuction.Drawstaff;
import gomoku.Main;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.TimerTask;

public class ReplayBoardController extends TimerTask {


    Drawstaff drawstaff = new Drawstaff();
    AnchorPane anchorPane;
    Stage stage = new Stage();
    int i = 0;
    int num;
    Step step;

    public ReplayBoardController(AnchorPane anchorPane, Step step,int i,int num) {

        this.anchorPane = anchorPane;
        this.step = step;
        this.i=i;
        this.num=num;

    }


    @Override
    public void run() {
       if(i==1){
           Drawwhite(step,num);
       }else{
           Drawblack(step,num);
       }
    }

    public void Drawblack(Step step,int num) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                drawstaff.drawBlackChessUnit(anchorPane, step.getX(), step.getY(), num);
            }
        });
    }
        public void Drawwhite (Step step,int num) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    drawstaff.drawWhiteChessUnit(anchorPane, step.getX(), step.getY(), num);
                }
            });


        }


    }

