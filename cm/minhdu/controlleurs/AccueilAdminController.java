/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.minhdu.controlleurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class AccueilAdminController implements Initializable {

    @FXML
    private Circle circleLogo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image im = new Image(getClass().getResource("/cm/minhdu/icons/logo_MINHDU.png").toString());
        circleLogo.setFill(new ImagePattern(im));
    }

    @FXML
    private void closeCliquer(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void deconnexionCliquer(MouseEvent event) throws IOException {
        Stage stages = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stages.hide();
        newSatge("login");
    }

    public void newSatge(String path) throws IOException {
        AnchorPane pan = FXMLLoader.load(getClass().getResource("/cm/minhdu/fxml/" + path + ".fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Connexion");
        Scene scene = new Scene(pan);
        scene.setFill(Paint.valueOf("transparent"));
        stage.setScene(scene);
        stage.show();

    }

}
