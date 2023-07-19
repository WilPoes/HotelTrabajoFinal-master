package pe.edu.universidad.proc;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.entidades.Habitacione;
import pe.edu.universidad.gestorreaservas.ServicioGestorReservas;

@Named
@SessionScoped
public class beanHabitacion implements Serializable {
	@Inject
	private ServicioGestorReservas servicioGestorReserva;

	private static final long serialVersionUID = 1L;
	private List<Habitacione> habitaciones;
	private Habitacione habitacionSeleccionada;
	private int habitacionId;

	@PostConstruct
	public void iniciarListaHabitaciones() {
		setHabitaciones(servicioGestorReserva.listarHabitaciones());
	}

	public List<Habitacione> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacione> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Habitacione getHabitacionSeleccionada() {
		return habitacionSeleccionada;
	}

	public void setHabitacionSeleccionada(Habitacione habitacionSeleccionada) {
		this.habitacionSeleccionada = habitacionSeleccionada;
	}

}
