package pe.edu.universidad.proc;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.universidad.dto.DtoServiciosListarPorReserva;
import pe.edu.universidad.entidades.Habitacione;
import pe.edu.universidad.entidades.RegistrosSalida;
import pe.edu.universidad.entidades.Reserva;
import pe.edu.universidad.entidades.ServiciosAdicionale;
import pe.edu.universidad.gestorcarrito.ServicioGestorCarrito;
import pe.edu.universidad.gestorcheckout.ServicioGestorCheckOut;

@Named
@SessionScoped
public class beanCheckOut implements Serializable {
	@PersistenceContext(unitName = "hotel_jpa")
	private EntityManager em;

	@Inject
	private ServicioGestorCarrito servicioGestorCarrito;

	@Inject
	private ServicioGestorCheckOut servicioGestorCheckOut;

	private static final long serialVersionUID = 1L;
	private List<ServiciosAdicionale> carrito;
	private List<DtoServiciosListarPorReserva> servicioPorReserva;
	private Habitacione habitacion;
	private DtoServiciosListarPorReserva dtoServicioListarPorReserva;
	// private List<DtoServiciosListarPorReserva> servicioPorReserva;
	private int idReserva;
	private double montoServicios;
	private double montoTotal;
	private double montoHabitacion;

	public void modificarRegistro() {
		System.out.println("esta checkouteando");
		double monto = 0;
		//
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println("apra el checkout:" + map.get("idReserva"));
		int idReserva = Integer.parseInt(map.get("idReserva"));
		setServicioPorReserva(servicioGestorCarrito.ListarCarritoPorReserva(idReserva));
		//
		this.setIdReserva(idReserva);
		//
		for (int i = 0; i < getServicioPorReserva().size(); i++) {
			monto += getServicioPorReserva().get(i).getPrecio();
		}
		// AGREGO EL MONTO A LA TABLA
		setMontoTotal(servicioGestorCheckOut.calcularTotal(idReserva, monto));
		// FECHA ACTUAL
		Date fechaHoy = new Date();
		RegistrosSalida salida = new RegistrosSalida();
		//
		salida.setFechaSalida(fechaHoy);
		BigDecimal montoBig = BigDecimal.valueOf(montoTotal);
		salida.setMontoTotal(montoBig);
		//
		Reserva reserva = em.find(Reserva.class, idReserva);
		reserva.setEstado("Terminado");
		salida.setReserva(reserva);
		//
		servicioGestorCheckOut.guardarSalida(salida, reserva);
	}

	public void listarServiciosPorReserva() throws IOException {
		//
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int idReserva = Integer.parseInt(map.get("idReserva"));
		this.setIdReserva(idReserva);
		//
		setServicioPorReserva(servicioGestorCarrito.ListarCarritoPorReserva(idReserva));
		//
		double monto = 0;
		//
		this.setIdReserva(idReserva);
		//
		for (int i = 0; i < getServicioPorReserva().size(); i++) {
			monto += getServicioPorReserva().get(i).getPrecio();
		}
		// AGREGO EL MONTO A LA TABLA
		setMontoTotal(servicioGestorCheckOut.calcularTotal(idReserva, monto));
		setMontoServicios(monto);
		setMontoHabitacion(montoTotal - montoServicios);
		llenarMontoTotal(idReserva, monto);
		//MODIFICAR LA TABLA HABITACION
		
		//
		enrutarListarServiciosPorReserva();
	}

	// otros metodos
	public void enrutarListarServiciosPorReserva() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String url = externalContext.getRequestContextPath() + "/pages/checkout.xhtml";
		externalContext.redirect(url);
	}

	public void llenarMontoTotal(int idReserva, double montoInicial) {
		setMontoTotal(servicioGestorCheckOut.calcularTotal(idReserva, montoInicial));
	}

	// getters & setters
	public List<ServiciosAdicionale> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ServiciosAdicionale> carrito) {
		this.carrito = carrito;
	}

	public List<DtoServiciosListarPorReserva> getServicioPorReserva() {
		return servicioPorReserva;
	}

	public void setServicioPorReserva(List<DtoServiciosListarPorReserva> servicioPorReserva) {
		this.servicioPorReserva = servicioPorReserva;
	}

	public DtoServiciosListarPorReserva getDtoServicioListarPorReserva() {
		return dtoServicioListarPorReserva;
	}

	public void setDtoServicioListarPorReserva(DtoServiciosListarPorReserva dtoServicioListarPorReserva) {
		this.dtoServicioListarPorReserva = dtoServicioListarPorReserva;
	}

	public Habitacione getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacione habitacion) {
		this.habitacion = habitacion;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public double getMontoServicios() {
		return montoServicios;
	}

	public void setMontoServicios(double montoServicios) {
		this.montoServicios = montoServicios;
	}

	public double getMontoHabitacion() {
		return montoHabitacion;
	}

	public void setMontoHabitacion(double montoHabitacion) {
		this.montoHabitacion = montoHabitacion;
	}
}