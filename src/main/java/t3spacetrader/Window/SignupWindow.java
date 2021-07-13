package t3spacetrader.Window;

import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONObject;

public class SignupWindow {

    private final SpaceMaker spaceMaker = SpaceMaker.getMaker();

    private final Stage stage;
    private final AnchorPane pane;

    public SignupWindow() {
        stage = new Stage();
        pane = new AnchorPane();
        Scene scene = new Scene(pane, 400, 270);
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.show();


        Label name = new Label("User name: ");
        name.setLayoutX(30);
        name.setLayoutY(35);

        TextField user = new TextField();
        user.setLayoutY(30);
        user.setLayoutX(100);

        Button ok = new Button("OK");
        ok.setLayoutX(280);
        ok.setLayoutY(30);

        ok.setOnAction(e -> {
            if(user.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You need to choose a user name.");
                alert.show();
            } else {
                Label info = new Label("You should write down token and name or save them for this time:");
                info.setLayoutX(30);
                info.setLayoutY(80);

                JSONObject to = spaceMaker.getUserToken(user.getText());

                // check if user already exists
                if(to.toString().contains("error")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, to.toString());
                    alert.show();
                } else {

                    Label userLabel = new Label("Username:");
                    userLabel.setLayoutY(125);
                    userLabel.setLayoutX(40);


                    TextField username = new TextField(user.getText());
                    username.setLayoutY(120);
                    username.setLayoutX(120);
                    username.setEditable(false);


                    Label tokenLabel = new Label("Username:");
                    tokenLabel.setLayoutY(165);
                    tokenLabel.setLayoutX(40);

                    TextField usertoken = new TextField(to.getString("token"));
                    usertoken.setLayoutY(160);
                    usertoken.setLayoutX(120);
                    usertoken.setEditable(false);

                    Button save = new Button("save");
                    save.setLayoutY(200);
                    save.setLayoutX(120);

                    save.setOnAction(ev -> {
                        spaceMaker.setUsername(user.getText());
                        spaceMaker.setToken(to.getString("token"));
                        spaceMaker.setSave(true);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "your data has been saved.\nplease go to login automatically.");
                        alert.show();
                        stage.close();
                    });

                    Button cancel = new Button("close");
                    cancel.setLayoutY(200);
                    cancel.setLayoutX(220);

                    cancel.setOnAction(ev -> {
                        spaceMaker.setUsername("");
                        spaceMaker.setToken("");
                        spaceMaker.setSave(false);
                        stage.close();
                    });


                    pane.getChildren().addAll(info, username, usertoken, save, cancel, userLabel, tokenLabel);
                }
            }
        });

        pane.getChildren().addAll(name, user, ok);
    }
}
