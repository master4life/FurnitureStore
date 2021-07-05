package FurnitureStore.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
Team members:
Banin Abassi, 1210611, abassi@stud.fra-uas.de
Alexander Atanassov, 1221846, alexander.atanassov@stud.fra-uas.de
Kiyan Bolat, 1218309, kbolat@stud.fra-uas.de
Marin-Petru Hincu, 1268171, hincu@stud.fra-uas.de
Ahmed Noorzi, 1312933, ahmed.noorzi@stud.fra-uas.de
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/FurnitureStore/login/login.fxml"));
        primaryStage.setTitle("FourFabrics");
        primaryStage.setScene(new Scene(root, 927, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        //System.out.println(System.getProperties());

        launch(args);
    }
}
