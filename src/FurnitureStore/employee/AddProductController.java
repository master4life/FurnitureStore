package FurnitureStore.employee;

import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TextArea Description1;

    @FXML
    private Button btnAdd;

    // TODO: Error Handling
    @FXML
    void addProduct(ActionEvent event) {

        String productCategory = type.getValue();

        String productMaterial = material1.getValue();

        double productPrice = Double.parseDouble(txtPrice1.getText().trim());

        String productSize = txtHeight1.getText().trim() + "x" + txtLength1.getText().trim() + "x" + txtWidth1.getText().trim();

        String productDescription = Description1.getText();

        int productAmount = Integer.parseInt(txtAmount1.getText().trim());

        //ProductModel productToBeAdded = new ProductModel(productCategory, productMaterial, productPrice, productSize, productDescription, productAmount);
        try {
            DBController dbController = new DBController();
            Connection connection = dbController.getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = connection.createStatement().executeQuery("select * from Categorie" +
                    " where name = \""+productCategory+"\"");
            int cat = rs.getInt("categorieID");
            String insertQuery = "insert into Product (categorie, material, price, size, describtion, amountAvailable)  values ("
                                    + cat+",'"+productMaterial+"',"+productPrice+",'"
                                    +productSize+"','"+productDescription+"',"+productAmount+")";
            statement.executeUpdate(insertQuery);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.type.getItems().clear();
        this.type.getItems().addAll("accessoire", "table", "closet", "sofa", "bed", "chair", "shelf", "refrigerator");
        this.material1.getItems().addAll("wood", "metal", "plastic", "upholstered");

    }
}
