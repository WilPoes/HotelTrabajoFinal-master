package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the registros_llegada database table.
 * 
 */
@Entity
@Table(name="registros_llegada")
@NamedQuery(name="RegistrosLlegada.findAll", query="SELECT r FROM RegistrosLlegada r")
public class RegistrosLlegada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="registro_llegada_id")
	private Integer registroLlegadaId;

	@Column(name="fecha_llegada")
	private Timestamp fechaLlegada;

	@Column(name="numero_personas")
	private Integer numeroPersonas;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public RegistrosLlegada() {
	}

	public Integer getRegistroLlegadaId() {
		return this.registroLlegadaId;
	}

	public void setRegistroLlegadaId(Integer registroLlegadaId) {
		this.registroLlegadaId = registroLlegadaId;
	}

	public Timestamp getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Timestamp fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Integer getNumeroPersonas() {
		return this.numeroPersonas;
	}

	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}