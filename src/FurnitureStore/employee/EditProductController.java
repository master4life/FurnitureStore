package FurnitureStore.employee;

import FurnitureStore.base.DBController;
import FurnitureStore.utils.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditProductController implements Initializable {

    @FXML
    private RadioButton rbtnFurniture1;

    @FXML
    private RadioButton rbtnAccessoire2;

    @FXML
    private ChoiceBox<String> Type2;

    @FXML
    private ChoiceBox<String> Material2;

    @FXML
    private TextField txtHeight2;

    @FXML
    private TextField txtWidth2;

    @FXML
    private TextField txtLength2;

    @FXML
    private TextField txtPrice2;

    @FXML
    private TextField txtAmount2;

    @FXML
    private TextArea Description2;

    @FXML
    private Button btnEdit;


    // TODO: Refactoring
    @FXML
    void editProduct(ActionEvent event) {

        boolean parsingSuccessfull;

        String productCategory = null;
        String productMaterial = null;
        double productPrice = 0;
        String productSize = null;
        String productDescription = null;
        int productAmount = 0;

        try {
            // Parsing input values
            productCategory = Type2.getValue();

            productMaterial = Material2.getValue();

            productPrice = Double.parseDouble(txtPrice2.getText().trim());

            productSize = txtHeight2.getText().trim() + "x" + txtWidth2.getText().trim() + "x" + txtLength2.getText().trim();

            productDescription = Description2.getText();

            productAmount = Integer.parseInt(txtAmount2.getText().trim());

            parsingSuccessfull = true;
        } catch (Exception e) {
            Alerts.createErrorAlert("Edit Product","Product could not be edited.","The Product could not be edited. Please verify the entered data.");
            parsingSuccessfull = false;
        }

        if (parsingSuccessfull){
            // Create update query
            DBController dbController = null;
            try {
                dbController = new DBController();
                Connection connection = dbController.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "update Product set material = ?, price = ?, size = ?, describtion = ?, amountAvailable = ? where productID = ?"
                );
                preparedStatement.setString(1, productMaterial);
                preparedStatement.setDouble(2, productPrice);
                preparedStatement.setString(3, productSize);
                preparedStatement.setString(4, productDescription);
                preparedStatement.setInt(5, productAmount);
                preparedStatement.setInt(6, TempProduct.getProductId());

                preparedStatement.executeUpdate();
                preparedStatement.close();

                Alerts.createConfirmationAlert("Edit Product","Product edited.","The Product has been edited successfully.");

                exitWindow(event);

            } catch (SQLException throwables) {
                Alerts.createErrorAlert("Edit Product","Product could not be edited.","The Product could not be edited because the database is locked. Please try again later.");
                throwables.printStackTrace();
            }
        }



    }

    // TODO: Error Handling and refactoring
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (TempProduct.getProductCategory() == 1) {
            rbtnFurniture1.setSelected(true);
        }
        else {
            rbtnAccessoire2.setSelected(true);
        }

        txtAmount2.setText(String.valueOf(TempProduct.getAvailableProductAmount()));

        txtPrice2.setText(String.valueOf(TempProduct.getProductPrice()));

        Description2.setText(TempProduct.getProductDescription());


        // Splitting the size string by using a regex
        String productSizeFull = TempProduct.getProductSize();
        String[] productSizeSplit = productSizeFull.split("x", 3);
        String height = productSizeSplit[0];
        String  width= productSizeSplit[1];
        String length = productSizeSplit[2];

        txtHeight2.setText(height);
        txtWidth2.setText(width);
        txtLength2.setText(length);


        this.Type2.getItems().clear();
        this.Type2.getItems().addAll("accessoire", "table", "closet", "sofa", "bed", "chair", "shelf", "refrigerator");
        this.Material2.getItems().addAll("wood", "metal", "plastic", "upholstered");

        this.Type2.setValue(this.Type2.getItems().get(TempProduct.getProductCategory()));

        this.Material2.setValue(TempProduct.getProductMaterial());

    }

    private void exitWindow(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
