package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private GregorianCalendar fecha;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String observacion;
	@Transient
	private boolean editable;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Comida> listaComidas;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Tarjeta>listaTarjetas;
	
	
	public Pedido() {
		listaComidas = new ArrayList<Comida>();
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public GregorianCalendar getFecha() {
		return fecha;
	}


	public void setFecha(GregorianCalendar fecha) {
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


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	public List<Comida> getListaComidas() {
		return listaComidas;
	}


	public void setListaComidas(List<Comida> listaComidas) {
		this.listaComidas = listaComidas;
	}


	public List<Tarjeta> getListaTarjetas() {
		return listaTarjetas;
	}


	public void setListaTarjetas(List<Tarjeta> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	
}
