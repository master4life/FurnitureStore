package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class LoginController {


    public void backButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "main.fxml");
    }

    public void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

    public void loginButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "EmployeeView.fxml");
    }
}
