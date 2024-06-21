package com.example.csd214lab2milan;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    public TextField uid;
    public TextField uname;
    public TextField uemail;
    public TextField uadrress;
    @FXML
    private TableView<milan> tableview;
    @FXML
    private TableColumn<milan,Integer > ID;
    @FXML
    private TableColumn<milan, String> NAME;
    @FXML
    private TableColumn<milan,String> EMAIL;
    @FXML
    private TableColumn<milan,String> ADRRESS;
    ObservableList<milan> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<milan,Integer>("ID"));
        NAME.setCellValueFactory(new PropertyValueFactory<milan,String>("NAME"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<milan,String>("EMAIL"));
        ADRRESS.setCellValueFactory(new PropertyValueFactory<milan,String>("ADRRESS"));
        tableview.setItems(list);
    }
    @FXML

    public void fetchdata(ActionEvent actionEvent) {
        populateTable();
    }
    public void populateTable() {
        list.clear();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hahaha";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM milan";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String NAME = resultSet.getString("NAME");
                String EMAIL = resultSet.getString("EMAIL");
                String ADRRESS = resultSet.getString("ADRRESS");
                tableview.getItems().add(new milan(ID, NAME,EMAIL,ADRRESS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertdata(ActionEvent actionEvent) {
        String NAME = uname.getText();
        String EMAIL = uemail.getText();
        String ADRRESS = uadrress.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/hahaha";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `milan`( `NAME`, `EMAIL`, `ADRRESS`) VALUES ('"+NAME+"','"+EMAIL+"','"+ADRRESS+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deletedata(ActionEvent actionEvent) {
        String ID = uid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/hahaha";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `milan` WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatedata(ActionEvent actionEvent) {
        String ID = uid.getText();
        String NAME = uname.getText();
        String EMAIL = uemail.getText();
        String ADRRESS= uadrress.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/hahaha";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `milan` SET `NAME`='"+NAME+"',`EMAIL`='"+EMAIL+"',`ADRRESS`='"+ADRRESS+"' WHERE ID='"+ID+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loaddata(ActionEvent actionEvent) {
        String ID = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hahaha";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM milan WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String NAME = resultSet.getString("NAME");
                String EMAIL = resultSet.getString("EMAIL");
                String ADRRESS = resultSet.getString("ADRRESS");

                uname.setText(NAME);
                uemail.setText(EMAIL);
                uadrress.setText(ADRRESS);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



