/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import locadoraapp.model.exceptions.AdministradorException;
import locadoraapp.model.exceptions.ClienteException;
import locadoraapp.model.exceptions.FilmeException;

/**
 *
 * @author Josinaldo
 */
public class SistemaLocadora implements Locadora {

    private List<Filme> filmes;
    private List<Cliente> clientes;
    private List<Administrador> administradores;

    public SistemaLocadora() {
        this.filmes = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws ClienteException {
        if (this.temCliente(cliente)) {
            throw new ClienteException("Cliente já existe");
        }
        this.clientes.add(cliente);
    }

    @Override
    public Cliente alteraCliente(Cliente cliente) {
        return this.consultarCliente(cliente.getId());
    }

    @Override
    public boolean excluirCliente(Cliente cliente) throws ClienteException {
        if (!this.temCliente(cliente)) {
            throw new ClienteException("Cliente não existe");
        }
        Cliente c = this.consultarCliente(cliente.getId());
        this.clientes.remove(c);
        return true;
    }

    @Override
    public List<Cliente> consultarCliente(String nome, Integer id) {
        List<Cliente> listacliente = new ArrayList<>();
        for (Cliente c : this.clientes) {
            if (c.getNome().equals(nome) || c.getId().equals(id)) {
                listacliente.add(c);
            }
        }
        return listacliente;
    }

    public Cliente consultarCliente(Integer id) {
        Cliente tmp = null;
        for (Cliente c : this.clientes) {
            if (c.getId().equals(id)) {
                tmp = c;
            }
        }
        return tmp;
    }

    public boolean temCliente(Cliente cliente) {
        boolean achou = false;
        for (Cliente c : this.clientes) {
            if (c.getId().equals(cliente.getId())) {
                achou = true;
            }
        }
        return achou;
    }

    public boolean temFilme(Filme filme) {
        boolean achou = false;
        for (Filme f : this.filmes) {
            if (f.getId().equals(filme.getId())) {
                achou = true;
            }
        }
        return achou;
    }

    public boolean temAdmin(Administrador admin) {
        boolean achou = false;
        for (Administrador a : this.administradores) {
            if (a.getId().equals(admin.getId())) {
                achou = true;
            }
        }
        return achou;
    }

    @Override
    public void cadastarAdmin(Administrador administrador) throws AdministradorException {
        if (this.temAdmin(administrador)) {
            throw new AdministradorException("Administrador já cadastrado");
        }
        this.administradores.add(administrador);
    }

    @Override
    public void cadastrarFilme(Filme filme) throws FilmeException {
        if (this.temFilme(filme)) {
            throw new FilmeException("Filme já cadastrado");
        }
        this.filmes.add(filme);
    }

    @Override
    public Filme alterarFilme(Filme filme) throws FilmeException {
        return (Filme) this.consultarDispFilme(filme.getId(), filme.getNome());
    }

    @Override
    public boolean excluirFilme(Filme filme) throws FilmeException {
        if(!this.temFilme(filme)){
            throw new FilmeException("Filme não existe");
        }
        Filme f = (Filme) this.consultarDispFilme(filme.getId(), filme.getNome());
        this.filmes.remove(f);
        return true;
    }

    @Override
    public List<Filme> consultarDispFilme(Integer id, String nome) {
        List<Filme> filmesDisponiveis = new ArrayList<>();
        for (Filme f : this.filmes) {
            if (f.isDisponivel()) {
                filmesDisponiveis.add(f);
            }
        }
        return filmesDisponiveis;
    }

    public boolean consultarDispFilme(Filme filme) throws FilmeException {
        if (!this.temFilme(filme)) {
            throw new FilmeException("Filme não existe!");
        }
        Filme tmp = new Filme();
        for (Filme f : this.filmes) {
            if (f.getId().equals(filme.getId())) {
                tmp = f;
            }
        }
        return tmp.isDisponivel();
    }

    @Override
    public boolean verificaMulta(Date devolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double gerarMulta(Date devolucao, Date atual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void locaFilme(Filme filme, Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void devolverFilme(Filme filme, Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
