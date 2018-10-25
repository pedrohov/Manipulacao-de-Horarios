package service;

import dao.DisciplinaDAO;
import java.util.List;
import modelo.Disciplina;
import util.NegocioException;

public class DisciplinaService {
    
    private DisciplinaDAO dao;
    
    public DisciplinaService(){
        dao = new DisciplinaDAO();
    }
    
    public Disciplina buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Disciplina> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Disciplina entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Disciplina> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
