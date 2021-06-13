package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.entidad.Comida;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "comidaBean")
@SessionScoped
public class ComidaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
    private ComidaFacade comidaFacade;
	
	@EJB
	private PedidoFacade pedidoFacade;
    
	private int codigo;
	private String nombre;
	private double precioUnitario;
    private List<Comida> listaComidas;

    public ComidaBean() {

    }    
    
    @PostConstruct
    public void init() {
    	try {
    		
    		this.listaComidas = comidaFacade.findAll();
			
		} catch (Exception e) {
			System.out.println("Error lista comidas " + e);
		}
    	
    }

	public ComidaFacade getComidaFacade() {
		return comidaFacade;
	}

	public void setComidaFacade(ComidaFacade comidaFacade) {
		this.comidaFacade = comidaFacade;
	}

	public PedidoFacade getPedidoFacade() {
		return pedidoFacade;
	}

	public void setPedidoFacade(PedidoFacade pedidoFacade) {
		this.pedidoFacade = pedidoFacade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public List<Comida> getListaComidas() {
		return listaComidas;
	}

	public void setListaComidas(List<Comida> listaComidas) {
		this.listaComidas = listaComidas;
	}

    
  
    public void guardarDatos() {
    	Comida comida = new Comida();
    	comida.setCodigo(this.codigo);
    	comida.setNombre(this.nombre);
    	comida.setPrecioUnitario(this.precioUnitario);
    	
    	comidaFacade.create(comida);
    	this.listaComidas = comidaFacade.findAll();
    }
    
    public String delete(Comida c) {
    	this.comidaFacade.remove(c);
    	this.listaComidas = comidaFacade.findAll();
    	return null;
    }
    
    public String edit(Comida c) {
    	c.setEditable(true);
    	return null;
    }
    
    public String save(Comida c) {
    	comidaFacade.edit(c);
    	c.setEditable(false);
    	this.listaComidas = comidaFacade.findAll();
    	return null;
    	

    }
    
    public void buscarPorNombre() {
    	if (nombre != null) {
			this.listaComidas = comidaFacade.findByName(this.nombre);
		} else {
			this.listaComidas = this.comidaFacade.findAll();
		}
    }
}
