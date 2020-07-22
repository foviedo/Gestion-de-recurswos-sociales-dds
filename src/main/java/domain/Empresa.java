package domain;

import java.util.List;

public class Empresa extends Juridica {

	TipoEmpresa unTipo;

	Empresa(String razonSocial, String nombreFicticio, int cuit, String direccionPostal, int codInscripcion, TipoEmpresa unTipo) {
		super(razonSocial, nombreFicticio, cuit, direccionPostal, codInscripcion);
		this.unTipo = unTipo;
	}
	
	TipoEmpresa getTipoEmpresa(){
		return unTipo;
	}
	void setTipoEmpresa(TipoEmpresa untipo) {
		this.unTipo = untipo;
		
	}
}
