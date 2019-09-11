/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import locadoraapp.model.Cliente;

/**
 * FXML Controller class
 *
 * @author Josinaldo
 */
public class CadastrarClienteController implements Initializable {

    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteEmail;
    @FXML
    private Label labelClienteCPFCNPJ;
    @FXML
    private Label labelClienteTipo;
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private Label labelClienteEndereco;
    @FXML
    private TextField textFieldClienteNome;
    @FXML
    private TextField textFieldClienteEmail;
    @FXML
    private TextField textFieldClienteCPFCNPJ;
    @FXML
    private TextField textFieldClienteTipo;
    @FXML
    private TextField textFieldClienteTelefone;
    @FXML
    private TextField textFieldClienteEndereco;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Cliente cliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return the buttonConfirmarClicked
     */
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    /**
     * @param buttonConfirmarClicked the buttonConfirmarClicked to set
     */
    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.textFieldClienteNome.setText(cliente.getNome());
        this.textFieldClienteEmail.setText(cliente.getEmail());
        this.textFieldClienteCPFCNPJ.setText(cliente.getCpfOuCnpj());
        this.textFieldClienteTipo.setText(String.valueOf(cliente.getTipo()));
        this.textFieldClienteTelefone.setText(String.valueOf(cliente.getTelefones()));
        this.textFieldClienteEndereco.setText(String.valueOf(cliente.getEnderecos()));
    }

    @FXML
    public void handleButtonConfirmar() {

        if (validarEntradaDeDados()) {

            cliente.setNome(textFieldClienteNome.getText());
            cliente.setEmail(textFieldClienteEmail.getText());
            cliente.setCpfOuCnpj(textFieldClienteCPFCNPJ.getText());
            cliente.setTipo(Integer.parseInt(textFieldClienteTipo.getText()));
             

            buttonConfirmarClicked = true;
            dialogStage.close();
        }

    }

    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldClienteNome.getText() == null || textFieldClienteNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldClienteCPFCNPJ.getText() == null || textFieldClienteCPFCNPJ.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldClienteTelefone.getText() == null || textFieldClienteTelefone.getText().length() == 0) {
            errorMessage += "Telefone inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

}
