package com.example.forexamchet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {

    @FXML
    Label label;
    @FXML
    TextField loginField;
    @FXML
    PasswordField passField;
    @FXML
    Button button;

    @FXML
   public void login(ActionEvent event) throws SQLException, IOException{
        Window window = button.getScene().getWindow();
        System.out.println(loginField.getText());
        System.out.println(passField.getText());


        if (passField.getText().isEmpty()){
            label.setText("Введите пароль");
        }
        if (loginField.getText().isEmpty()){
            label.setText("Введите логин");
        }
        String login = loginField.getText();
        String password = passField.getText();

        DB db = new DB();

        boolean flag=db.validate(login, password);

        if (!flag){
            label.setText("Неверный логин или пароль");
        }else {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            stage.setTitle("Welcome");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
            stage.setResizable(false);
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
    }

}