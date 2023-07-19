package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the servicios_adicionales database table.
 * 
 */
@Entity
@Table(name="servicios_adicionales")
@NamedQuery(name="ServiciosAdicionale.findAll", query="SELECT s FROM ServiciosAdicionale s")
public class ServiciosAdicionale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="servicio_adicional_id")
	private Integer servicioAdicionalId;

	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-many association to Reserva
	@ManyToMany(mappedBy="serviciosAdicionales")
	private List<Reserva> reservas;

	public ServiciosAdicionale() {
	}

	public Integer getServicioAdicionalId() {
		return this.servicioAdicionalId;
	}

	public void setServicioAdicionalId(Integer servicioAdicionalId) {
		this.servicioAdicionalId = servicioAdicionalId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}