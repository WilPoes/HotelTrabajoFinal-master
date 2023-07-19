package pe.edu.universidad.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name = "reservas")
@NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "reserva_id")
	private Integer reservaId;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "nombre_cliente")
	private String nombreCliente;

	@Column(name = "numero_adultos")
	private Integer numeroAdultos;

	@Column(name = "numero_ninos")
	private Integer numeroNinos;

	private String telefono;

	// bi-directional many-to-one association to Confirmacione
	@OneToMany(mappedBy = "reserva")
	private List<Confirmacione> confirmaciones;

	// bi-directional many-to-one association to ModificacionesCancelacione
	@OneToMany(mappedBy = "reserva")
	private List<ModificacionesCancelacione> modificacionesCancelaciones;

	// bi-directional many-to-one association to Pago
	@OneToMany(mappedBy = "reserva")
	private List<Pago> pagos;

	// bi-directional many-to-one association to RegistrosLlegada
	@OneToMany(mappedBy = "reserva")
	private List<RegistrosLlegada> registrosLlegadas;

	// bi-directional many-to-one association to RegistrosSalida
	@OneToMany(mappedBy = "reserva")
	private List<RegistrosSalida> registrosSalidas;

	// bi-directional many-to-one association to Habitacione
	@ManyToOne
	@JoinColumn(name = "habitacion_id")
	private Habitacione habitacione;

	// bi-directional many-to-many association to ServiciosAdicionale
	@ManyToMany
	@JoinTable(name = "reservas_servicios_adicionales", joinColumns = {
			@JoinColumn(name = "reserva_id") }, inverseJoinColumns = { @JoinColumn(name = "servicio_adicional_id") })
	private List<ServiciosAdicionale> serviciosAdicionales;

	public Reserva() {
	}

	public Integer getReservaId() {
		return this.reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getNumeroAdultos() {
		return this.numeroAdultos;
	}

	public void setNumeroAdultos(Integer numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}

	public Integer getNumeroNinos() {
		return this.numeroNinos;
	}

	public void setNumeroNinos(Integer numeroNinos) {
		this.numeroNinos = numeroNinos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Confirmacione> getConfirmaciones() {
		return this.confirmaciones;
	}

	public void setConfirmaciones(List<Confirmacione> confirmaciones) {
		this.confirmaciones = confirmaciones;
	}

	public Confirmacione addConfirmacione(Confirmacione confirmacione) {
		getConfirmaciones().add(confirmacione);
		confirmacione.setReserva(this);

		return confirmacione;
	}

	public Confirmacione removeConfirmacione(Confirmacione confirmacione) {
		getConfirmaciones().remove(confirmacione);
		confirmacione.setReserva(null);

		return confirmacione;
	}

	public List<ModificacionesCancelacione> getModificacionesCancelaciones() {
		return this.modificacionesCancelaciones;
	}

	public void setModificacionesCancelaciones(List<ModificacionesCancelacione> modificacionesCancelaciones) {
		this.modificacionesCancelaciones = modificacionesCancelaciones;
	}

	public ModificacionesCancelacione addModificacionesCancelacione(
			ModificacionesCancelacione modificacionesCancelacione) {
		getModificacionesCancelaciones().add(modificacionesCancelacione);
		modificacionesCancelacione.setReserva(this);

		return modificacionesCancelacione;
	}

	public ModificacionesCancelacione removeModificacionesCancelacione(
			ModificacionesCancelacione modificacionesCancelacione) {
		getModificacionesCancelaciones().remove(modificacionesCancelacione);
		modificacionesCancelacione.setReserva(null);

		return modificacionesCancelacione;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setReserva(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setReserva(null);

		return pago;
	}

	public List<RegistrosLlegada> getRegistrosLlegadas() {
		return this.registrosLlegadas;
	}

	public void setRegistrosLlegadas(List<RegistrosLlegada> registrosLlegadas) {
		this.registrosLlegadas = registrosLlegadas;
	}

	public RegistrosLlegada addRegistrosLlegada(RegistrosLlegada registrosLlegada) {
		getRegistrosLlegadas().add(registrosLlegada);
		registrosLlegada.setReserva(this);

		return registrosLlegada;
	}

	public RegistrosLlegada removeRegistrosLlegada(RegistrosLlegada registrosLlegada) {
		getRegistrosLlegadas().remove(registrosLlegada);
		registrosLlegada.setReserva(null);

		return registrosLlegada;
	}

	public List<RegistrosSalida> getRegistrosSalidas() {
		return this.registrosSalidas;
	}

	public void setRegistrosSalidas(List<RegistrosSalida> registrosSalidas) {
		this.registrosSalidas = registrosSalidas;
	}

	public RegistrosSalida addRegistrosSalida(RegistrosSalida registrosSalida) {
		getRegistrosSalidas().add(registrosSalida);
		registrosSalida.setReserva(this);

		return registrosSalida;
	}

	public RegistrosSalida removeRegistrosSalida(RegistrosSalida registrosSalida) {
		getRegistrosSalidas().remove(registrosSalida);
		registrosSalida.setReserva(null);

		return registrosSalida;
	}

	public Habitacione getHabitacione() {
		return this.habitacione;
	}

	public void setHabitacione(Habitacione habitacione) {
		this.habitacione = habitacione;
	}

	public List<ServiciosAdicionale> getServiciosAdicionales() {
		return this.serviciosAdicionales;
	}

	public void setServiciosAdicionales(List<ServiciosAdicionale> serviciosAdicionales) {
		this.serviciosAdicionales = serviciosAdicionales;
	}

}