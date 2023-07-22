package pe.edu.universidad.dto;

import pe.edu.universidad.entidades.ReservasServiciosAdicionalePK;

public class DtoServiciosListarPorReserva {

	private ReservasServiciosAdicionalePK pk;
	private int id_servicio;
	private String nombre;
	private int cantidad;
	private double precio;

	public DtoServiciosListarPorReserva() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ReservasServiciosAdicionalePK getPk() {
		return pk;
	}

	public void setPk(ReservasServiciosAdicionalePK pk) {
		this.pk = pk;
	}

}
