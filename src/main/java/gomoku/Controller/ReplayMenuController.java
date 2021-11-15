package gomoku.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.property.PropertyReference;
import gomoku.BasicClass.Board;
import gomoku.Fuction.Drawstaff;
import gomoku.Main;
import gomoku.SaveLoad.Load;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.Observable;
import java.util.ResourceBundle;


public class ReplayMenuController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Board> table;

    @FXML
    private TableColumn<Board, String> player1;

    @FXML
    private TableColumn<Board, String> player2;

    @FXML
    private TableColumn<Board, String> loader;

    @FXML
    private TableColumn<Board, String> number;

    @FXML
    private JFXButton replay;

    @FXML
    private JFXButton gothough;

    @FXML
    private JFXTextField searchbox;


    private final ObservableList<Board> datelist = FXCollections.observableArrayList();

    Load load = new Load();

    String selected;
    Drawstaff drawstaff = new Drawstaff();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player1.setCellValueFactory(new PropertyValueFactory<>("player1"));
        player2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        loader.setCellValueFactory(new PropertyValueFactory<>("player1"));
        number.setCellValueFactory(new PropertyValueFactory<>("boardname"));

        datelist.addAll(load.Boardall(Main.player));

        FilteredList<Board> filteredDate = new FilteredList<>(datelist, b -> true);
        searchbox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDate.setPredicate(board -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (board.getPlayer1().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (board.getPlayer2().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (board.getBoardname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });


        SortedList<Board> sortedList = new SortedList<>(filteredDate);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedList);

    }

    public void back(ActionEvent e) throws IOException {
        PlayerController playerController = new PlayerController();
    }

    @FXML

    public void getselected(MouseEvent event) throws IOException {
        int index = table.getSelectionModel().getSelectedIndex();
        if (index < -1) {
            return;
        }

        selected = number.getCellData(index).toString();
    }

    public void screeenshotreplay(ActionEvent e) throws IOException {
        ScreenshotReplay screenshotReplay = new ScreenshotReplay();
        screenshotReplay.run(selected);
    }

    public void wholeboardreplay(ActionEvent e) throws IOException {

       Board board = load.loadBoard(selected);
       ReplayBoardControllerplus replayBoardControllerplus=new ReplayBoardControllerplus(board);


    }


}
