package gomoku.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gomoku.BasicClass.Player;
import gomoku.Main;
import gomoku.SaveLoad.Save;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.Objects;

public class PrefirstloginController {


    @FXML
    private JFXTextField phonenum;

    @FXML
    private JFXButton login;

    @FXML
    private JFXPasswordField passwordnum;

    @FXML
    private JFXPasswordField repasswordnum;


    Save save=new Save();


    public void login(ActionEvent e) throws IOException {
        if (phonenum.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("请输入手机号");
            alert.showAndWait();
        } else if (!passwordnum.getText().equals(repasswordnum.getText())&&judgepassword(passwordnum.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("请再次输入的密码输入是否正确");
            alert.showAndWait();
        } else if(!judgepassword(passwordnum.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("密码格式不正确");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("修改成功");
            alert.showAndWait();
            save.savepassword(Main.player,passwordnum.getText());
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Login.fxml")));
            Scene scene = new Scene(parent);
            Main.primaryStage.setScene(scene);


        }


    }


    public boolean judgepassword(String password) {
        boolean zwa = false, zwb = false;
        if (password == null || password.length() < 6) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char zwch = password.charAt(i);
            if (zwch >= '0' && zwch <= '9') {
                zwa = true;
            } else {
                if ((zwch >= 'a' && zwch <= 'z') || (zwch >= 'A' && zwch <= 'Z')) {
                    zwb = true;
                } else {
                    return false;
                }
            }
        }
        return (zwa && zwb);
    }

}




