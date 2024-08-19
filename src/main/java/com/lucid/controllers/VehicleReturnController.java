/*//package com.lucid.controllers;
//
//
//import com.lucid.DBConnection;
//import com.lucid.HelloApplication;
//import com.lucid.models.Vehicle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class VehicleReturnController {
//
//    @FXML
//    private Button vehicle_return;
//
//    @FXML
//    private Stage stage;
//
//    @FXML
//    private Scene scene;
//
//    @FXML
//    private Parent root;
//
//    private DBConnection connection;
//
//    @FXML
//    private TextField searchBox;
//
//    @FXML
//    private TableView<Vehicle> vehicleTable;
//
//    @FXML
//    public void initialize() {
//        active_button(vehicle_return);
//
//
//    }
//
//    @FXML
//    public void active_button(Button button){
//        BorderStroke borderStroke = new BorderStroke(
//                Color.WHITESMOKE,
//                BorderStrokeStyle.SOLID,
//                new CornerRadii(10),
//                new BorderWidths(3));
//        Border border = new Border(borderStroke);
//        button.setStyle("-fx-background-color: #ffffff");
//        button.setTextFill(Color.BLACK);
//        button.setBorder(border);
//    }
//
//
//   /* public String setUsername() throws SQLException {
//        String username = HelloController.getUsername();
//        String passwd = HelloController.getPasswd();
//        String uname = null;
//
//        try{
//            String query = "SELECT * FROM staff WHERE Username = ? AND Password = ?";
//            PreparedStatement ps = login.getConnection().prepareStatement(query);
//            ps.setString(1, username);
//            ps.setString(2, passwd);
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()){
//                uname = rs.getString("Name");
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return uname;
//    }*/
//
//    @FXML
//    protected void gotoDashboard( ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/admin.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("/com/lucid/pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.show();
//    }
//
//    @FXML
//    protected void manage_employees( ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/manage_employees.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("/com/lucid/pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.show();
//    }
//
//    @FXML
//    protected void newRental(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/NewRental.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("NewRental.fxml"));
//        Parent root = loader.load(getClass().getResource("NewRental.fxml"));
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//    }
//
//    @FXML
//    protected void vehicle_return(ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/vehicle_return.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("/com/lucid/pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.show();
//    }
//
//    @FXML
//    protected void manage_vehicle(ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/manage_vehicle.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("/com/lucid/pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.show();
//    }
//
//    @FXML
//    protected void log_out(ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/login.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.show();
//    }
//
//    @FXML
//    protected void exit(ActionEvent event) throws IOException {
//        /*FXMLLoader loader =new FXMLLoader(getClass().getResource("admin.fxml"));
//        Parent root = loader.load();
//        Stage stage = (Stage) dashboard.getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.setX(30);
//        stage.setY(30);
//
//        stage.setScene(scene);*/
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/vehicle_return.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//
//        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//
//        stage.close();
//    }
//
//    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
//        root = FXMLLoader.load(getClass().getResource(fxmlFile));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        Image icon = new Image(getClass().getResource("/com/lucid/pngegg.png").toExternalForm());
//        stage.getIcons().add(icon);
//        stage.show();
//    }
//
//    private boolean showConfirmationDialog(String title, String content) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        return alert.showAndWait().filter(ButtonType.OK::equals).isPresent();
//    }
//
//    private void showAlert(Alert.AlertType alertType, String title, String content) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        alert.showAndWait();
//    }
//
//    private void showErrorDialog(String title, String content) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        alert.showAndWait();
//    }
//
//    @FXML
//    private void search() {
//        String searchId = searchBox.getText();
//        if (!searchId.isEmpty()) {
//            ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//            String query = "SELECT * FROM vehicle WHERE ID = ?";
//
//            try (Connection connection = DBConnection.getInstance().getConnection();
//                 PreparedStatement pstmt = connection.prepareStatement(query)) {
//
//                pstmt.setInt(1, Integer.parseInt(searchId));
//                try (ResultSet rs = pstmt.executeQuery()) {
//                    while (rs.next()) {
//                        Vehicle vehicle = new Vehicle(
//                                rs.getInt("ID"),
//                                rs.getString("vehicleLicense"),
//                                rs.getString("brand"),
//                                rs.getString("model"),
//                                rs.getInt("year"),
//                                rs.getString("chasis"),
//                                rs.getString("color"),
//                                rs.getBoolean("isAvailable")
//                        );
//                        vehicles.add(vehicle);
//                    }
//                }
//                vehicleTable.setItems(vehicles);
//            } catch (SQLException e) {
//                showErrorDialog("Search Error", "An error occurred while searching: " + e.getMessage());
//            } catch (NumberFormatException e) {
//                showErrorDialog("Input Error", "Please enter a valid number for the vehicle ID.");
//            }
//        }
//    }
//
//    private void loadRentalData() {
//        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//        String query = "SELECT * FROM rental";
//        connection = DBConnection.getInstance();
//
//        try (PreparedStatement statement = connection.getConnection().prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            while (resultSet.next()) {
//                Vehicle vehicle = new Vehicle(
//                        resultSet.getInt("ID"),
//                        resultSet.getString("vehicleLicense"),
//                        resultSet.getString("brand"),
//                        resultSet.getString("model"),
//                        resultSet.getInt("year"),
//                        resultSet.getString("chasis"),
//                        resultSet.getString("color"),
//                        resultSet.getBoolean("isAvailable")
//                );
//                vehicles.add(vehicle);
//            }
//            vehicleTable.setItems(vehicles);
//        } catch (SQLException e) {
//            showErrorDialog("Database Error", "An error occurred while loading vehicle data: " + e.getMessage());
//        }
//    }
//}*/


