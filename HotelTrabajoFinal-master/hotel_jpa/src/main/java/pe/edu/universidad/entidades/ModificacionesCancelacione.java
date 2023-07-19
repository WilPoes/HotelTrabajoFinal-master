package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the modificaciones_cancelaciones database table.
 * 
 */
@Entity
@Table(name="modificaciones_cancelaciones")
@NamedQuery(name="ModificacionesCancelacione.findAll", query="SELECT m FROM ModificacionesCancelacione m")
public class ModificacionesCancelacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="modificacion_cancelacion_id")
	private Integer modificacionCancelacionId;

	@Column(name="costo_adicional")
	private BigDecimal costoAdicional;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String motivo;

	@Column(name="tipo_modificacion")
	private String tipoModificacion;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public ModificacionesCancelacione() {
	}

	public Integer getModificacionCancelacionId() {
		return this.modificacionCancelacionId;
	}

	public void setModificacionCancelacionId(Integer modificacionCancelacionId) {
		this.modificacionCancelacionId = modificacionCancelacionId;
	}

	public BigDecimal getCostoAdicional() {
		return this.costoAdicional;
	}

	public void setCostoAdicional(BigDecimal costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoModificacion() {
		return this.tipoModificacion;
	}

	public void setTipoModificacion(String tipoModificacion) {
		this.tipoModificacion = tipoModificacion;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}