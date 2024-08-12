package com.lucid.controllers;

import com.lucid.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;




public class AdminController {

    @FXML
    private Text username;

    @FXML
    private Button dashboard;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    public void initialize() {
        active_button(dashboard);
    }

    @FXML
    public void active_button(Button button){
        BorderStroke borderStroke = new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(10),
                new BorderWidths(3));
        Border border = new Border(borderStroke);
        button.setStyle("-fx-background-color: #ffffff");
        button.setTextFill(Color.BLACK);
        button.setBorder(border);
    }


   /* public String setUsername() throws SQLException {
        String username = HelloController.getUsername();
        String passwd = HelloController.getPasswd();
        String uname = null;

        try{
            String query = "SELECT * FROM staff WHERE Username = ? AND Password = ?";
            PreparedStatement ps = login.getConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, passwd);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                uname = rs.getString("Name");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return uname;
    }*/

    @FXML
    protected void gotoDashboard( ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/

        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();*/
        loadScene(event, "/com/lucid/admin.fxml");
    }

    @FXML
    protected void manage_employees( ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/

        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/manage_employees.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();*/
        loadScene(event, "/com/lucid/manage_employees.fxml");
    }

    @FXML
    protected void newRental(ActionEvent event) throws IOException{
           /* root = FXMLLoader.load(getClass().getResource("/com/lucid/NewRental.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/
        loadScene(event, "/com/lucid/NewRental.fxml");

        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("NewRental.fxml"));
        Parent root = loader.load(getClass().getResource("NewRental.fxml"));
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/
    }

    @FXML
    protected void vehicle_return(ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/

        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/vehicle_return.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();*/
        loadScene(event, "/com/lucid/NewRental.fxml");
    }

    @FXML
    protected void manage_vehicle(ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/

        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/manage_vehicle.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();*/
        loadScene(event, "/com/lucid/manage_vehicle.fxml");
    }

    @FXML
    protected void log_out(ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/
        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();*/
        loadScene(event, "/com/lucid/login.fxml");
    }

    @FXML
    protected void exit(ActionEvent event) throws IOException {
        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/
        root = FXMLLoader.load(getClass().getResource("/com/lucid/admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.close();
    }

    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image(getClass().getResource("/com/lucid/pngegg.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();
    }


}
