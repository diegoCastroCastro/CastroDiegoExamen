package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.entidad.Pedido;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable {

	@EJB
	private PedidoFacade pedidoFacade;
	private List<Pedido> list;
	
	
	private String fecha;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String descripcion;
	
	

	public PedidoBean(PedidoFacade pedidoFacade, List<Pedido> list, String fecha, String nombreCliente, double subtotal,
			double iva, double total, String descripcion) {
		
		this.pedidoFacade = pedidoFacade;
		this.list = list;
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.descripcion = descripcion;
	}

	public PedidoBean() {

	}
	
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void init() {
		list = pedidoFacade.findAll();
	}

	public Pedido[] getLisPedidos() {
		return list.toArray(new Pedido[0]);
	}

	public PedidoFacade getPedidoFacade() {
		return pedidoFacade;
	}

	public void setPedidoFacade(PedidoFacade pedidoFacade) {
		this.pedidoFacade = pedidoFacade;
	}

	public List<Pedido> getList() {
		return list;
	}

	public void setList(List<Pedido> list) {
		this.list = list;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String add() {
		pedidoFacade.create(new Pedido());
		list = pedidoFacade.findAll();
		return null;
	}

	public String delete(Pedido p) {
		pedidoFacade.remove(p);
		list = pedidoFacade.findAll();
		return null;
	}

	public String edit(Pedido p) {
		p.setEditable(true);
		return null;
	}

	public String save(Pedido p) {
		pedidoFacade.edit(p);
		p.setEditable(false);
		return null;
	}

}
