package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignupController {

    @FXML
    private Button backButton;

    @FXML
    private Button quitButton;

    public void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

    public void backButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "main.fxml");
    }
}
