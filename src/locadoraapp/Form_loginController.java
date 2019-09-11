/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import connection.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import locadoraapp.model.Administrador;
import locadoraapp.model.DAO.AdministradorDAO;

/**
 * FXML Controller class
 *
 * @author Josinaldo
 */
public class Form_loginController {

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;
    @FXML
    private VBox vbox;
    @FXML
    private FXMLSistemaController objTela;
    
    private List<Administrador> administradores;
    
    //Atributos para manipulação de Banco de Dados
    private final AdministradorDAO administradorDAO = new AdministradorDAO();

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Window owner = submitButton.getScene().getWindow();
        if (nameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Por favor digite seu nome");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Por favor digite sua senha");
            return;
        }
        if (administradorDAO.checkLogin(nameField.getText(), passwordField.getText())) {
            AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Bem vindo " + nameField.getText()); 
            Locadoraapp.MudarTela("sistema");
        }
        else{
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner,"Form Error!",
                "Login ou senha incorreto "); 
   
        }
    }
}
