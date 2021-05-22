package FurnitureStore.login;

import FurnitureStore.base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button loginButton;

    public void RegisterLabelOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/signup/signup.fxml");
    }

    public void LoginButtonOnAction(ActionEvent event) {
        Controller.startEmployeeInterface(event, "/FurnitureStore/employee/EmployeeView.fxml");
    }
}
