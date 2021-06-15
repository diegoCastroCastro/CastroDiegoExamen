package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

	@PersistenceContext(unitName = "CastroDiegoExamen")
	private EntityManager em;

	public PedidoFacade() {
		super(Pedido.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Pedido> listarPorTarjeta(String numTarjeta) {

		String jpql = "SELECT p FROM Pedido p WHERE p.tarjeta.numeroTarjeta='"+numTarjeta+"'";
		System.out.println(jpql);
		return em.createQuery(jpql).getResultList();

	}

}
