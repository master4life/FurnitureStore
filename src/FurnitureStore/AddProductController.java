package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProductController {

    @FXML
    private RadioButton rbtnFurniture;

    @FXML
    private RadioButton rbtnAccessoire;

    @FXML
    private ChoiceBox<?> type;

    @FXML
    private ChoiceBox<?> material;

    @FXML
    private TextField txtHeight;

    @FXML
    private TextField txtWidht;

    @FXML
    private TextField txtLength;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextArea Description;

    @FXML
    private Button btnAdd;

    @FXML
    void addProduct(ActionEvent event) {

    }

}
