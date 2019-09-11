/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    private Label labelClienteID; 
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private Label labelClienteCPFCNPJ;
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
    
    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewCliente();
        tableViewCliente.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));

        
    }
    
    public void carregarTableViewCliente(){
        
        listClientes = clienteDAO.read();
        
        
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteCPF.setCellValueFactory(new PropertyValueFactory<>("cpfOuCnpj"));

        observableListClientes = FXCollections.observableArrayList(listClientes);
        tableViewCliente.setItems(observableListClientes);
    }

    public void selecionarItemTableViewClientes(Cliente cliente){
        if (cliente != null) {
            labelClienteID.setText(String.valueOf(cliente.getId()));
            labelClienteNome.setText(cliente.getNome());
            labelClienteEmail.setText(cliente.getEmail());
            labelClienteCPFCNPJ.setText(cliente.getCpfOuCnpj());
            labelClienteTelefone.setText(String.valueOf(cliente.getTelefones()));
            labelClienteCPFCNPJ.setText(String.valueOf(cliente.getEnderecos()));
        } else {
            labelClienteID.setText("");
            labelClienteNome.setText("");
            labelClienteEmail.setText("");
            labelClienteCPFCNPJ.setText("");
            labelClienteTelefone.setText("");
            labelClienteEndereco.setText("");
        }

    }
    
    @FXML
    public void handleButtonInserir() throws IOException {
        Cliente cliente = new Cliente();
        boolean buttonConfirmarClicked = showCadastrarClienteController(cliente);
        if (buttonConfirmarClicked) {
            clienteDAO.create(cliente);
            carregarTableViewCliente();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            boolean buttonConfirmarClicked = showCadastrarClienteController(cliente);
            if (buttonConfirmarClicked) {
                clienteDAO.update(cliente);
                carregarTableViewCliente();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            clienteDAO.delete(cliente);
            carregarTableViewCliente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showCadastrarClienteController(Cliente cliente) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastrarClienteController.class.getResource("CadastrarCliente.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Clientes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        CadastrarClienteController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
    
    
    
    
}
