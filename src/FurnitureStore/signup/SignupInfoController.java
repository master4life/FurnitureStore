package FurnitureStore.signup;

import FurnitureStore.base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SignupInfoController {

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField street;
    @FXML
    private TextField houseNumber;
    @FXML
    private TextField zipCode;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private TextField land;

    public void FinalRegisterButtonOnAction(ActionEvent event) {

    }
    public void BackButtonAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/signup/signup.fxml");
    }
}
