package service;

import dao.CoordenadorDAO;
import java.util.List;
import modelo.Coordenador;
import util.NegocioException;

public class CoordenadorService {
    
    private CoordenadorDAO dao;
    
    public CoordenadorService(){
        dao = new CoordenadorDAO();
    }
    
    public Coordenador buscarPorCodigo(Integer id) throws NegocioException {
        if(id == null || id <= 0)
            throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Coordenador> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Coordenador entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Coordenador> buscarTodos(){
        return dao.buscarTodos();
    }
    
    public Boolean isLoginValido(String login) throws NegocioException{
        
        if(login == null || login.trim().equals("")){
            throw new NegocioException("Digite o login!");
        }
        
        return dao.isLoginValido(login);
    }
}
