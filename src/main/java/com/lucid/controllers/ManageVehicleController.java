//package com.lucid.controllers;
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
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ManageVehicleController {
//
//    @FXML
//    private Button manage_vehicle;
//
//    @FXML
//    private TextField searchBox;
//
//    @FXML
//    private TableView<Vehicle> vehicleTable;
//
//    @FXML
//    private TableColumn<Vehicle, Integer> idColumn;
//
//    @FXML
//    private TableColumn<Vehicle, String> licenseColumn;
//
//    @FXML
//    private TableColumn<Vehicle, String> brandColumn;
//
//    @FXML
//    private TableColumn<Vehicle, String> modelColumn;
//
//    @FXML
//    private TableColumn<Vehicle, Integer> yearColumn;
//
//    @FXML
//    private TableColumn<Vehicle, String> chasisColumn;
//
//    @FXML
//    private TableColumn<Vehicle, String> colorColumn;
//
//    @FXML
//    private TableColumn<Vehicle, Boolean> isAvailableColumn;
//
//    private DBConnection connection;
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
//    @FXML
//    public void initialize() {
//        active_button(manage_vehicle);
//
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        licenseColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleLicense"));
//        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
//        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
//        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
//        chasisColumn.setCellValueFactory(new PropertyValueFactory<>("chasis"));
//        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
//        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
//
//        loadVehicleData();
//    }
//
//    @FXML
//    public void active_button(Button button) {
//        button.setStyle("-fx-background-color: #ffffff");
//        button.setTextFill(Color.BLACK);
//        button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//    }
//
//    @FXML
//    protected void gotoDashboard(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/admin.fxml");
//    }
//
//    @FXML
//    protected void manage_employees(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/manage_employees.fxml");
//    }
//
//    @FXML
//    protected void newRental(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/NewRental.fxml");
//    }
//
//    @FXML
//    protected void vehicle_return(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/vehicle_return.fxml");
//    }
//
//    @FXML
//    protected void manage_vehicle(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/manage_vehicle.fxml");
//    }
//
//    @FXML
//    protected void log_out(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/login.fxml");
//    }
//
//    private void loadScene(ActionEvent event, String fxmlFile) {
//        try {
//            root = FXMLLoader.load(getClass().getResource(fxmlFile));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            Image icon = new Image(getClass().getResource("/com/lucid/pngegg.png").toExternalForm());
//            stage.getIcons().add(icon);
//            stage.show();
//        } catch (IOException e) {
//            showErrorDialog("Error", "Unable to load the scene: " + e.getMessage());
//        }
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
//    private void loadVehicleData() {
//        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//        String query = "SELECT * FROM vehicle";
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
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        vehicleTable.setItems(vehicles);
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
//                ResultSet rs = pstmt.executeQuery();
//
//                while (rs.next()) {
//                    Vehicle vehicle = new Vehicle(
//                            rs.getInt("ID"),
//                            rs.getString("vehicleLicense"),
//                            rs.getString("brand"),
//                            rs.getString("model"),
//                            rs.getInt("year"),
//                            rs.getString("chasis"),
//                            rs.getString("color"),
//                            rs.getBoolean("isAvailable")
//                    );
//                    vehicles.add(vehicle);
//                }
//                vehicleTable.setItems(vehicles);
//            } catch (SQLException | NumberFormatException e) {
//                showErrorDialog("Search Error", "An error occurred while searching: " + e.getMessage());
//            }
//        }
//    }
//
//    @FXML
//    private void newVehicle(ActionEvent event) throws IOException {
//        loadScene(event, "/com/lucid/new_vehicle.fxml");
//    }
//
//    @FXML
//    private void removeVehicle(ActionEvent event) {
//        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
//        if (selectedVehicle == null) {
//            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a vehicle to delete.");
//            return;
//        }
//
//        if (showConfirmationDialog("Confirm Delete", "Are you sure you want to delete the selected vehicle?")) {
//            try {
//                String query = "DELETE FROM vehicle WHERE ID = ?";
//                PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(query);
//                preparedStatement.setInt(1, selectedVehicle.getId());
//
//                int rowsAffected = preparedStatement.executeUpdate();
//                if (rowsAffected > 0) {
//                    showAlert(Alert.AlertType.INFORMATION, "Success", "Vehicle deleted successfully.");
//                    loadVehicleData();
//                } else {
//                    showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete vehicle.");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while deleting the vehicle.");
//            }
//        }
//    }
//
//    private boolean showConfirmationDialog(String title, String content) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        return alert.showAndWait().get() == ButtonType.OK;
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
//    @FXML
//    protected void exit(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("/com/lucid/admin.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.close();
//    }
//}*/

package com.lucid.controllers;

import com.lucid.DBConnection;
import com.lucid.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageVehicleController {

    @FXML
    private Button manage_vehicle;
    @FXML
    private TextField searchBox;
    @FXML
    private TableView<Vehicle> vehicleTable;
    @FXML
    private TableColumn<Vehicle, Integer> idColumn;
    @FXML
    private TableColumn<Vehicle, String> licenseColumn;
    @FXML
    private TableColumn<Vehicle, String> brandColumn;
    @FXML
    private TableColumn<Vehicle, String> modelColumn;
    @FXML
    private TableColumn<Vehicle, Integer> yearColumn;
    @FXML
    private TableColumn<Vehicle, String> chasisColumn;
    @FXML
    private TableColumn<Vehicle, String> colorColumn;
    @FXML
    private TableColumn<Vehicle, Boolean> isAvailableColumn;



    private DBConnection connection;

    @FXML
    public void initialize() {
        setupTableColumns();
        loadVehicleData();
        active_button(manage_vehicle);
    }

    private void setupTableColumns() {
        /*idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        licenseColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleLicense"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        chasisColumn.setCellValueFactory(new PropertyValueFactory<>("chasis"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));*/

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        licenseColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleLicense"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        chasisColumn.setCellValueFactory(new PropertyValueFactory<>("chasis"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));

        loadVehicleData();
    }

    @FXML
    public void active_button(Button button) {
        button.setStyle("-fx-background-color: #ffffff");
        button.setTextFill(Color.BLACK);
        button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
    }

    @FXML
    protected void gotoDashboard(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/admin.fxml");
    }

    @FXML
    protected void manage_employees(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/manage_employees.fxml");
    }

    @FXML
    protected void newRental(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/NewRental.fxml");
    }

    @FXML
    protected void vehicle_return(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/vehicle_return.fxml");
    }

    @FXML
    protected void manage_vehicle(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/manage_vehicle.fxml");
    }

    @FXML
    protected void log_out(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/login.fxml");
    }

    private void loadScene(ActionEvent event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Image icon = new Image(getClass().getResource("/com/lucid/pngegg.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.show();
        } catch (IOException e) {
            showErrorDialog("Error", "Unable to load the scene: " + e.getMessage());
        }
    }

    private void showErrorDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void loadVehicleData() {
        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
        String query = "SELECT * FROM vehicle";
        connection = DBConnection.getInstance();

        try (PreparedStatement statement = connection.getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("ID"),
                        resultSet.getString("vehicleLicense"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("chasis"),
                        resultSet.getString("color"),
                        resultSet.getBoolean("isAvailable")
                );
                vehicles.add(vehicle);
            }
            vehicleTable.setItems(vehicles);
        } catch (SQLException e) {
            showErrorDialog("Database Error", "An error occurred while loading vehicle data: " + e.getMessage());
        }
    }

    @FXML
    private void search() {
        String searchId = searchBox.getText();
        if (!searchId.isEmpty()) {
            ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
            String query = "SELECT * FROM vehicle WHERE ID = ?";

            try (Connection connection = DBConnection.getInstance().getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(query)) {

                pstmt.setInt(1, Integer.parseInt(searchId));
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Vehicle vehicle = new Vehicle(
                                rs.getInt("ID"),
                                rs.getString("vehicleLicense"),
                                rs.getString("brand"),
                                rs.getString("model"),
                                rs.getInt("year"),
                                rs.getString("chasis"),
                                rs.getString("color"),
                                rs.getBoolean("isAvailable")
                        );
                        vehicles.add(vehicle);
                    }
                }
                vehicleTable.setItems(vehicles);
            } catch (SQLException e) {
                showErrorDialog("Search Error", "An error occurred while searching: " + e.getMessage());
            } catch (NumberFormatException e) {
                showErrorDialog("Input Error", "Please enter a valid number for the vehicle ID.");
            }
        }
    }

    @FXML
    private void newVehicle(ActionEvent event) throws IOException {
        loadScene(event, "/com/lucid/new_vehicle.fxml");
    }

    @FXML
    private void removeVehicle(ActionEvent event) {
        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
        if (selectedVehicle == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a vehicle to delete.");
            return;
        }

        if (showConfirmationDialog("Confirm Delete", "Are you sure you want to delete the selected vehicle?")) {
            String query = "DELETE FROM vehicle WHERE ID = ?";
            try (PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(query)) {
                preparedStatement.setInt(1, selectedVehicle.getId());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Vehicle deleted successfully.");
                    loadVehicleData();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete vehicle.");
                }
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while deleting the vehicle: " + e.getMessage());
            }
        }
    }

    private boolean showConfirmationDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        return alert.showAndWait().filter(ButtonType.OK::equals).isPresent();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/lucid/admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.close();
    }
}

