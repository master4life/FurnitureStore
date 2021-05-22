package FurnitureStore.signup;

import FurnitureStore.base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignupController {

    @FXML
    private Button registerButton;

    public void SignInLabelOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/login/login.fxml");
    }
    public void RegisterButtonOnAction(ActionEvent event) {

    }
}
