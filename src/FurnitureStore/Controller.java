package FurnitureStore;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Controller {

    public static void changeScene(ActionEvent event, String fxmlResourceName) {
        try {
            Parent loginParent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(fxmlResourceName)));
            Scene loginScene = new Scene(loginParent);
            Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginStage.setScene(loginScene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startEmployeeInterface(ActionEvent event, String fxmlResourceName){
        try {
            Parent empParent = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource(fxmlResourceName)));
            Scene empScene = new Scene(empParent);
            Stage empStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            empStage.setScene(empScene);
            empStage.setTitle("Product overview");
            empStage.setMaximized(true);
            empStage.setResizable(true);
            empStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quitApplicationAlert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Quit Application");
        alert.setContentText("Are you sure you want to quit the application?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }


}
