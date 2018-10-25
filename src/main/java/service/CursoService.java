package service;

import dao.CursoDAO;
import java.util.List;
import modelo.Curso;
import util.NegocioException;

public class CursoService {
    
    private CursoDAO dao;
    
    public CursoService(){
        dao = new CursoDAO();
    }
    
    public Curso buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;
        	//throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public List<Curso> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Curso entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Curso> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
