package FurnitureStore.main;

import FurnitureStore.base.Controller;
import FurnitureStore.employee.Employee;
import FurnitureStore.employee.EmployeeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class MainController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Button quitButton;

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/login/login.fxml");
        try {
            EmployeeModel employeeModel= new EmployeeModel();
            // Following 2 lines only for testing purpose  ID MUST BE CHANGED FOR EACH TEST BECAUSE PRIMARY KEY
            Employee testEmployee = new Employee(3,"marin", "hincu", 22000, "chs", 344543, "chsss", 1, 1);
            employeeModel.createEmployee(testEmployee);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println("Id already exists!");
        }
    }

    @FXML
    void signupButtonOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/signup/signup.fxml");
    }

    @FXML
    void quitButtonOnAction(ActionEvent event) {
        Controller.quitApplicationAlert(event);
    }

}
