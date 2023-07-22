package pe.edu.universidad.dto;

import java.util.Date;

public class DtoRegistrarSalida {
	int id;
	double montoFinal;
	Date hoy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(double montoFinal) {
		this.montoFinal = montoFinal;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

}
