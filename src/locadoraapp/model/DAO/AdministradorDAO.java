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

    public List<Administrador> read() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<Administrador> administradores = new ArrayList<>();

        try {
            stnt = con.prepareStatement("SELECT * FROM cliente");
            rs = stnt.executeQuery();
            while (rs.next()) {

                Administrador administrador = new Administrador();

                administrador.setNome(rs.getString("NOME"));
                administrador.setLogin(rs.getString("LOGIN"));
                administrador.setSenha(rs.getString("SENHA"));

                administradores.add(administrador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return administradores;
    }

    public List<Administrador> readForNome(String nome) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stnt = null;
        ResultSet rs = null;

        List<Administrador> administradores = new ArrayList<>();

        try {
            stnt = con.prepareStatement("SELECT * FROM administrador WHERE NOME LIKE ?");
            stnt.setString(1, "%" + nome + "%");
            rs = stnt.executeQuery();
            while (rs.next()) {

                Administrador administrador = new Administrador();

                administrador.setNome(rs.getString("NOME"));
                administrador.setLogin(rs.getString("LOGIN"));
                administrador.setSenha(rs.getString("SENHA"));

                administradores.add(administrador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }

        return administradores;
    }

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        ResultSet rs = null;

        boolean check = false;

        try {

            stnt = con.prepareStatement("SELECT * FROM locadora.administrador WHERE LOGIN = ? and SENHA = ?");
            stnt.setString(1, login);
            stnt.setString(2, senha);
            rs = stnt.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return check;
    }

    public void update(Administrador a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try {
            stnt = con.prepareStatement("UPDATE administrador SET NOME = ? ,LOGIN = ?,SENHA = ? WHERE IDADMINISTRADOR = ?");
            stnt.setString(1, a.getNome());
            stnt.setString(2, a.getLogin());
            stnt.setString(3, a.getSenha());
            stnt.setInt(4, a.getId());
            stnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);

        }
    }

    public void delete(Administrador a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try {
            stnt = con.prepareStatement("DELETE FROM administrador WHERE IDADMINISTRADOR = ?");
            stnt.setInt(1, a.getId());
            stnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }
}
