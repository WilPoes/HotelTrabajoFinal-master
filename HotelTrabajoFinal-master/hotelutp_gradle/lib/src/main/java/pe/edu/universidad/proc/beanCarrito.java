package pe.edu.universidad.proc;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.universidad.dto.DtoServiciosListar;
import pe.edu.universidad.dto.DtoServiciosListarPorReserva;
import pe.edu.universidad.entidades.Reserva;
import pe.edu.universidad.entidades.ReservasServiciosAdicionale;
import pe.edu.universidad.entidades.ReservasServiciosAdicionalePK;
import pe.edu.universidad.entidades.ServiciosAdicionale;
import pe.edu.universidad.gestorcarrito.ServicioGestorCarrito;
import pe.edu.universidad.gestorreaservas.ServicioGestorReservas;

@Named
@SessionScoped
public class beanCarrito implements Serializable {
	@PersistenceContext(unitName = "hotel_jpa")
	private EntityManager em;

	@Inject
	private ServicioGestorReservas servicioGestorReserva;

	@Inject
	private ServicioGestorCarrito servicioGestorCarrito;

	private static final long serialVersionUID = 1L;
	private List<ServiciosAdicionale> carrito;
	private List<DtoServiciosListarPorReserva> servicioPorReserva;
	private List<DtoServiciosListar> servicioAdicionale;
	private DtoServiciosListarPorReserva dtoServicioListarPorReserva;
	// private List<DtoServiciosListarPorReserva> servicioPorReserva;
	private int idReserva;

	@PostConstruct
	public void iniciarCarrito() {
		setCarrito(servicioGestorReserva.listarServicios());
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

	public void guardarServicio() throws IOException {
		// idReserva
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		System.out.println("idreserva desde->" + map.get("idReserva"));
		int idReserva = Integer.parseInt(map.get("idReserva"));
		// "idServicio"
		int servicioAdicionalId = Integer.parseInt(map.get("idServicio"));
		//
		Reserva reserva = em.find(Reserva.class, idReserva);
		ServiciosAdicionale servicioAdicional = em.find(ServiciosAdicionale.class, servicioAdicionalId);
		//
		ReservasServiciosAdicionale reservasServiciosAdicionale = new ReservasServiciosAdicionale();
		ReservasServiciosAdicionalePK pk = new ReservasServiciosAdicionalePK();
		pk.setReservaId(idReserva);
		pk.setServicioAdicionalId(servicioAdicionalId);
		reservasServiciosAdicionale.setId(pk);
		//
		servicioGestorCarrito.guardarServicioAdicional(reservasServiciosAdicionale, reserva);
		//
		listarServiciosPorReserva(idReserva);
	}

	// otros metodos
	public void enrutarListarServiciosPorReserva() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String url = externalContext.getRequestContextPath() + "/pages/carritoPedidos.xhtml";
		externalContext.redirect(url);
	}

	public void listarServiciosPorReserva(int idReserva) throws IOException {
		//
		System.out.println("**" + idReserva);
		setServicioPorReserva(servicioGestorCarrito.ListarCarritoPorReserva(idReserva));
		for (DtoServiciosListarPorReserva serviciosAdicionale : servicioPorReserva) {
			System.out.println("bean" + serviciosAdicionale.getPrecio());
		}
		//
		enrutarListarServiciosPorReserva();
	}

	// getters & setters
	public List<ServiciosAdicionale> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ServiciosAdicionale> carrito) {
		this.carrito = carrito;
	}

	public List<DtoServiciosListar> getServicioAdicionale() {
		return servicioAdicionale;
	}

	public void setServicioAdicionale(List<DtoServiciosListar> servicioAdicionale) {
		this.servicioAdicionale = servicioAdicionale;
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

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

}
