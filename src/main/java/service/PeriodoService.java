package service;

import dao.PeriodoDAO;
import java.util.List;
import modelo.Periodo;
import util.NegocioException;

public class PeriodoService {
    
    private PeriodoDAO dao;
    
    public PeriodoService(){
        dao = new PeriodoDAO();
    }
    
    public Periodo buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
        	return null;
            //throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Periodo> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Periodo entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Periodo> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
