package FurnitureStore.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProductController {

    @FXML
    private RadioButton rbtnFurniture1;

    @FXML
    private RadioButton rbtnAccessoire1;

    @FXML
    private ChoiceBox<?> Type1;

    @FXML
    private ChoiceBox<?> Material1;

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

    @FXML
    void addProduct(ActionEvent event) {

    }
}
