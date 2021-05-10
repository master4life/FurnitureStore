package FurnitureStore;

import javafx.event.ActionEvent;

public class LoginController {

    public void backButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "main.fxml");
    }

    public void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }
}
