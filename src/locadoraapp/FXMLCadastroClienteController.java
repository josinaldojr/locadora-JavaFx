/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import connection.ConnectionFactory;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import locadoraapp.model.Cliente;
import locadoraapp.model.DAO.ClienteDAO;

/**
 * FXML Controller class
 *
 * @author Josinaldo
 */
public class FXMLCadastroClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewCliente;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteCPF;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteCNPJ;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteEmail;
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private Label labelClienteEndereco;
    @FXML
    private MenuItem menuItemClienteCPF;
    @FXML
    private MenuItem menuItemClienteCNPJ;
    @FXML
    private MenuItem menuItemClienteGerarID;
    
    private List<Cliente> listClientes;
    private ObservableList<Cliente> observableListClientes;
    
    //Atributos para manipulação de Banco de Dados
    
    private final Connection conexao = ConnectionFactory.getConnection();
    private final ClienteDAO clienteDAO;

    public FXMLCadastroClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
