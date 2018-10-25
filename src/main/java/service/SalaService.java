package service;

import dao.SalaDAO;
import java.util.List;
import modelo.Sala;
import util.NegocioException;

public class SalaService {
    
    private SalaDAO dao;
    
    public SalaService(){
        dao = new SalaDAO();
    }
    
    public Sala buscarPorCodigo(Integer id) throws NegocioException {
        if(id == null || id <= 0)
            throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Sala> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Sala entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Sala> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
