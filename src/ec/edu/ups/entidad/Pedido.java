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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private String fecha;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String observacion;
	@Transient
	private boolean editable;

	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "comida")
	@OneToMany
	private List<Comida> listaComidas;
	
	private Tarjeta tarjeta;
	
	
	public Pedido() {
		listaComidas = new ArrayList<Comida>();
	}


	public Pedido(int numero, String fecha, String nombreCliente, double subtotal, double iva, double total,
			String observacion, List<Comida> listaComidas, Tarjeta tarjeta) {
		
		this.numero = numero;
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.observacion = observacion;
		this.listaComidas = listaComidas;
		this.tarjeta = tarjeta;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
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


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public List<Comida> getListaComidas() {
		return listaComidas;
	}


	public void setListaComidas(List<Comida> listaComidas) {
		this.listaComidas = listaComidas;
	}


	public Tarjeta getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", fecha=" + fecha + ", nombreCliente=" + nombreCliente + ", subtotal="
				+ subtotal + ", iva=" + iva + ", total=" + total + ", observacion=" + observacion + ", listaComidas="
				+ listaComidas + ", tarjeta=" + tarjeta + "]";
	}
	

}
