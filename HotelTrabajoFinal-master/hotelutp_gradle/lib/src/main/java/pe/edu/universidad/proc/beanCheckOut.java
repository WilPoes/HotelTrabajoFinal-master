package pe.edu.universidad.proc;

import java.io.IOException;
import java.io.Serializable;
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
	private double montoTotal;

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
		//

		//
		setMontoTotal(monto);
		System.out.println("enruto, sumo y total :" + montoTotal);
		servicioGestorCheckOut.listarHabitacionPorReserva(idReserva);
	}

	public void listarServiciosPorReserva() throws IOException {
		//
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println(map.get("idReserva"));
		int idReserva = Integer.parseInt(map.get("idReserva"));
		this.setIdReserva(idReserva);
		//
		setServicioPorReserva(servicioGestorCarrito.ListarCarritoPorReserva(idReserva));
		//
		enrutarListarServiciosPorReserva();
	}

	// otros metodos
	public void enrutarListarServiciosPorReserva() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String url = externalContext.getRequestContextPath() + "/pages/checkout.xhtml";
		externalContext.redirect(url);
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

}
