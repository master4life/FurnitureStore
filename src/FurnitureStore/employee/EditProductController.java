package FurnitureStore.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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


    @FXML
    void editProduct(ActionEvent event) {

    }

    // TODO: Error Handling
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

        // TODO: Get product size with regex
        String productSizeFull = TempProduct.getProductSize();
        String height;

        // TODO: Handle choicebox selection
        this.Type2.getItems().clear();
        this.Type2.getItems().addAll("accessoire", "table", "closet", "sofa", "bed", "chair", "shelf", "refrigerator");
        this.Material2.getItems().addAll("wood", "metal", "plastic", "upholstered");
    }
}
