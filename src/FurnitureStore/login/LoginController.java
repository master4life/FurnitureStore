package FurnitureStore.login;

import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField passTxt;

    @FXML
    private Label loginLabel;

    public void RegisterLabelOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/signup/signup.fxml");
    }

    public void LoginButtonOnAction(ActionEvent event) throws SQLException {

        String user = usernameTxt.getText();
        String pass = passTxt.getText();

        //Connecting to DB
        DBController connection = new DBController();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Create query
        String sql = "select password from EmployeeAccount where username = ?";
        ps = connection.getConnection().prepareStatement(sql);
        ps.setString(1, user);
        rs = ps.executeQuery();

        //Checking username/password
        if(!rs.next()){
            loginLabel.setText("Username doesn't exist");
            rs.close();
            ps.close();
            connection.getConnection().close();
            return;
        }
        String realPass = rs.getString(1);

        if(realPass.equals(pass)){
            Controller.changeScene(event, "/FurnitureStore/employee/EmployeeView.fxml");
        }else{
            loginLabel.setText("Password not correct");
        }
        rs.close();
        ps.close();
        connection.getConnection().close();
    }
}
