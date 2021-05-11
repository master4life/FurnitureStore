package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EmployeeController {

    @FXML
    private TextField txtProdID;

    @FXML
    private Button btnSearch;

    @FXML
    private ChoiceBox<?> choiseType;

    @FXML
    private ChoiceBox<?> choiseMaterial;

    @FXML
    private TextField txtMinPrice;

    @FXML
    private TextField txtMaxPrice;

    @FXML
    private Button btnFilter;

    @FXML
    void filterProducts(ActionEvent event) {

    }

    @FXML
    void searchByID(ActionEvent event) {

    }

}
