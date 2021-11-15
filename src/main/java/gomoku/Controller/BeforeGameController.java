package gomoku.Controller;

import com.sun.deploy.util.StringUtils;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class BeforeGameController {

    Load load = new Load();
    ArrayList<String> names = new ArrayList<>();
    String againstPlayername;
    Stage window = new Stage();
    AnchorPane anchorPane = new AnchorPane();
    Button button = new Button("开始挑战！");
    Label label1 = new Label("输入对战棋手");
    Label label2 = new Label("黑方：");
    Label label3 = new Label("白方：");

    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    ListView<String> listView = new ListView<>();

    public BeforeGameController() {
        window.setTitle("let's roll");
        //modality要使用Modality.APPLICATION_MODEL
        /*window.initModality(Modality.APPLICATION_MODAL);*/
//        window.setMinWidth(200);
//        window.setMinHeight(200);
//        ListView<String> listView = new ListView<>();
//        for (String n : names) {
//            listView.getItems().add(n);
//        }
//        this.listView = listView;
//        listView.setPrefSize(200, 200);
//        VBox layout = new VBox(20);
//        layout.getChildren().addAll(label1, listView, button);
//        layout.setAlignment(Pos.CENTER);

        label1.setLayoutY(50);
        label1.setLayoutX(200);
        label2.setLayoutY(100);
        label2.setLayoutX(100);
        label3.setLayoutY(150);
        label3.setLayoutX(100);
        textField1.setLayoutX(150);
        textField1.setLayoutY(100);
        textField2.setLayoutX(150);
        textField2.setLayoutY(150);
        window.setHeight(500);
        window.setWidth(500);
        button.setLayoutX(200);
        button.setLayoutY(200);

        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(textField1);
        anchorPane.getChildren().add(textField2);
        anchorPane.getChildren().add(button);

        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.show();

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                String whitePlayername = textField2.getText();
                Main.playername2=whitePlayername;
                String blackPlayername = textField1.getText();
                Main.playername1=blackPlayername;
                try {
                    if(load.findPlayer(blackPlayername)&&load.findPlayer(whitePlayername)){
                        window.close();
                        GameController gameController = new GameController(blackPlayername,whitePlayername);
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.titleProperty().set("提示");
                        alert.headerTextProperty().set("输入的玩家可能不存在");
                        alert.showAndWait();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }


    public void Chose() {
//        names = load.getallplayername(Main.player);

        window.setTitle("let's roll");
        //modality要使用Modality.APPLICATION_MODEL
        /*window.initModality(Modality.APPLICATION_MODAL);*/
//        window.setMinWidth(200);
//        window.setMinHeight(200);
//        ListView<String> listView = new ListView<>();
//        for (String n : names) {
//            listView.getItems().add(n);
//        }
//        this.listView = listView;
//        listView.setPrefSize(200, 200);
//        VBox layout = new VBox(20);
//        layout.getChildren().addAll(label1, listView, button);
//        layout.setAlignment(Pos.CENTER);

        label1.setLayoutY(50);
        label1.setLayoutX(200);
        label2.setLayoutY(100);
        label2.setLayoutX(100);
        label3.setLayoutY(150);
        label3.setLayoutX(100);
        textField1.setLayoutX(150);
        textField1.setLayoutY(100);
        textField2.setLayoutX(150);
        textField2.setLayoutY(150);
        window.setHeight(500);
        window.setWidth(500);
        button.setLayoutX(200);
        button.setLayoutY(200);

        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(textField1);
        anchorPane.getChildren().add(textField2);
        anchorPane.getChildren().add(button);

        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.show();

    }

}