package com.lucid.controllers;

import com.lucid.DBConnection;
import com.lucid.models.Rentals;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class VehicleReturnController {


    @FXML
    private Button vehicle_return;

    @FXML
    private TextField searchBox;

    @FXML
    private Button canc;

    @FXML
    private TableView<Rentals> vehicleTable;

    @FXML
    private TableColumn<Rentals, Integer> idColumn;

    @FXML
    private TableColumn<Rentals, String> licenseColumn;

    @FXML
    private TableColumn<Rentals, String> modelColumn;

    @FXML
    private TableColumn<Rentals, String> cnameColumn;

    @FXML
    private TableColumn<Rentals, String> rentalColumn;

    @FXML
    private TableColumn<Rentals, String> returnColumn;

    @FXML
    private Button deleteButton;

    private DBConnection connection;

    @FXML
    public void initialize() {
        setupTableColumns();
        loadRentalData();
        active_button(vehicle_return);
    }

    private void setupTableColumns() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        licenseColumn.setCellValueFactory(cellData -> cellData.getValue().licenseProperty());
        modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        cnameColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        rentalColumn.setCellValueFactory(cellData -> cellData.getValue().rentalDateProperty());
        returnColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());
    }

    @FXML
    protected void gotoDashboard(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/admin.fxml");
    }

    @FXML
    protected void manageEmployees(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/manage_employees.fxml");
    }

    @FXML
    protected void newRental(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/NewRental.fxml");
    }

    @FXML
    protected void vehicleReturn(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/vehicle_return.fxml");
    }

    @FXML
    protected void manageVehicle(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/manage_vehicle.fxml");
    }

    @FXML
    protected void logOut(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/login.fxml");
    }

    @FXML
    protected void exit(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void active_button(Button button) {
        button.setStyle("-fx-background-color: #ffffff");
        button.setTextFill(Color.BLACK);
        button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
    }

    @FXML
    protected void search(ActionEvent event) {
        String searchId = searchBox.getText();
        if (!searchId.isEmpty()) {
            ObservableList<Rentals> rentals = FXCollections.observableArrayList();
            String query = "SELECT * FROM rental WHERE `rental_id` = ?";

            try (Connection conn = DBConnection.getInstance().getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, Integer.parseInt(searchId));
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Rentals rental = new Rentals();
                        rental.setId(rs.getInt("ID"));
                        rental.setLicense(rs.getString("license_plate"));
                        rental.setModel(rs.getString("model"));
                        rental.setCustomerName(rs.getString("customer_name"));
                        rental.setRentalDate(rs.getString("rental_date"));
                        rental.setReturnDate(rs.getString("return_date"));
                        rentals.add(rental);
                    }
                }
                vehicleTable.setItems(rentals);
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Search Error", "An error occurred while searching: " + e.getMessage());
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter a valid number for the rental ID.");
            }
        } else {
            loadRentalData();
        }
    }

    private void loadRentalData() {
        ObservableList<Rentals> rentals = FXCollections.observableArrayList();
        String query = "SELECT * FROM rental";
        connection = DBConnection.getInstance();

        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Rentals rental = new Rentals();
                rental.setId(resultSet.getInt("rental_id"));
                rental.setLicense(resultSet.getString("vehicle_id"));
                rental.setModel(resultSet.getString("vehicleName"));
                rental.setCustomerName(resultSet.getString("customer_name"));
                rental.setRentalDate(resultSet.getString("rental_date"));
                rental.setReturnDate(resultSet.getString("return_date"));
                rentals.add(rental);
            }
            vehicleTable.setItems(rentals);
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while loading rental data: " + e.getMessage());
        }
    }


    @FXML
    protected void deleteSelectedItem(ActionEvent event) {
        Rentals selectedRental = vehicleTable.getSelectionModel().getSelectedItem();

        if (selectedRental == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "No rental selected. Please select a rental to return.");
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Return Confirmation");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to return the vehicle?");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            deleteRentalFromDatabase(selectedRental.getId());
            vehicleTable.getItems().remove(selectedRental);
        }
        canc.setText("FINISH");
    }

    private void deleteRentalFromDatabase(int rentalId) {
        String query = "DELETE FROM rental WHERE rental_id = ?";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, rentalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while returning the vehicle: " + e.getMessage());
        }
    }


    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(getClass().getResource("/com/lucid/pngegg.png").toExternalForm());
        stage.getIcons().add(icon);

        stage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
