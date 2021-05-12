package FurnitureStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Add a product");
        add.setWidth(600);
        add.setHeight(450);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("AddProductView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }
}
