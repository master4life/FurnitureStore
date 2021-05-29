package FurnitureStore.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class CustomerController{

    @FXML
    private TextField ProdID;

    @FXML
    private Button SearchButton;

    @FXML
    private ChoiceBox<?> ChoiceType;

    @FXML
    private ChoiceBox<?> ChoiceMaterial;

    @FXML
    private TextField txtMinPrice;

    @FXML
    private TextField txtMaxPrice;

    @FXML
    private ContextMenu CustomerProductTable;

    @FXML
    public void FilterProductsOnAction(ActionEvent event) {

    }

    @FXML
    public void SearchByIDOnAction(ActionEvent event) {

    }

    @FXML
    public void OrderButtonOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void ContactButtonOnAction(ActionEvent event) throws IOException {

    }
}
