/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp.model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import locadoraapp.model.Administrador;

/**
 *
 * @author Josinaldo
 */
public class AdministradorDAO {

    public void create(Administrador a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("INSERT INTO administrador(NOME, LOGIN, SENHA) VALUES (?,?,?)");
            stnt.setString(1, a.getNome());
            stnt.setString(2, a.getLogin());
            stnt.setString(3, a.getSenha());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }

}
