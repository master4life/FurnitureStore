package FurnitureStore.login;

import FurnitureStore.CurrentUser;
import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private RadioButton radioCustomer;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton radioEmployee;

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

        String nextScene;
        String sql;
        String title;
        int type;

        if(radioCustomer.isSelected()){
            sql = "select password from CustomerAccount where username = ?";
            nextScene = "/FurnitureStore/customer/CustomerView.fxml";
            title = "Furniture Shop";
            type = 1;
        }else{
            sql = "select password from EmployeeAccount where username = ?";
            nextScene = "/FurnitureStore/employee/EmployeeView.fxml";
            title = "Products overview";
            type = 2;
        }

        //Connecting to DB
        DBController connection = new DBController();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Create querry
        ps = connection.getConnection().prepareStatement(sql);
        ps.setString(1, user);
       // ps.setString(2, user);
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
            CurrentUser.setUsername(user);
            CurrentUser.setType(type);
            Controller.startUserInterface(event, nextScene, title);
        }else{
            loginLabel.setText("Password not correct");
        }
        rs.close();
        ps.close();
        connection.getConnection().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioCustomer.setSelected(true);
    }
}
