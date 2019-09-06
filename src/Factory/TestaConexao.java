/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException; 

/**
 *
 * @author Josinaldo
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc"); /* Aqui registra */
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jrjhjore123");

        conexao.close();    
    }
}
    
