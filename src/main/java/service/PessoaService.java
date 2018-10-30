package service;

import dao.PessoaDAO;
import java.util.List;
import modelo.Pessoa;
import util.NegocioException;

public class PessoaService {
    
    private PessoaDAO dao;
    
    public PessoaService(){
        dao = new PessoaDAO();
    }
    
    public Pessoa buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Pessoa> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Pessoa entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Pessoa> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public Boolean isLoginValido(String login) throws NegocioException{
        
        if(login == null || login.trim().equals("")){
            throw new NegocioException("Digite o login!");
        }
        
        return dao.isLoginValido(login);
    }
}
