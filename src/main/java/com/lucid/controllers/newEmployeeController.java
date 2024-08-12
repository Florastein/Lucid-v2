package com.lucid.controllers;

import com.lucid.DBConnection;
import com.lucid.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newEmployeeController {
    @FXML
    private Text updates; //successful or failed

    @FXML
    private TextField idField; //staffID

    @FXML
    private TextField fname; //firstname

    @FXML
    private TextField Lname; //Lastname

    @FXML
    private Text passcheck; // confirm text

    @FXML
    private TextField email; // email

    @FXML
    private TextField telephone; //telephone

    @FXML
    private TextField uname; // Username

    @FXML
    private PasswordField passwd; //password

    @FXML
    private PasswordField passwd1; //confirm password

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    public void save(ActionEvent event) throws IOException, SQLException {

        String FnameVAlue = fname.getText();
        String LnameValue = Lname.getText();
        String EmailValue = email.getText();
        String TelephoneValue = telephone.getText();
        String usernameVAlue = uname.getText();
        String passwdValue = passwd.getText();
        String passwdConfirmValue = passwd1.getText();
        String idValue = idField.getText();


        if (!passwdConfirmValue.equals(passwdValue)){
            passcheck.setFill(Color.RED);
            passcheck.setText("Password Mismatch");

        } else {
            passcheck.setFill(Color.GREEN);
            passcheck.setText("Password Confirmed");



            String query = "INSERT INTO `employee` (`Firstname`,`Lastname`,`Telephone`,`Email`,`Username`,`Password`) VALUES(?, ?, ?, ?, ?, ?)";
            String query1 = "INSERT INTO `staff` (`Username`,`Password`) VALUES(?, ?)";


            try {

                Connection conn = DBConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);

                PreparedStatement preparedStatement1 = conn.prepareStatement(query1);

                preparedStatement.setString(1, FnameVAlue);
                preparedStatement.setString(2, LnameValue);
                preparedStatement.setString(3, TelephoneValue);
                preparedStatement.setString(4, EmailValue);
                preparedStatement.setString(5, usernameVAlue);
                preparedStatement.setString(6, passwdValue);

                //preparedStatement1.setString(1, idValue);
                preparedStatement1.setString(1, usernameVAlue);
                preparedStatement1.setString(2, passwdValue);


                preparedStatement.executeUpdate();
                preparedStatement1.executeUpdate();

                updates.setText("Registration Successful");
                updates.setFill(Color.GREEN);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                updates.setText(e.getMessage());
                updates.setFill(Color.GREEN);
            }

        }

        /*String query = "INSERT INTO `employee` (`Firstname`,`Lastname`,`Telephone`,`Email`) VALUES(?, ?, ?, ?)";
        String query1 = "INSERT INTO `staff` (`ID`,`Username`,`Password`,`Name`) VALUES(?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            PreparedStatement preparedStatement1 = conn.prepareStatement(query1);

            preparedStatement.setString(1, FnameVAlue);
            preparedStatement.setString(2, LnameValue);
            preparedStatement.setString(3, TelephoneValue);
            preparedStatement.setString(4, EmailValue);

            preparedStatement1.setString(1, idValue);
            preparedStatement1.setString(2, usernameVAlue);
            preparedStatement1.setString(3, passwdValue);
            preparedStatement1.setString(4, passwdConfirmValue);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        }*/

    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/lucid/manage_employees.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();
    }

    @FXML
    public void clear(ActionEvent event) throws IOException {
        fname.clear();
        Lname.clear();
        email.clear();
        telephone.clear();

        uname.clear();
        passwd.clear();
        passwd1.clear();
        idField.clear();
    }

    @FXML
    private Button manage_employyes; // selector


    @FXML
    public void initialize() {
        active_button(manage_employyes);
    }

    @FXML
    public void active_button(Button button) {
        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                new CornerRadii(10),
                new BorderWidths(3));
        Border border = new Border(borderStroke);
        button.setStyle("-fx-background-color: #ffffff");
        button.setTextFill(Color.BLACK);
        button.setBorder(border);
    }

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
        /*root = FXMLLoader.load(getClass().getResource("/com/lucid/NewRental.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("NewRental.fxml"));
        Parent root = loader.load(getClass().getResource("NewRental.fxml"));
        Stage stage = (Stage) dashboard.getScene().getWindow();
        Scene scene = new Scene(root);

        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.setX(30);
        stage.setY(30);

        stage.setScene(scene);*/

        loadScene(event, "/com/lucid/NewRental.fxml.fxml");
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
        loadScene(event, "/com/lucid/vehicle_return.fxml");
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

        Image icon = new Image(HelloApplication.class.getResource("/com/lucid/pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.close();
    }

    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image(getClass().getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();
    }
}
