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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Josinaldo
 */
public class FXMLSistemaController implements Initializable {
    
    @FXML
    private MenuItem menuItemCadastrarDescricao;
    @FXML
    private MenuItem menuItemCadastrarCliente;   
    @FXML
    private MenuItem menuItemCadastrarFilme;
    @FXML
    private MenuItem menuItemCadastrarUsuario;
    @FXML
    private MenuItem menuItemProcessosLocacao;
    @FXML
    private MenuItem menuItemRelatoriosListadeCliente;
    @FXML
    private MenuItem menuItemRelatoriosListadeFilmes;
    @FXML
    private MenuItem menuItemRelatoriosFilmesDisponiveis;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btLocar;
    @FXML
    private Button btDevolver;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    @FXML
    public void handleMenuItemCadastrarCliente() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/locadoraapp/FXMLCadastroCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    public void handLeMenuItemCadastrosUsuarios() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource ("/locadoraapp/CadastrarUsuario.fxml"));
        anchorPane.getChildren().setAll(a);
    }    
    
    public void handLeMenuItemCadastrosFilmes()throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource ("/locadoraapp/CadastrarFilme.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    public void HandLeBotao() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource ("/locadoraapp/LocarFilme.fxml"));
        anchorPane.getChildren().setAll(a);     
    }
    public void HandLeBotao2() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource ("/locadoraapp/DevolverFilme.fxml"));
        anchorPane.getChildren().setAll(a);
    }    
    
}
