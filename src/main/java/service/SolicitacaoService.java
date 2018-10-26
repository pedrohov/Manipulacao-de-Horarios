package service;

import dao.SolicitacaoDAO;
import java.util.List;
import modelo.Solicitacao;

public class SolicitacaoService {
    
    private SolicitacaoDAO dao;
    
    public SolicitacaoService(){
        dao = new SolicitacaoDAO();
    }
    
    public Solicitacao buscarPorCodigo(Integer id) {
        if(id == null || id <= 0)
            return null;     
        return dao.buscarPorCodigo(id);
    }
    
    public List<Solicitacao> buscarPorNome(String nome){ 
        return dao.buscarPorNome(nome);
    }
    
    public void salvar(Solicitacao entidade){
        dao.salvar(entidade);
    }
    
    public boolean remover(Integer id){
        return dao.remover(id);
    }
    
    public List<Solicitacao> buscarTodos(){
        return dao.buscarTodos();
    }
 
}
