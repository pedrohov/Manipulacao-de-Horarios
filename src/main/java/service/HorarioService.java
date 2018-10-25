package service;

import dao.HorarioDAO;
import java.util.List;
import modelo.Horario;
import util.NegocioException;

public class HorarioService {
    
    private HorarioDAO dao;
    
    public HorarioService(){
        dao = new HorarioDAO();
    }
    
    public Horario buscarPorCodigo(Integer id) throws NegocioException {
        if(id == null || id <= 0)
            throw new NegocioException("Informe um código válido.");       
        return dao.buscarPorCodigo(id);
    }
    
    public void salvar(Horario entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Horario> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
