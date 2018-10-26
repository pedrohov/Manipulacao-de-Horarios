package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Solicitacao;

public class SolicitacaoDAO extends HibernateGenericDAO<Solicitacao, Integer> {
    
    public SolicitacaoDAO() {
        
    }
    
    public List<Solicitacao> buscarPorNome(String nome){
        String sql = "Select c from Solicitacao c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Solicitacao.class).setParameter("1", nome).getResultList();
    }
    
}
