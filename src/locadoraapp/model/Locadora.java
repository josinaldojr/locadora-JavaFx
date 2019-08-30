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
    public void alteraCliente (Cliente cliente);
    public void excluirCliente (Cliente cliente);
    public List<Cliente> consultarCliente();
    public void cadastarAdmin (Administrador administrador) throws AdministradorException;
    public void cadastrarFilme (Filme filme);
    public void alterarFilme (Filme filme) throws FilmeException;
    public void excluirFilme (Filme filme) throws FilmeException;
    public List<ItemLocacaoPK> consultarDispFilme(Integer id, String nome);
    public boolean verificaMulta(Date devolucao);
    public double gerarMulta(Date devolucao, Date atual);    
    public void locaFilme(Filme filme, Cliente cliente);
    public void devolverFilme(Filme filme, Cliente cliente);
   
}