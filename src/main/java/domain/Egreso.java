package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Egreso {
	Documento documentoComercial;
	MedioDePago medioDePago;
	Proveedor proveedor;
	LocalDate fechaDeOperacion;
	Entidad destinatario;
	List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	private static final Integer CANTIDAD_PRESUPUESTOS_NECESARIOS = 2;
	List<Usuario> revisores;
	EstadoEgreso estadoValidacion;

	List<Item> listaDeItems = new ArrayList<Item>();

	public Egreso(Documento documentoComercial, MedioDePago medioDePago, Proveedor proveedor,
			LocalDate fechaDeOperacion, List<Item> listaDeItems, List<Usuario> listaDeRevisores) {
		this.documentoComercial = documentoComercial;
		this.medioDePago = medioDePago;
		this.proveedor = proveedor;
		this.fechaDeOperacion = fechaDeOperacion;
		this.listaDeItems = listaDeItems;
		this.revisores = listaDeRevisores;
		this.estadoValidacion = EstadoEgreso.SIN_VALIDAR;
	}

	List<Item> getListaDeItems() {
		return listaDeItems;
	}

	List<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	void cargarPresupuesto(String detalle, List<Item> listaDeItems) { 

		Presupuesto unPresupuesto = new Presupuesto(detalle, listaDeItems);
		presupuestos.add(unPresupuesto);
	}

	public double getMontoTotal() {
		return listaDeItems.stream().mapToDouble(item -> item.getMonto()).sum();
	}

	boolean esDe(Usuario unUsuario) {
		return revisores.contains(unUsuario);
	}

	void setEstadoValidacion(EstadoEgreso unEstado) {
		estadoValidacion = unEstado;
	}

	synchronized void enviarResultadoACadaUsuario() {
		revisores.forEach((unRevisor) -> {
			unRevisor.agrerarResultado(this);
		});
	}
	
	synchronized void agregarRevisor(Usuario unUsuario) {
		revisores.add(unUsuario);
	}

	public Boolean tenesLosPresupuestosSuficientes() {
		return CANTIDAD_PRESUPUESTOS_NECESARIOS == presupuestos.size();
	}
}
