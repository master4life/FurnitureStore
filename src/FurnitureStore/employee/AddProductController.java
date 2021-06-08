package FurnitureStore.employee;

import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import FurnitureStore.utils.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {


    @FXML
    private ChoiceBox<String> type;

    @FXML
    private ChoiceBox<String> material1;

    @FXML
    private TextField txtHeight1;

    @FXML
    private TextField txtWidth1;

    @FXML
    private TextField txtLength1;

    @FXML
    private TextField txtPrice1;

    @FXML
    private TextField txtAmount1;

    @FXML
    private TextField Name1;

    @FXML
    private Button btnAdd;

    // TODO: Refactoring
    @FXML
    void addProduct(ActionEvent event) {

        boolean parsingSuccessfull;

        String productCategory = null;
        String productMaterial = null;
        double productPrice = 0;
        String productSize = null;
        String productName = null;
        int productAmount = 0;

        try {
            // Parsing input values
             productCategory = type.getValue();

             productMaterial = material1.getValue();

             productPrice = Double.parseDouble(txtPrice1.getText().trim());

             productSize = txtHeight1.getText().trim() + "x" + txtLength1.getText().trim() + "x" + txtWidth1.getText().trim();

             productName = Name1.getText();

             productAmount = Integer.parseInt(txtAmount1.getText().trim());

             parsingSuccessfull = true;
        } catch (Exception e) {
            Alerts.createErrorAlert("Add Product","Product could not be added.","The Product(s) could not be added. Please verify the entered data.");
            parsingSuccessfull = false;
        }

        //ProductModel productToBeAdded = new ProductModel(productCategory, productMaterial, productPrice, productSize, productDescription, productAmount);
        if (parsingSuccessfull) {
            try {
                // Creating Query
                DBController dbController = new DBController();
                Connection connection = dbController.getConnection();
                Statement statement = connection.createStatement();

                ResultSet rs = connection.createStatement().executeQuery("select * from Categorie" +
                        " where name = \""+productCategory+"\"");
                int cat = rs.getInt("categorieID");
                String insertQuery = "insert into Product (categorie, material, price, size, name, amountAvailable)  values ("
                        + cat+",'"+productMaterial+"',"+productPrice+",'"
                        +productSize+"','"+productName+"',"+productAmount+")";
                statement.executeUpdate(insertQuery);
                connection.close();

                Alerts.createConfirmationAlert("Add Product","Product added.","The Product(s) were added successfully.");

                final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

            } catch (SQLException throwable) {
                //throwable.printStackTrace();
                Alerts.createErrorAlert("Add Product","Product could not be added.","The Product(s) could not be added because the database is locked. Please try again later.");
            }
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.type.getItems().clear();
        this.type.getItems().addAll("accessoire", "table", "closet", "sofa", "bed", "chair", "shelf", "refrigerator");
        this.material1.getItems().addAll("wood", "metal", "plastic", "upholstered");

    }
}
