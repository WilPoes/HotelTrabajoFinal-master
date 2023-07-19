package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the confirmaciones database table.
 * 
 */
@Entity
@Table(name="confirmaciones")
@NamedQuery(name="Confirmacione.findAll", query="SELECT c FROM Confirmacione c")
public class Confirmacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="confirmacion_id")
	private Integer confirmacionId;

	@Column(name="estado_confirmacion")
	private String estadoConfirmacion;

	@Column(name="fecha_confirmacion")
	private Timestamp fechaConfirmacion;

	@Column(name="numero_confirmacion")
	private String numeroConfirmacion;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public Confirmacione() {
	}

	public Integer getConfirmacionId() {
		return this.confirmacionId;
	}

	public void setConfirmacionId(Integer confirmacionId) {
		this.confirmacionId = confirmacionId;
	}

	public String getEstadoConfirmacion() {
		return this.estadoConfirmacion;
	}

	public void setEstadoConfirmacion(String estadoConfirmacion) {
		this.estadoConfirmacion = estadoConfirmacion;
	}

	public Timestamp getFechaConfirmacion() {
		return this.fechaConfirmacion;
	}

	public void setFechaConfirmacion(Timestamp fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	public String getNumeroConfirmacion() {
		return this.numeroConfirmacion;
	}

	public void setNumeroConfirmacion(String numeroConfirmacion) {
		this.numeroConfirmacion = numeroConfirmacion;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}