package com.lucid.controllers;

import com.lucid.DBConnection;
import com.lucid.HelloApplication;
import com.lucid.models.Employee;
import com.lucid.models.Staff;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageEmployeesController {
    @FXML
    private Text username; //administrator

    @FXML
    private Button manage_employyes; // selector

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> usernameColumn;

    @FXML
    private TableColumn<Employee, String> passwordColumn;

    @FXML
    private TableColumn<Employee, String> firstNameColumn;

    @FXML
    private TableColumn<Employee, String> lastNameColumn;

    @FXML
    private TableColumn<Employee, String> telephoneColumn;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    public void initialize() {
        active_button(manage_employyes);

        assert employeeTable != null : "fx:id=\"employeeTable\" was not injected: check your FXML file 'newEmployee.fxml'.";
        loadEmployeeData();
        loadEmployeeData();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
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
    private void search(ActionEvent event) {
        String keyword = searchBox.getText();
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String query1 = "SELECT * FROM employee WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1, keyword);

            // Execute the query for both tables
            ResultSet resultSet = preparedStatement.executeQuery();


            // Process the results from the employee table
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("Firstname");
                String lastName = resultSet.getString("Lastname");
                String telephone = resultSet.getString("Telephone");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String username = resultSet.getString("Username");

                // Create an Employee object and add it to the list
                Employee employee = new Employee(id, firstName, lastName, telephone, email, username,password);
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Update the TableView with the search results
        employeeTable.setItems(employees);
    }

    @FXML
    private void removeEmployee(ActionEvent event) throws IOException {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();

        if (selectedEmployee == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Employee Selected");
            alert.setContentText("Please select an employee to delete.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Delete");
        confirmAlert.setHeaderText("Delete Employee");
        confirmAlert.setContentText("Are you sure you want to delete employee: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName() + "?");

        if (confirmAlert.showAndWait().get() != ButtonType.OK) {
            return;
        }

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String query = "DELETE FROM employee WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, selectedEmployee.getId());


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText("Employee Deleted");
                successAlert.setContentText("Employee has been deleted successfully.");
                successAlert.showAndWait();

                loadEmployeeData();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Delete Failed");
                errorAlert.setContentText("Failed to delete the employee. Please try again.");
                errorAlert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Database Error");
            errorAlert.setHeaderText("Delete Failed");
            errorAlert.setContentText("An error occurred while deleting the employee: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }


    @FXML
    private void loadEmployeeData() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String query1 = "SELECT * FROM employee";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            ResultSet resultSet = preparedStatement1.executeQuery();

            // Process the results from the employee table
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("Firstname");
                String lastName = resultSet.getString("Lastname");
                String telephone = resultSet.getString("Telephone");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                String username = resultSet.getString("Username");

                Employee employee = new Employee(id, firstName, lastName, telephone, email, username, password);
                employees.add(employee);}

        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeTable.setItems(employees);
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

    @FXML
    public void newEmployee(ActionEvent event) throws IOException {

        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lucid/newEmployee.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image(HelloApplication.class.getResource("pngegg.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();*/

        loadScene(event, "/com/lucid/newEmployee.fxml");

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
