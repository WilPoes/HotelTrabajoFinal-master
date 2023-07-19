package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservas_servicios_adicionales database table.
 * 
 */
@Entity
@Table(name="reservas_servicios_adicionales")
@NamedQuery(name="ReservasServiciosAdicionale.findAll", query="SELECT r FROM ReservasServiciosAdicionale r")
public class ReservasServiciosAdicionale implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservasServiciosAdicionalePK id;

	public ReservasServiciosAdicionale() {
	}

	public ReservasServiciosAdicionalePK getId() {
		return this.id;
	}

	public void setId(ReservasServiciosAdicionalePK id) {
		this.id = id;
	}

}