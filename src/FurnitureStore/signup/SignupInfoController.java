package FurnitureStore.signup;

import FurnitureStore.CurrentUser;
import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class SignupInfoController
{

    @FXML
    private TextField firstnameTxt;

    @FXML
    private TextField lastnameTxt;

    @FXML
    private TextField streetTxt;

    @FXML
    private TextField houseNumberTxt;

    @FXML
    private TextField zipCodeTxt;

    @FXML
    private TextField cityTxt;

    @FXML
    private TextField stateTxt;

    @FXML
    private TextField landTxt;

    @FXML
    private Label errorLabel;

    public void FinalRegisterButtonOnAction(ActionEvent event) throws SQLException
    {
        //Get the values
        if (firstnameTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a firstname");
            return;
        }
        String fname = firstnameTxt.getText();
        if (lastnameTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a lastname");
            return;
        }
        String lname = lastnameTxt.getText();
        if (cityTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a city");
            return;
        }
        String place = cityTxt.getText();
        if (stateTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a state");
            return;
        }
        String state = stateTxt.getText();
        if (landTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a country");
            return;
        }
        String country = landTxt.getText();


        if (zipCodeTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a zip");

            return;
        }
        if (!isInteger(zipCodeTxt.getText()))
        {
            errorLabel.setText("Only digits are allowed for ZIP");
            return;
        }

        int plz = Integer.parseInt(zipCodeTxt.getText());
        String street = streetTxt.getText();
        if (zipCodeTxt.getLength() == 0)
        {
            errorLabel.setText("Please provide a house number");

            return;
        }
        if (!isInteger(houseNumberTxt.getText()))
        {
            errorLabel.setText("Only digits are allowed for house number");
            return;
        }
        int house = Integer.parseInt(houseNumberTxt.getText());

        if (fname.length() == 0 || lname.length() == 0)
        {
            errorLabel.setText("First name and last name are mandatory");

            return;
        }

        //Insert the customer
        DBController ctr = new DBController();
        Connection con = ctr.getConnection();
        PreparedStatement ps = null;

        String sql = "insert into Customer(fname, lname, place, plz, street, country, state, houseNo) VALUES(?,?,?,?,?,?,?,?) ";
        ps = con.prepareStatement(sql);
        ps.setString(1, fname);
        ps.setString(2, lname);
        ps.setString(3, place);
        ps.setInt(4, plz);
        ps.setString(5, street);
        ps.setString(6, country);
        ps.setString(7, state);
        ps.setInt(8, house);
        ps.execute();

        //Get the auto ID
        sql = "select max(customerID) from customer ";
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int id = rs.getInt(1);

        //Insert the userData
        sql = "insert into CustomerAccount(custID, email, username, password) VALUES(?,?,?,?) ";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, TempStorrage.getEmail());
        ps.setString(3, TempStorrage.getUser());
        ps.setString(4, TempStorrage.getPass());
        ps.execute();

        ps.close();
        rs.close();
        con.close();

        CurrentUser.setUsername(TempStorrage.getUser());
        CurrentUser.setType(1);
        Controller.changeScene(event, "/FurnitureStore/customer/CustomerView.fxml");

    }

    public void BackButtonAction(ActionEvent event)
    {
        Controller.changeScene(event, "/FurnitureStore/signup/signup.fxml");
    }

    public static boolean isInteger(String text)
    {
        try
        {
            Integer.parseInt(text);
        } catch (NumberFormatException e)
        {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
