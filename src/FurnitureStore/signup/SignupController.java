package FurnitureStore.signup;

import FurnitureStore.base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SignupController {

    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField email;
    @FXML
    private PasswordField passtxt;
    @FXML
    private Label registerLabel;


    public void SignInLabelOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/login/login.fxml");
    }
    public void RegisterButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/signup/signupInfo.fxml");
    }
}
