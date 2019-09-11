/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import locadoraapp.model.Administrador;
import locadoraapp.model.DAO.AdministradorDAO;
import locadoraapp.model.DAO.ClienteDAO;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class CadastrarUsuarioController implements Initializable {
    
    @FXML
    private TableView<Administrador> tableViewUsuarios;
    @FXML
    private TableColumn<Administrador, String> tableNome;

    @FXML
    private TableColumn<Administrador, String> tableCPF;
    @FXML
    private Button buttonInserir;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonAlterar;

    private List<Administrador> listAdministrador;
    private ObservableList<Administrador> observableListAdministrador;
    
       //Atributos para manipulação de Banco de Dados
    
    private final AdministradorDAO administradorDAO = new AdministradorDAO();
  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          buttonInserir.setOnMouseClicked((javafx.scene.input.MouseEvent e)->{
           
        });
          
          buttonAlterar.setOnMouseClicked((javafx.scene.input.MouseEvent e)->{
              
        });
          
          buttonRemover.setOnMouseClicked((javafx.scene.input.MouseEvent e)->{
              
        });
          
    }    
     public void carregarTableViewCliente(){
        
        listAdministrador = administradorDAO.read();
        
        
        tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        observableListAdministrador = FXCollections.observableArrayList(listAdministrador);
        tableViewUsuarios.setItems(observableListAdministrador);
    }
    
}
