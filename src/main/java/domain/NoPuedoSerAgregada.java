package domain;

import javax.persistence.Entity;

@Entity
public class NoPuedoSerAgregada extends Funcionalidad {
	public void valida(Entidad unaEntidad, Operaciones miOperacion) {
		this.validacionAbstraida(miOperacion, Operaciones.ENTIDAD_SER_AGREGADO, "esta entidad base no permite ser agregada a una entidad juridica");
	}
}


//throw new NoPuedoSerAgregadoException("esta entidad base no permite ser agregada a una entidad juridica");
