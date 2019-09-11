/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp.model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import locadoraapp.model.Cliente;

/**
 *
 * @author Josinaldo
 */
public class ClienteDAO {

    public void create(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("INSERT INTO cliente(NOME, EMAIL, CPFOUCNPJ, TIPO) VALUES (?,?,?,?)");
            stnt.setString(1, c.getNome());
            stnt.setString(2, c.getEmail());
            stnt.setString(3, c.getCpfOuCnpj());
            stnt.setInt(4, c.getTipo());

            stnt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    
    }

    public List<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stnt = con.prepareStatement("SELECT * FROM locadora.cliente");
            rs = stnt.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("IDCLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setCpfOuCnpj(rs.getString("CPFOUCNPJ"));
                cliente.setTipo(rs.getInt("TIPO"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return clientes;

    }
    
    public List<Cliente> readForNome(String nome) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stnt = con.prepareStatement("SELECT * FROM cliente WHERE descricao NOME ?");
            stnt.setString(1,"%"+nome+"%");
            
            rs = stnt.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("IDCLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setCpfOuCnpj(rs.getString("CPFOUCNPJ"));
                cliente.setTipo(rs.getInt("TIPO"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return clientes;

    }
    public void update(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try {
            stnt = con.prepareStatement("UPDATE cliente SET NOME = ? ,EMAIL = ?,CPFOUCNPJ = ? WHERE IDCLIENTE = ?");
            stnt.setString(1, c.getNome());
            stnt.setString(2, c.getEmail());
            stnt.setString(3, c.getCpfOuCnpj());
            stnt.setInt(4, c.getTipo());
            stnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);

        }
    }

    public void delete(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try {
            stnt = con.prepareStatement("DELETE FROM cliente WHERE IDCLIENTE = ?");
            stnt.setInt(1, c.getId());
            stnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }

}
