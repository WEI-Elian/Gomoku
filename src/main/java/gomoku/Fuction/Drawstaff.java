package gomoku.Fuction;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

public class Drawstaff {
    private Integer chessPaneWidth = 800;
    private Integer chessPaneHeight = 800;
    private Integer chessPaneUnitWidth = 50;
    private Integer chessPaneUnitHeight = 50;
    private Integer startWidth = 50;
    private Integer endWith = 800;
    private Integer startHeight = 50;
    private Integer endHeight = 800;
    private String chessLineColor = "#000000";

    public void drawChessPane(Canvas canvas) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < 16; i++) {
            gc.setStroke(Paint.valueOf(chessLineColor));
            gc.setLineWidth(1);
            gc.strokeLine(startWidth, (i + 1) * chessPaneUnitHeight, chessPaneWidth, (i + 1) * chessPaneUnitHeight);
            gc.strokeLine((i + 1) * chessPaneUnitWidth, startHeight, (i + 1) * chessPaneUnitWidth, chessPaneHeight);
        }
        gc.fillOval(195, 195, 10, 10);
        gc.fillOval(595, 195, 10, 10);
        gc.fillOval(595, 595, 10, 10);
        gc.fillOval(195, 595, 10, 10);
        gc.fillOval(395, 395, 10, 10);
    }


    public void drawBlackChessUnit(AnchorPane anchorPane, Integer i, Integer j,Integer num) {
        Button button =  new Button();
        anchorPane.getChildren().add(button);
        button.setText(num.toString());
        button.setStyle("-fx-background-color: #000;-fx-background-radius: 30; -fx-effect:dropshadow(three-pass-box, #72b9da, 8.0,0, 0, 0);-fx-text-fill: white;  ");
        drawChessUnit(button, i, j);
    }

    public void drawWhiteChessUnit(AnchorPane anchorPane, Integer i, Integer j,Integer num) {
        Button button =  new Button();
        anchorPane.getChildren().add(button);
        button.setText(num.toString());
        button.setStyle("-fx-background-radius: 30; -fx-effect:dropshadow(three-pass-box, #72b9da, 8.0,0, 0, 0); ");
        drawChessUnit(button, i, j);

    }
    public void drawChessUnit( Button button, Integer i, Integer j ) {

        button.setFocusTraversable(false);
        button.setPrefSize(40, 40);
        button.setLayoutX((i+1)*chessPaneUnitWidth-40/2);
        button.setLayoutY((j+1)*chessPaneUnitWidth-40/2);
    }

    public int[] getPoint(double x, double y) {
        int[] point = new int[2];
        if (x >= 0 && x <= 825 && y >= 0 && y <= 825) {
            int i;
            int j;
            if (x < 75) {
                i = 0;
            } else if (x <= 775) {
                if (x % 50 >= 25) {
                    i = (int) x / 50;
                } else {
                    i = (int) x / 50 - 1;
                }
            } else {
                i = 15;
            }

            if (y < 75) {
                j = 0;
            } else if (y <= 775) {
                if (y % 50 >= 25) {
                    j = (int) y / 50;
                } else {
                    j = (int) y / 50 - 1;
                }
            } else {
                j = 15;
            }
            point[0] = i;
            point[1] = j;
            return point;
        }
        return null;
    }
    public void drawPoint(int i, int j, AnchorPane anchorPane, Boolean isBlack,Integer num) {
        if (isBlack) {

            drawBlackChessUnit(anchorPane, i , j,num);

        } else {

            drawWhiteChessUnit(anchorPane, i , j , num);

        }

    }

}
