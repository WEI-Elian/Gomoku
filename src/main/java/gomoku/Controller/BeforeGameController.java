package gomoku.Controller;

import com.sun.deploy.util.StringUtils;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.util.ArrayList;

public class BeforeGameController {

    Load load = new Load();
    ArrayList<String> names = new ArrayList<>();
    String againstPlayername;
    Stage window = new Stage();
    Button button = new Button("开始挑战！");
    Label label = new Label("选择你的对战棋手");
    ListView<String> listView = new ListView<>();

    public BeforeGameController() {

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                againstPlayername = listView.getSelectionModel().getSelectedItem();
                window.close();
                GameController gameController=new GameController(Main.player.getName(),againstPlayername);


            }
        });
    }


    public void Chose() {
        names = load.getallplayername(Main.player);

        window.setTitle("let's roll");
        //modality要使用Modality.APPLICATION_MODEL
        /*window.initModality(Modality.APPLICATION_MODAL);*/
        window.setMinWidth(500);
        window.setMinHeight(500);
        ListView<String> listView = new ListView<>();
        for (String n : names) {
            listView.getItems().add(n);
        }
        this.listView = listView;
        listView.setPrefSize(200, 200);
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, listView, button);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style.css");
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.show();

    }

}
