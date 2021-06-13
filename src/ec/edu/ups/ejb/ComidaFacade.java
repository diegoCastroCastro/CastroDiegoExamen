package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Comida;



@Stateless
public class ComidaFacade extends AbstractFacade<Comida> {
	
	@PersistenceContext(unitName = "CastroDiegoExamen")
    private EntityManager em;

    public ComidaFacade() {
        super(Comida.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Comida> findByName(String name){
    	String jpql = "FROM Comida c WHERE c.nombre LIKE '" + name + "%'";
    	return (List<Comida>) em.createQuery(jpql).getResultList();
    }
	

}
