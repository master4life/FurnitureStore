package FurnitureStore;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Controller {

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        try {
            Parent loginParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Scene loginScene = new Scene(loginParent);
            Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginStage.setScene(loginScene);
            loginStage.show();
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @FXML
    void quitButtonOnAction(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
