package FurnitureStore.employee;

import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddProductController {

    @FXML
    private RadioButton rbtnFurniture1;

    @FXML
    private RadioButton rbtnAccessoire1;

    @FXML
    private ChoiceBox<?> Type1;

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
    private TextArea Description1;

    @FXML
    private Button btnAdd;

    // TODO: Error Handling
    @FXML
    void addProduct(ActionEvent event) {
        int productCategory;
        if(rbtnAccessoire1.isSelected()){
            productCategory = 1;
        }else {
            productCategory = 2;
        }

        String productMaterial = (String) material1.getSelectionModel().getSelectedItem();

        double productPrice = Double.parseDouble(txtPrice1.getText().trim());

        String productSize = txtHeight1.getText().trim() + "x" + txtLength1.getText().trim() + "x" + txtWidth1.getText().trim();

        String productDescription = Description1.getText();

        int productAmount = Integer.parseInt(txtAmount1.getText().trim());

        ProductModel productToBeAdded = new ProductModel(productCategory, productMaterial, productPrice, productSize, productDescription, productAmount);
        try {
            DBController dbController = new DBController();
            Connection connection = dbController.getConnection();
            Statement statement = connection.createStatement();

            String insertQuery = "insert into Product (categorie, material, price, size, describtion, amountAvailable)  values ("
                                    + productToBeAdded.getCategorie()+",'"+productToBeAdded.getMaterial()+"',"+productToBeAdded.getPrice()+",'"
                                    +productToBeAdded.getSize()+"','"+productToBeAdded.getDescription()+"',"+productToBeAdded.getAmount()+")";
            statement.executeUpdate(insertQuery);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
