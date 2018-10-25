package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Curso;

public class CursoDAO extends HibernateGenericDAO<Curso, Integer> {
    
    public CursoDAO() {
        
    }
    
    public List<Curso> buscarPorNome(String nome){
        String sql = "Select c from Curso c " +
                    "where c.nome like ?1";
       
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Curso.class).setParameter("1", nome).getResultList();
    }
    
}
