package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reservas_servicios_adicionales database table.
 * 
 */
@Embeddable
public class ReservasServiciosAdicionalePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="reserva_id", insertable=false, updatable=false)
	private Integer reservaId;

	@Column(name="servicio_adicional_id", insertable=false, updatable=false)
	private Integer servicioAdicionalId;

	public ReservasServiciosAdicionalePK() {
	}
	public Integer getReservaId() {
		return this.reservaId;
	}
	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}
	public Integer getServicioAdicionalId() {
		return this.servicioAdicionalId;
	}
	public void setServicioAdicionalId(Integer servicioAdicionalId) {
		this.servicioAdicionalId = servicioAdicionalId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservasServiciosAdicionalePK)) {
			return false;
		}
		ReservasServiciosAdicionalePK castOther = (ReservasServiciosAdicionalePK)other;
		return 
			this.reservaId.equals(castOther.reservaId)
			&& this.servicioAdicionalId.equals(castOther.servicioAdicionalId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.reservaId.hashCode();
		hash = hash * prime + this.servicioAdicionalId.hashCode();
		
		return hash;
	}
}