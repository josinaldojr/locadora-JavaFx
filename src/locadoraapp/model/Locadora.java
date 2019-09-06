/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp.model;

import java.util.Date;
import java.util.List;
import locadoraapp.model.exceptions.AdministradorException;
import locadoraapp.model.exceptions.ClienteException;
import locadoraapp.model.exceptions.FilmeException;

/**
 *
 * @author Josinaldo
 */
public interface Locadora {
    
    public void cadastrarCliente (Cliente cliente) throws ClienteException;
    public Cliente alteraCliente (Cliente cliente)  throws ClienteException;
    public boolean excluirCliente (Cliente cliente)  throws ClienteException;
    public List<Cliente> consultarCliente(String nome, Integer id) throws ClienteException;
    public void cadastarAdmin (Administrador administrador) throws AdministradorException;
    public void cadastrarFilme (Filme filme) throws FilmeException ;
    public Filme alterarFilme (Filme filme) throws FilmeException;
    public boolean excluirFilme (Filme filme) throws FilmeException;
    public List<Filme> consultarDispFilme(Integer id, String nome);
    public boolean verificaMulta(Date devolucao);
    public double gerarMulta(Date devolucao, Date atual);    
    public void locaFilme(Filme filme, Cliente cliente);
    public void devolverFilme(Filme filme, Cliente cliente);
}