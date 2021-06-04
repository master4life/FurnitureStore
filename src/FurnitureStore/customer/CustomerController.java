package FurnitureStore.customer;

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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private ChoiceBox<?> ChoiceType;

    @FXML
    private ChoiceBox<?> ChoiceMaterial;

    @FXML
    private TextField txtMinPrice;

    @FXML
    private TextField txtMaxPrice;

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
    private TableColumn<ProductModel, Integer> inStock;

    ObservableList<ProductModel> olist = FXCollections.observableArrayList();

    @FXML
    private ContextMenu customerProductTable;

    @FXML
    void CartButtonOnAction(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Cart");
        add.setWidth(600);
        add.setHeight(400);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/customer/CartView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }

    @FXML
    void FilterProductsOnAction(ActionEvent event) {

    }

    @FXML
    void MyReservationsButtonOnAction(ActionEvent event) throws IOException {
        Stage add = new Stage();
        add.setTitle("Reservations");
        add.setWidth(600);
        add.setHeight(400);
        add.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        add.initOwner(owner);
        add.initModality(Modality.WINDOW_MODAL);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("/FurnitureStore/customer/CustomerReservationsView.fxml")));
        Scene addScene = new Scene(parent);
        add.setScene(addScene);
        add.show();
    }

    @FXML
    void addToCartAction(ActionEvent event) {
        ProductModel selected = table.getSelectionModel().getSelectedItem();

        if(selected == null){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setContentText("No product selected");
            err.show();
        }else{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Confirmation");
            dialog.getDialogPane().setContentText("Amount: ");
            Optional<String> result = dialog.showAndWait();
            TextField input = dialog.getEditor();

            try{
                int amount = Integer.parseInt(input.getText());
                if(amount > selected.getAmount()) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Error");
                    err.setContentText("There are not enough on stock");
                    err.show();
                }else{
                    Cart.add(new CartItem(selected.getId(), ProductModel.categorieStr(selected.getCategorie().intValue()), amount,
                            selected.getPrice()*amount));
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("Error");
                err.setContentText("Input was not correct");
                err.show();
            }


            }


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
        inStock.setCellValueFactory(new PropertyValueFactory<>("amount"));

        table.setItems(olist);

    }

}