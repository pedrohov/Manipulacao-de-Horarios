package dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Pessoa;

public class PessoaDAO extends HibernateGenericDAO<Pessoa, Integer> {

    public PessoaDAO() {
        
    }
    
    public List<Pessoa> buscarPorNome(String nome){
        String sql = "Select c from Pessoa c " +
                     "where c.nome like ?1";
        EntityManager em = getEntityManager();
        return em.createQuery(sql, Pessoa.class).setParameter("1", nome).getResultList();
    }
    
    public boolean isLoginValido(String login){
        String sql = "SELECT a FROM Pessoa a WHERE a.login LIKE :Login";
       
        EntityManager em = getEntityManager();
        Pessoa user =  em.createQuery(sql, Pessoa.class)
               .setParameter("Login", login)
               .getSingleResult();
       
        if(user != null)
           return true;
        else
           return false;
    }
    
}
