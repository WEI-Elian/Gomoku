package gomoku.Controller;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Step;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import gomoku.SaveLoad.Save;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveBoardController {


    Save save = new Save();
    Load load=new Load();


    public SaveBoardController(String player1, String player2, int[][] chessboard, String Chessname, ArrayList<Step>steps){
        Stage window = new Stage();
        Button button=new Button("确定！");
        TextField textField=new TextField();
        window.setTitle("存档");
        //modality要使用Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(500);
        window.setMinHeight(500);
        VBox layout = new VBox(20);
        Label label=new Label("输入你的存档姓名");

        layout.getChildren().addAll(label, textField, button);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.show();
        button.setOnAction(event -> {
            window.close();
            snapshot(Main.anchorPane,textField.getText());

            savaBoard(player1,player2,chessboard,textField.getText(),steps);



        });
    }


    public void savaBoard(String player1, String player2, int[][] chessboard, String Chessname, ArrayList<Step>steps) {
        Board board=new Board(player1,player2,chessboard,Chessname,steps);
        save.add(board,Chessname);
    }

    public void snapshot(Node view, String photoname) {
        Image image = view.snapshot(null, null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png",
                    new File("D:\\GitHub\\Gomoku\\src\\main\\resources\\Screenshot\\" + photoname + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }




