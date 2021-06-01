package FurnitureStore.customer;

import FurnitureStore.CurrentUser;
import FurnitureStore.base.DBController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartController implements Initializable {


    @FXML
    private TableView<CartItem> cartTable;

    @FXML
    private TableColumn<CartItem, Integer> idCol;

    @FXML
    private TableColumn<Cart, String> typeCol;

    @FXML
    private TableColumn<Cart, Integer> amountCol;

    @FXML
    private TableColumn<Cart, Double> priceCol;

    ObservableList<CartItem> cart = FXCollections.observableArrayList();

    @FXML
    void RemoveOnAction(ActionEvent event) {
        CartItem selected = cartTable.getSelectionModel().getSelectedItem();
        cartTable.getItems().removeAll(selected);
    }

    @FXML
    void ReservationOnAction(ActionEvent event) throws SQLException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Confirm Reservation");
        dialog.getDialogPane().setContentText("Date: ");
        Optional<String> result = dialog.showAndWait();
        TextField input = dialog.getEditor();

        if(input.getText() == null || input.getText().length() == 0){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setContentText("Input was not correct");
            err.show();
        }else{
            //Create connection
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            PreparedStatement ps = null;

            //Total Price
            double total = 0;
            for(CartItem c : cart){
                total += c.getTotalPrice();
            }

            //Create the reservation
            String sql = "insert into Reservation(custID, date, totalprice) VALUES(?,?, ?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, CurrentUser.getId());
            ps.setString(2, input.getText());
            ps.setDouble(3, total);
            ps.execute();

            //Get the auto ID
            sql = "select max(reservationID) from Reservation ";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int id = rs.getInt(1);

            //Add reservedItems

            for(CartItem c : cart){
                String insert = "insert into ReservedProducts(resID, prodID, amount) VALUES(?,?,?) ";
                ps = con.prepareStatement(insert);
                ps.setInt(1, id);
                ps.setInt(2, c.getId().intValue());
                ps.setInt(3, c.getAmount().intValue());
                ps.execute();
            }

            ps.close();
            con.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cart = Cart.getCart();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        cartTable.setItems(cart);
    }
}
