/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.minhdu.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Noumodong
 */
public class Launch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pan = FXMLLoader.load(getClass().getResource("/cm/minhdu/fxml/login.fxml"));

        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
         stage.setTitle("Connexion");
        Scene scene = new Scene(pan);
        scene.setFill(Paint.valueOf("transparent"));
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
