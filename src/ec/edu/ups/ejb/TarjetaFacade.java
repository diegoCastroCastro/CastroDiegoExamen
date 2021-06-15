package ec.edu.ups.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido;
import ec.edu.ups.entidad.Tarjeta;

@Stateless
public class TarjetaFacade extends AbstractFacade<Tarjeta> {
	
	@PersistenceContext(unitName = "CastroDiegoExamen")
	private EntityManager em;

	public TarjetaFacade() {
		super(Tarjeta.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Tarjeta> listarTarjetas(){
		String jpql = "SELECT t FROM Tarjeta t";
		return em.createQuery(jpql).getResultList();
	}

}
