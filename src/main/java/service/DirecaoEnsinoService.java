package service;

import dao.DirecaoEnsinoDAO;
import java.util.List;
import modelo.DirecaoEnsino;
import util.NegocioException;

public class DirecaoEnsinoService {
    
    private DirecaoEnsinoDAO dao;
    
    public DirecaoEnsinoService(){
        dao = new DirecaoEnsinoDAO();
    }
    
    public DirecaoEnsino buscarPorCodigo(Integer id) throws NegocioException {
        if(id == null || id <= 0)
            throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<DirecaoEnsino> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(DirecaoEnsino entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<DirecaoEnsino> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public Boolean isLoginValido(String login) throws NegocioException{
        
        if(login == null || login.trim().equals("")){
            throw new NegocioException("Digite o login!");
        }
        
        return dao.isLoginValido(login);
    }
}
