package FurnitureStore.employee;

import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import FurnitureStore.utils.Alerts;
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
import java.sql.*;
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
    private TableColumn<ProductModel, String> nameCol;

    @FXML
    private TableColumn<ProductModel, Double> priceCol;

    @FXML
    private TableColumn<ProductModel, Integer> amountCol;

    @FXML
    private TextField ProdID;

    @FXML
    private Button SearchButton;

    @FXML
    private ChoiceBox<String> ChoiceType;

    @FXML
    private ChoiceBox<String> ChoiceMaterial;

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
        table.getItems().clear();

        boolean categoryNotNull;
        boolean materialNotNull;

        double minPrice = 0;
        double maxPrice = 0;

            try {
                try {
                    minPrice = Double.parseDouble(txtMinPrice.getText());
                    maxPrice = Double.parseDouble(txtMaxPrice.getText());
                } catch (Exception e) {
                    System.out.println("No prices");
                }

                int category = 0;
                String material = "";

                try {
                    category = ProductModel.categorieInt(ChoiceType.getValue());
                    categoryNotNull = true;
                } catch (Exception e) {
                    categoryNotNull = false;
                }


                try {
                    material = ChoiceMaterial.getValue();
                    materialNotNull = true;
                } catch (Exception e) {
                    materialNotNull = false;
                }

                String selectQuery = "";
                if (maxPrice != 0 && minPrice != 0) {
                    selectQuery = "select * from Product where price >= " + minPrice + " and price <= " + maxPrice;
                } else {
                    selectQuery = "select * from Product where productID > -1";
                }

                if (categoryNotNull && category != 0) {
                    selectQuery = selectQuery + " and categorie = " + category;
                }
                if (material != null && materialNotNull && !material.equals("")) {
                    selectQuery = selectQuery + " and material = '" + material + "'";
                }
                executeSelectQuery(selectQuery);

                setTableColumns();
            } catch (Exception e) {
                Alerts.createWarningAlert("Filter warning","Please select some values for the filter.","If you already entered some values, please make sure to only include numbers in the price fields.");
                // Initialize table again with all tuples
                String selectQuery = "select * from Product";
                executeSelectQuery(selectQuery);
                setTableColumns();
            }

    }


    @FXML
    public void SearchByIDOnAction(ActionEvent event) {
        table.getItems().clear();
        String prodId = ProdID.getText();
        String query = "select * from Product where productId = " +prodId;
        executeSelectQuery(query);
        setTableColumns();
        emptyAllFields();
    }

    @FXML
    public void DeleteButtonOnAction(ActionEvent event){
        ProductModel selected = table.getSelectionModel().getSelectedItem();
        System.out.println(selected.getId());
        //Prepare statement
        try {
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            PreparedStatement s = con.prepareStatement("delete from Product where productID = ?");
            s.setInt(1, selected.getId());
            s.execute();

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        table.getItems().removeAll(selected);
    }

    @FXML
    public void EditButtonOnAction(ActionEvent event) throws IOException {
        ProductModel selected = table.getSelectionModel().getSelectedItem();
        if(selected != null){
            initializeProductParameter();
            Stage add = new Stage();
            add.setTitle("Edit product");
            add.setWidth(455);
            add.setHeight(620);
            add.setResizable(false);
            Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
            add.initOwner(owner);
            add.initModality(Modality.WINDOW_MODAL);
            Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/employee/EditProductView.fxml")));
            Scene addScene = new Scene(parent);
            add.setScene(addScene);
            add.show();
        } else {
            Alerts.createErrorAlert("Product could not be edited.","Edit Product","Please select the product you want to edit.");
        }

    }

    @FXML
    public void AddButtonOnAction(ActionEvent event) throws IOException {
        emptyAllFields();
        Stage add = new Stage();
        add.setTitle("Add a product");
        add.setWidth(455);
        add.setHeight(620);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/employee/AddProductView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }

    @FXML
    public void refreshOnAction(ActionEvent event) {
        table.getItems().clear();
        String selectQuery = "select * from Product";
        executeSelectQuery(selectQuery);
        setTableColumns();
        emptyAllFields();
    }

    @FXML
    public void LogoutButtonOnAction(ActionEvent event){
        Controller.changeScene(event, "/FurnitureStore/login/login.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String selectQuery = "select * from Product";
        executeSelectQuery(selectQuery);
        setTableColumns();
        initializeAllChoiceBoxes();
    }

    private void executeSelectQuery(String query) {
        try {
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            ResultSet rs = con.createStatement().executeQuery(query);

            //Read rows
            while(rs.next()){
                olist.add(new ProductModel(rs.getInt("productID"),
                        rs.getInt("categorie"),
                        rs.getString("material"),
                        rs.getDouble("price"),
                        rs.getString("size"),
                        rs.getString("name"),
                        rs.getInt("amountAvailable")));
            }
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setTableColumns() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("strCategorie"));
        materialCol.setCellValueFactory(new PropertyValueFactory<>("material"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        table.setItems(olist);
    }

    private void initializeProductParameter() {
        ProductModel selectedProduct = table.getSelectionModel().getSelectedItem();
        TempProduct.setProductId(selectedProduct.getId());
        TempProduct.setProductPrice(selectedProduct.getPrice());
        TempProduct.setProductCategory(selectedProduct.getCategorie());
        TempProduct.setProductSize(selectedProduct.getSize());
        TempProduct.setProductName(selectedProduct.getName());
        TempProduct.setProductMaterial(selectedProduct.getMaterial());
        TempProduct.setAvailableProductAmount(selectedProduct.getAmount());
    }


    private void emptyAllFields() {
        txtMinPrice.setText("");
        txtMaxPrice.setText("");
        ProdID.setText("");
        ChoiceType.setValue("");
        ChoiceMaterial.setValue("");
    }

    private void initializeAllChoiceBoxes() {
        this.ChoiceType.getItems().clear();
        this.ChoiceType.getItems().addAll("accessoire", "table", "closet", "sofa", "bed", "chair", "shelf", "refrigerator");
        this.ChoiceMaterial.getItems().addAll("wood", "metal", "plastic", "upholstered");
    }


}
