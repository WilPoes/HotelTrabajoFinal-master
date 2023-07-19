package pe.edu.universidad.gestorcheckout;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.universidad.dto.DtoCheckOutHabitacion;
import pe.edu.universidad.dto.DtoServiciosListarPorReserva;
import pe.edu.universidad.entidades.Habitacione;
import pe.edu.universidad.entidades.ServiciosAdicionale;

@Stateless
@LocalBean
public class ServicioGestorCheckOut {
	@PersistenceContext(unitName = "hotel_jpa")
	private EntityManager em;

	public ServicioGestorCheckOut() {
		// TODO Auto-generated constructor stub
	}

	public Habitacione buscarHabitacionPorId(int id) {
		return em.find(Habitacione.class, id);
	}

	@GET
	@Path("listarHabitacionPorReserva")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public DtoCheckOutHabitacion listarHabitacionPorReserva(int idReserva) {
		DtoCheckOutHabitacion dtoListarHabitacionPorReserva = new DtoCheckOutHabitacion();
		TypedQuery<Habitacione> query2 = em
				.createQuery("SELECT s FROM Reserva r JOIN r.habitacione s WHERE r.id = :id", Habitacione.class);
		query2.setParameter("id", idReserva);
		Habitacione obj = query2.getSingleResult();
		// List<ServiciosAdicionale> list2 = query2.getResultList();
		dtoListarHabitacionPorReserva.setId(obj.getHabitacionId());
		dtoListarHabitacionPorReserva.setPrecio(obj.getPrecio().doubleValue());
		System.out.println("perecio -> capturado " + obj.getPrecio().doubleValue());
		return dtoListarHabitacionPorReserva;
	}
}
