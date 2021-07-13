package t3spacetrader.Window;

import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.util.Objects;

public class LoginWindow {

    private final SpaceMaker spaceMaker = SpaceMaker.getMaker();

    @FXML
    private AnchorPane loginWindow;

    @FXML
    private TextField username;
    @FXML
    private TextField token;
    @FXML
    private Button cancel;
    @FXML
    private Button login;

    public void initialize() {

        createButton();
    }

    private void createButton() {
        login.setOnAction(e -> {
            if(username.getText().isEmpty() || token.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You need to enter username and token.");
                alert.show();
            } else {
                JSONObject obj = spaceMaker.getUserInfo(token.getText(), username.getText());
                if(obj.toString().contains("error")) {
                    username.clear();
                    token.clear();
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid username or token.");
                    alert.show();
                } else {

                    spaceMaker.setUsername(username.getText());
                    spaceMaker.setToken(token.getText());
                    spaceMaker.setSave(true);

                    try{
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Home.fxml")));
                        stage.setScene(new Scene(root, 800, 400));
                        stage.setTitle("Home");
                        stage.show();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    Stage main = (Stage)loginWindow.getScene().getWindow();
                    main.close();
                }
            }
        });

        cancel.setOnAction(e -> {

            spaceMaker.setUsername("");
            spaceMaker.setToken("");
            spaceMaker.setSave(false);

            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        });

    }
}