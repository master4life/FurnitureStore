package FurnitureStore.customer;

import FurnitureStore.CurrentUser;
import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import FurnitureStore.models.ReservationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerReservationController implements Initializable {


    @FXML
    private TableView<ReservationModel> resTable;

    @FXML
    private TableColumn<ReservationModel, Integer> idCol;

    @FXML
    private TableColumn<ReservationModel, String> dateCol;

    @FXML
    private TableColumn<ReservationModel, Double> totalPriceCol;

    ObservableList<ReservationModel> reservations = FXCollections.observableArrayList();

    @FXML
    void viewOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            ResultSet rs;
            PreparedStatement ps = null;
            String sql = "Select * from Reservation where custID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, CurrentUser.getId());
            rs = ps.executeQuery();

            while (rs.next()){
                reservations.add(new ReservationModel(rs.getInt("reservationID"),
                        rs.getString("date"), rs.getDouble("totalprice")));
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        resTable.setItems(reservations);
    }
}