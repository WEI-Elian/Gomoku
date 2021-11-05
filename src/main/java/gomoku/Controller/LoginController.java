package gomoku.Controller;


import gomoku.BasicClass.Player;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;

public class LoginController {

    @FXML
    private Button button;


    @FXML
    private TextField nameT;

    @FXML
    private TextField passnumT;



    Load load=new Load();
    public void login(ActionEvent e) throws IOException {
        Player player=load.loadPlayer(nameT.getText(),passnumT.getText());
        if (player!=null) {
           /* Main.anchorPane = new AnchorPane();
            Main.anchorPane.setStyle("-fx-background-color:#E5C992;");
            Canvas canvas = new Canvas(800, 800);
            Main.anchorPane.getChildren().add(canvas);
            Scene scene = new Scene(Main.anchorPane);
            Main.primaryStage.setScene(scene);
            Main.primaryStage.setTitle("五子棋");
            Main.primaryStage.setWidth(1000);
            Main.primaryStage.setHeight(850);
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();*/
            Main.player=player;
            PlayerController playerController=new PlayerController();
        }else if(player==null){
            System.out.println("sl");
        }
    }
}
