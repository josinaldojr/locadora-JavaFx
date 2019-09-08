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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
