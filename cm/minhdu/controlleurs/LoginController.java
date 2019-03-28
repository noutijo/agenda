/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.minhdu.controlleurs;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Noumodong
 */
public class LoginController implements Initializable {

    private double x, y;
    @FXML
    private HBox panSnackBar;
    @FXML
    private Circle circleLogo;
    @FXML
    private JFXTextField identifiant;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton id_connecter;

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image im = new Image(getClass().getResource("/cm/minhdu/icons/logo_MINHDU.png").toString());
        circleLogo.setFill(new ImagePattern(im));
    }
//Afficher un message lorsque les identifiants de connexion ne sont pas correctes

    public void showSnackBar() {

        JFXSnackbar snac = new JFXSnackbar(panSnackBar);
        snac.getStyleClass().add("jfx-snackbar-content");
        snac.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        snac.show("                                  L'identifiant ou mot de passe incorrect.                                  ", 5000);

    }

    public void showNotif() {
        String title = "Félicitation";
        String message = "Vous pouvez accéder à votre espace. ";
        NotificationType notification = NotificationType.CUSTOM;

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setImage(new Image(getClass().getResource("/cm/minhdu/icons/logo_MINHDU.png").toString()));
        tray.setMessage(message);
        tray.setNotificationType(notification);
        tray.showAndDismiss(Duration.millis(5000));
    }

    @FXML
    private void bareDragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
        stage.setOpacity(0.85);
    }

    @FXML
    private void barePressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void bareReleased(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setOpacity(1);
    }

    @FXML
    private void seConnecterCliquer(MouseEvent event) throws IOException {

        if (identifiant.getText().equals("1")) {
            showSnackBar();
        } else if (identifiant.getText().equals("2")) {
            showNotif();
        } else {
            Stage stages = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stages.hide();
            newSatge("accueilAdmin");
        }

    }

    @FXML
    private void closeCliquer(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void seConnecterKeyPressed(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            if (identifiant.getText().equals("1")) {
                showSnackBar();
            } else if (identifiant.getText().equals("2")) {
                showNotif();
            } else {
                Stage stages = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stages.hide();
                newSatge("accueilAdmin");
            }

        }
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
