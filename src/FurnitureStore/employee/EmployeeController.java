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

public class EmployeeController implements Initializable {

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
    private ContextMenu contextMenu;

    private MenuItem view, edit, delete;

    @FXML
    public void FilterProductsOnAction(ActionEvent event) {

    }

    @FXML
    public void SearchByIDOnAction(ActionEvent event) {

    }

    @FXML
    public void EditButtonOnAction(ActionEvent event) {

    }

    @FXML
    public void AddButtonOnAction(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Add a product");
        add.setWidth(600);
        add.setHeight(450);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/employee/AddProductView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        view = new MenuItem("View");
        edit = new MenuItem("Edit");
        delete = new MenuItem("Delete");
        contextMenu.getItems().addAll(view,edit,delete);
    }
}
