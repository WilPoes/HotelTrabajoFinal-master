package pe.edu.universidad.dto;

import java.util.Date;
import pe.edu.universidad.entidades.Habitacione;

public class Dtonuevareserva {

	private String correoElectronico;
	private String estado;
	private Date fechaFin;
	private Date fechaInicio;
	private String nombreCliente;
	private Integer numeroAdultos;
	private Integer numeroNinos;
	private String telefono;
	private Habitacione habitacione;

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Integer getNumeroAdultos() {
		return numeroAdultos;
	}

	public void setNumeroAdultos(Integer numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}

	public Integer getNumeroNinos() {
		return numeroNinos;
	}

	public void setNumeroNinos(Integer numeroNinos) {
		this.numeroNinos = numeroNinos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Habitacione getHabitacione() {
		return habitacione;
	}

	public void setHabitacione(Habitacione habitacione) {
		this.habitacione = habitacione;
	}

}
