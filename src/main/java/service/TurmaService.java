package service;

import dao.TurmaDAO;
import java.util.List;
import modelo.Turma;
import util.NegocioException;

public class TurmaService {
    
    private TurmaDAO dao;
    
    public TurmaService(){
        dao = new TurmaDAO();
    }
    
    public Turma buscarPorCodigo(Integer id) throws NegocioException {
        if(id == null || id <= 0)
            throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public void salvar(Turma entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Turma> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
