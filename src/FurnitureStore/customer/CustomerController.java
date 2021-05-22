package FurnitureStore.customer;

import FurnitureStore.base.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
    private Button FilterButton;

    @FXML
    private ContextMenu ProductTable;

    @FXML
    public void FilterProductsOnAction(ActionEvent event) {

    }

    @FXML
    public void SearchByIDOnAction(ActionEvent event) {

    }

    @FXML
    public void BuyButtonOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void ContactButtonOnAction(ActionEvent event) throws IOException {

    }
}
