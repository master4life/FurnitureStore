package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class MainController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Button quitButton;

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "login.fxml");
    }

    @FXML
    void signupButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "signup.fxml");
    }

    @FXML
    void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

}
