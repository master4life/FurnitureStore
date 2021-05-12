package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.sql.SQLException;
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
        try {
            EmployeeModel employeeModel= new EmployeeModel();
            // Following 2 lines only for testing purpose  ID MUST BE CHANGED FOR EACH TEST BECAUSE PRIMARY KEY
            Employee testEmployee = new Employee(3,"marin", "hincu", 22000, "chs", 344543, "chsss", 1, 1);
            employeeModel.createEmployee(testEmployee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
