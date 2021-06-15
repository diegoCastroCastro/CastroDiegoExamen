package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.ejb.TarjetaFacade;
import ec.edu.ups.entidad.Comida;
import ec.edu.ups.entidad.DetallePedido;
import ec.edu.ups.entidad.Pedido;
import ec.edu.ups.entidad.Tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PedidoFacade pedidoFacade;

	@EJB
	private ComidaFacade comidaFacade;

	@EJB
	private TarjetaFacade tarjetaFacade;

	String fecha;
	String detalle = "";
	String numTarjeta="";
	String nombreComida="";

	List<Comida> listaComidas;
	List<Tarjeta> listaTarjetas;
	List<Comida> listaComidasPedido = new ArrayList<Comida>();

	Date fec = new Date();
	private Comida comida = new Comida();
	private Tarjeta tarjeta = new Tarjeta();
	private String cliente;
	private Pedido pedido;
	
	private List<Pedido> listaPedidos = new ArrayList<Pedido>();
	private List<Pedido> listaBusqueda = new ArrayList<Pedido>();
	
	int cantidad;
	List<DetallePedido> listaDetalles = new ArrayList<DetallePedido>();
	

	private double total = 0;
	private double subtotal = 0;
	private double IVA = 0.12;

	public PedidoBean() {
		

	}

	@PostConstruct
	public void init() {
		this.fecha = fec.getDate() + "/" + fec.getMonth() + "/" + fec.getYear();
		this.listaComidas = comidaFacade.findAll();
		this.listaTarjetas = tarjetaFacade.listarTarjetas();
		this.listaPedidos = pedidoFacade.findAll();

	}

	public List<Comida> getListaComidas() {
		return listaComidas;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getFecha() {
		return fecha;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<DetallePedido> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<DetallePedido> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIVA() {
		return subtotal * 0.12;
	}

	public List<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	public String getNombreComida() {
		return nombreComida;
	}

	public void setNombreComida(String nombreComida) {
		this.nombreComida = nombreComida;
	}

	public List<Pedido> getListaBusqueda() {
		return listaBusqueda;
	}

	public void setListaBusqueda(List<Pedido> listaBusqueda) {
		this.listaBusqueda = listaBusqueda;
	}

	
	

	public void agregar() {
		DetallePedido deta = new DetallePedido();
		deta.setCantidad(this.cantidad);
		deta.setComida(this.comida);
		deta.setSubtotal(this.comida.getPrecioUnitario() * this.cantidad);
		this.listaDetalles.add(deta);
		this.listaComidasPedido.add(this.comida);
		subtotal = subtotal + deta.getSubtotal();
		total = total + subtotal;
	}

	public String registrarPedido() {
		try {
			FacesContext contexto = FacesContext.getCurrentInstance();
			Pedido pedido = new Pedido();
			pedido.setFecha(fec);
			pedido.setListaComidas(this.listaComidasPedido);
			pedido.setIva(12);
			pedido.setNombreCliente(this.cliente);
			pedido.setObservaciones(detalle);
			pedido.setSubtotal(this.subtotal);
			pedido.setTarjeta(this.tarjeta);
			pedidoFacade.create(pedido);
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se creo el pedido", ""));
			init();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "No se pudo crear el pedido", ""));
		}
		return null;
	}
	
	public void listarPedidos() {
	listaBusqueda =	 pedidoFacade.listarPorTarjeta(this.numTarjeta);	
	}
	
	/*
	public void listarPedidosComidas() {
		listaBusqueda =	 pedidoFacade.listarPorNombreComida(this.nombreComida);	
		}
		
	*/
	
	public void buscarPedido(String id) {
		pedidoFacade.find(id);
	}
	

	public void remover(int index) {
		this.listaDetalles.remove(index);
	}
}
