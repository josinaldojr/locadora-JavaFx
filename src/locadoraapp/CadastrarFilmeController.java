/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author josinaldo
 */
public class CadastrarFilmeController implements Initializable {

     @FXML
    private DatePicker txLançamento;

    @FXML
    private TextField txNome;

    @FXML
    private TextField txDiretor;

    @FXML
    private Button btButton;
    
    @FXML
    private Label labelPreço;
    
    @FXML
    private Button btButtonCancelar;

    @FXML
    private Button btButtonCadastrar;
    @FXML
    
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
         btButtonCancelar.setOnMouseClicked((javafx.scene.input.MouseEvent e)->{
           
        });
          btButtonCadastrar.setOnMouseClicked((javafx.scene.input.MouseEvent e)->{
           
        });
        // TODO
    }
    public void HandLeBotaoVoltar() throws IOException{
        Locadoraapp.MudarTela("sistema");
    }     
    
}
