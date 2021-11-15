package gomoku.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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

public class SignupController {
    @FXML
    private JFXTextField namefield;

    @FXML
    private JFXButton login;

    Save save=new Save();




    public void login(ActionEvent e) throws IOException {
        if(namefield.getText()!=null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("提示");
            alert.headerTextProperty().set("添加成功");
            alert.showAndWait();
            save.addPlayer(namefield.getText());
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/Login.fxml")));
            Scene scene = new Scene(parent);
            Main.primaryStage.setScene(scene);
        }

    }
















}
