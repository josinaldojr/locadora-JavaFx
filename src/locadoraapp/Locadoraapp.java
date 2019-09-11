/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
/**
 *
 * @author Josinaldo
 */
public class Locadoraapp extends Application {
    
    private static Stage stage;
    
    private static Scene root, sistema;
    
    @Override
    public void start(Stage stage) throws Exception{
        Locadoraapp.stage = stage;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Form_login.fxml"));
        stage.setTitle("LOCADORA");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
        
        //Telas do APP:
        
        Parent telaSistema = FXMLLoader.load(getClass().getResource("FXMLSistema.fxml"));
        Locadoraapp.sistema = new Scene(telaSistema);
        
    }
    
    public static void MudarTela(String tela){
        switch(tela){
        
            case "login":
                stage.setScene(root);
                break;
            case "sistema":
                stage.setScene(sistema);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
