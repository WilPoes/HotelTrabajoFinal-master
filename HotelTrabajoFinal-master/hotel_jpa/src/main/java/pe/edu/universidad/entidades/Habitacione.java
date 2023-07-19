package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the habitaciones database table.
 * 
 */
@Entity
@Table(name="habitaciones")
@NamedQuery(name="Habitacione.findAll", query="SELECT h FROM Habitacione h")
public class Habitacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="habitacion_id")
	private Integer habitacionId;

	private String descripcion;

	private Integer disponibilidad;

	@Column(name="imagen_url")
	private String imagenUrl;

	private BigDecimal precio;

	private String tipo;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="habitacione")
	private List<Reserva> reservas;

	public Habitacione() {
	}

	public Integer getHabitacionId() {
		return this.habitacionId;
	}

	public void setHabitacionId(Integer habitacionId) {
		this.habitacionId = habitacionId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getImagenUrl() {
		return this.imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHabitacione(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHabitacione(null);

		return reserva;
	}

}