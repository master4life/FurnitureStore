package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private Button quitButton;

    public void backButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "main.fxml");
    }

    public void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

    public void loginButtonOnAction(ActionEvent event) {
        Controller.startEmployeeInterface(event, "EmployeeView.fxml");
    }
}
