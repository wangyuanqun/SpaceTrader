package t3spacetrader.Window;

import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;


public class MainWindow {

    private final SpaceMaker spaceMaker = SpaceMaker.getMaker();


    @FXML
    private Label textLabel;

    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private AnchorPane mainWindow;

    public void initialize() {
        setText();
        setButtonActions();
    }
    @FXML
    private void setText() {
        textLabel.setText(spaceMaker.getStatus().getString("status"));
    }

    private void setButtonActions() {
        signup.setOnAction(event -> {
            // reset the user
            spaceMaker.setUsername("");
            spaceMaker.setToken("");
            spaceMaker.setSave(false);

            new SignupWindow();
        });

        login.setOnAction(event -> {
            Stage main = (Stage)mainWindow.getScene().getWindow();
            if(spaceMaker.getUsername().isEmpty() || spaceMaker.getToken().isEmpty()) {
                try{
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Login.fxml")));
                    stage.setScene(new Scene(root, 600, 300));
                    stage.setTitle("Login");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                main.close();
            } else {
                try{
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Home.fxml")));
                    stage.setScene(new Scene(root, 800, 400));
                    stage.setTitle("Home");
                    stage.show();

                    main.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
