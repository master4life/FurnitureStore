package FurnitureStore.signup;

import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupController {

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField passtxt;
    @FXML
    private Label registerLabel;
    @FXML
    private Label errorLabel;
    
    public void SignInLabelOnAction(ActionEvent event) {
        Controller.changeScene(event, "/FurnitureStore/login/login.fxml");
    }

    public void nextButtonOnAction(ActionEvent event) {

        String userName = username.getText();
        String passwort = passtxt.getText();
        String mail = email.getText();

        //Check if username is available
        boolean free = true;
        try {
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select username from CustomerAccount");

            //Read rows
            while(rs.next()){
                String n = rs.getString("username");
                if(n.equals(userName)){
                    free = false;
                    break;
                }
            }
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        if(free == false) {
            errorLabel.setText("Username not free");
            return;
        }
        if(userName.length() == 0){
            errorLabel.setText("No username provided");
            return;
        }
        if(passwort.length() == 0){
            errorLabel.setText("No password provided");
            return;
        }
        if(mail.length() == 0){
            errorLabel.setText("No email provided");
            return;
        }

        TempStorrage.setUser(userName);
        TempStorrage.setPass(passwort);
        TempStorrage.setEmail(mail);
        Controller.changeScene(event, "/FurnitureStore/signup/signupInfo.fxml");
    }
}
