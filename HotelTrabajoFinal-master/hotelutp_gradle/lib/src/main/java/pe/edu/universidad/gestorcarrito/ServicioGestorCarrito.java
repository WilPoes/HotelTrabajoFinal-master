package pe.edu.universidad.gestorcarrito;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.universidad.dto.DtoServiciosListar;
import pe.edu.universidad.dto.DtoServiciosListarPorReserva;
import pe.edu.universidad.entidades.Reserva;
import pe.edu.universidad.entidades.ReservasServiciosAdicionale;
import pe.edu.universidad.entidades.ServiciosAdicionale;

@Path("ServicioGestorCarrito")
@Stateless
@LocalBean
public class ServicioGestorCarrito {
	@PersistenceContext(unitName = "hotel_jpa")
	private EntityManager em;

	@GET
	@Path("listarServiciosAdicionales")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ServiciosAdicionale> listarServicio() {
		TypedQuery<ServiciosAdicionale> query = em.createQuery("SELECT s FROM ServiciosAdicionale s",
				ServiciosAdicionale.class);
		return query.getResultList();
	}

	@GET
	@Path("listarServiciosAdicionales")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<DtoServiciosListar> listarServiciosAdicionales() {
		List<DtoServiciosListar> dtoListaServicios = new ArrayList<DtoServiciosListar>();
		TypedQuery<ServiciosAdicionale> query = em.createQuery("SELECT s FROM ServiciosAdicionale s",
				ServiciosAdicionale.class);
		List<ServiciosAdicionale> list = query.getResultList();
		//
		for (ServiciosAdicionale obj : list) {
			DtoServiciosListar dto = new DtoServiciosListar();
			dto.setId(obj.getServicioAdicionalId());
			dto.setNombre(obj.getNombre());
			dto.setPrecio(obj.getPrecio().doubleValue());			
			dtoListaServicios.add(dto);
		}
		return dtoListaServicios;
	}

	@GET
	@Path("listarServiciosPorReserva")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<DtoServiciosListarPorReserva> ListarCarritoPorReserva(int idIngreso) {
		List<DtoServiciosListarPorReserva> dtoListarPedidoPorReserva = new ArrayList<DtoServiciosListarPorReserva>();
		TypedQuery<ServiciosAdicionale> query2 = em.createQuery(
				"SELECT s FROM Reserva r JOIN r.serviciosAdicionales s WHERE r.id = :id", ServiciosAdicionale.class);
		query2.setParameter("id", idIngreso);
		List<ServiciosAdicionale> list2 = query2.getResultList();
		for (ServiciosAdicionale obj2 : list2) {
			DtoServiciosListarPorReserva dto = new DtoServiciosListarPorReserva();
			dto.setId_servicio(obj2.getServicioAdicionalId());
			dto.setPrecio(obj2.getPrecio().doubleValue());
			dto.setNombre(obj2.getNombre());
			dtoListarPedidoPorReserva.add(dto);
		}
		return dtoListarPedidoPorReserva;
	}

	@POST
	@Path("agregarServicioAdicional")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarServicioAdicional(ReservasServiciosAdicionale serv, Reserva res) {
		em.persist(serv);
		em.merge(res);
	}
}
