package com.lucid;

import com.lucid.controllers.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Cadmil Dynamics");

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        HelloController.switchSceneAfterDelay(5);*/

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Swift Vehicle Rents");

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();
        controller.setStage(stage);

        controller.switchSceneAfterDelay(2);
    }

    public static void main(String[] args) {
        launch();
    }
}