package domain;

import javax.persistence.Entity;

@Entity
public class NoPuedoAgregarEntidadesBase extends Funcionalidad{
	public void valida(Entidad unaEntidad, Operaciones miOperacion) {
		this.validacionAbstraida(miOperacion, Operaciones.AGREGAR_ENTIDAD, "no puedo agregar entidades base nuevas");
	}
}
