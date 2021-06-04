package FurnitureStore.utils;

import javafx.scene.control.Alert;

public class Alerts {

    public static void createWarningAlert(String headerText, String titleText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(headerText);
        alert.setTitle(titleText);
        alert.setContentText(contentText);
        alert.show();
    }

    public static void createErrorAlert(String headerText, String titleText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(headerText);
        alert.setTitle(titleText);
        alert.setContentText(contentText);
        alert.show();
    }

    public static void createConfirmationAlert(String headerText, String titleText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(headerText);
        alert.setTitle(titleText);
        alert.setContentText(contentText);
        alert.show();
    }
}
