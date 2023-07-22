package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the registros_salida database table.
 * 
 */
@Entity
@Table(name="registros_salida")
@NamedQuery(name="RegistrosSalida.findAll", query="SELECT r FROM RegistrosSalida r")
public class RegistrosSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="registro_salida_id")
	private Integer registroSalidaId;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Column(name="monto_total")
	private BigDecimal montoTotal;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public RegistrosSalida() {
	}

	public Integer getRegistroSalidaId() {
		return this.registroSalidaId;
	}

	public void setRegistroSalidaId(Integer registroSalidaId) {
		this.registroSalidaId = registroSalidaId;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public BigDecimal getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}