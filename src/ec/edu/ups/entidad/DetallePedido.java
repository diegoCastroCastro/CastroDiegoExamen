package ec.edu.ups.entidad;

import javax.persistence.Id;

public class DetallePedido {
	
	@Id
	private int id;
	private Comida comida;
	private int cantidad;
	private double subtotal;
	
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
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
