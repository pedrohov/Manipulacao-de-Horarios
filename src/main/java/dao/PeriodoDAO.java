package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Periodo;

public class PeriodoDAO extends HibernateGenericDAO<Periodo, Integer> {
    
    public PeriodoDAO() {
        
    }
    
    public List<Periodo> buscarPorNome(String nome){
        String sql = "Select c from Periodo c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Periodo.class).setParameter("1", nome).getResultList();
    }
    
}
