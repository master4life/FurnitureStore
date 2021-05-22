package FurnitureStore.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditProductController {

    @FXML
    private RadioButton rbtnFurniture1;

    @FXML
    private RadioButton rbtnAccessoire2;

    @FXML
    private ChoiceBox<?> Type2;

    @FXML
    private ChoiceBox<?> Material2;

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

}
