package FurnitureStore.customer;

import FurnitureStore.CurrentUser;
import FurnitureStore.base.Controller;
import FurnitureStore.base.DBController;
import FurnitureStore.models.ProductModel;
import FurnitureStore.models.ReservationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
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
    void viewOnAction(ActionEvent event) throws SQLException {
        ReservationModel r = resTable.getSelectionModel().getSelectedItem();
        if(r == null)
            return;
        Stage stage = new Stage();
        stage.setTitle("Reservation Overview");
        stage.setWidth(200);
        stage.setHeight(400);
        stage.setResizable(false);
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.initOwner(owner);
        stage.initModality(Modality.WINDOW_MODAL);
        BorderPane parent = new BorderPane();
        Scene scene = new Scene(parent);
        TextArea textArea = new TextArea();
        int id = r.getId().intValue();
        textArea.setText(CustomerReservationController.printReservation(id));
        textArea.setEditable(false);
        parent.setCenter(textArea);
        stage.setScene(scene);
        stage.show();
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

    public static String printReservation(int id) throws SQLException {
        //Get Information from DB
        DBController ctr = new DBController();
        Connection con = ctr.getConnection();
        ResultSet rs;
        PreparedStatement ps = null;
        String sql = "select p.productID, p.categorie, p.price, r.amount " +
                "from Product p JOIN ReservedProducts r ON (p.productID = r.prodID) " +
                "WHERE r.resID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        //print result
        String result = "ID\tType\t\tAmount\tPrice\n";
        double total = 0;
        while (rs.next()){
            int pID = rs.getInt("productID");
            String categorie = ProductModel.categorieStr(rs.getInt("categorie"));
            double price = rs.getDouble("price");
            int amount = rs.getInt("amount");
            price = Math.round((price*amount) * 100.0) /100.0;
            total += price;
            result += pID+"\t"+categorie+"\t"+amount
                    +"\t\t"+price+"\n";
        }
        result += "-----------------------------------\n";
        result += "total:\t\t\t" + Math.round(total * 100.0) /100.0 +" Euro";

        ps.close();
        rs.close();
        con.close();

        return result;
    }
}