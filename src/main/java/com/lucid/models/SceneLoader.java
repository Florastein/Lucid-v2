package com.lucid.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class SceneLoader {

    public Scene loadScene1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lucid/hello-view.fxml"));
        Parent root = loader.load();
        return new Scene(root);
    }

    public Scene loadScene2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lucid/login.fxml"));
        Parent root = loader.load();
        return new Scene(root);
    }

    public SceneLoader() {
    }

    // Add more methods for other scenes as needed
}
