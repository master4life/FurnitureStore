package FurnitureStore;

import javafx.event.ActionEvent;

public class SignupController {
    public void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

    public void backButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "main.fxml");
    }
}
