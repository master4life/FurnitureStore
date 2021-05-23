package FurnitureStore.employee;

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

public class EmployeeController{

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
    public void DeleteButtonOnAction(ActionEvent event){

    }

    @FXML
    public void EditButtonOnAction(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Edit product");
        add.setWidth(650);
        add.setHeight(700);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/employee/EditProductView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }

    @FXML
    public void AddButtonOnAction(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Add a product");
        add.setWidth(650);
        add.setHeight(700);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/employee/AddProductView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }
}
