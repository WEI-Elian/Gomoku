package gomoku.Controller;


import gomoku.BasicClass.Player;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button button;


    @FXML
    private TextField nameT;

    @FXML
    private PasswordField passT;



    Load load=new Load();
    public void login(ActionEvent e) throws IOException {
        Player player=load.loadPlayer(nameT.getText(),passT.getText());
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
            if("00000".equals(player.getPassnum())){
                Main.player=player;
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Resetpassword.fxml")));
                Scene scene = new Scene(parent);
                Main.primaryStage.setScene(scene);



            }else{
                Main.player=player;
                PlayerController playerController=new PlayerController();
            }



        }else if(player==null){
//            System.out.println("sl");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("输入的账号或密码有误请重新输入");
            alert.showAndWait();
        }
    }


    public void signup(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Signup.fxml")));
        Scene scene = new Scene(parent);
        Main.primaryStage.setScene(scene);
    }

}
