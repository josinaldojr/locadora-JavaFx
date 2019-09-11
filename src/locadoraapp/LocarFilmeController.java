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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arthur
 */
public class LocarFilmeController implements Initializable {
    @FXML
    private TextField txNome;

    @FXML
    private TextField txDiretor;

    @FXML
    private DatePicker dateData;

    @FXML
    private Button btBuscar;

   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
