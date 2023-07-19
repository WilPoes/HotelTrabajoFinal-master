package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pago_id")
	private Integer pagoId;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	private BigDecimal monto;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="reserva_id")
	private Reserva reserva;

	public Pago() {
	}

	public Integer getPagoId() {
		return this.pagoId;
	}

	public void setPagoId(Integer pagoId) {
		this.pagoId = pagoId;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}