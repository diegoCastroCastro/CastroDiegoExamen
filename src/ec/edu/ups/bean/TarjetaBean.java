package ec.edu.ups.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.entidad.Tarjeta;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class TarjetaBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();

}
