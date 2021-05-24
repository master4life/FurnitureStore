package FurnitureStore.employee;

import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable{

    @FXML
    private TableView<ProductModel> table;

    @FXML
    private TableColumn<ProductModel, Integer> colID;

    @FXML
    private TableColumn<ProductModel, String> TypeCol;

    @FXML
    private TableColumn<ProductModel, String> materialCol;

    @FXML
    private TableColumn<ProductModel, Double> sizeCol;

    @FXML
    private TableColumn<ProductModel, String> descCol;

    @FXML
    private TableColumn<ProductModel, Double> priceCol;

    @FXML
    private TableColumn<ProductModel, Integer> amountCol;

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

    ObservableList<ProductModel> olist = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Create DB Connection
        try {
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from Product");

            //Read rows
            while(rs.next()){
                olist.add(new ProductModel(rs.getInt("productID"),
                        rs.getInt("categorie"),
                        rs.getString("material"),
                        rs.getDouble("price"),
                        rs.getString("size"),
                        rs.getString("describtion"),
                        rs.getInt("amountAvailable")));
            }
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Set table columns
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        materialCol.setCellValueFactory(new PropertyValueFactory<>("material"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        table.setItems(olist);
    }
}
