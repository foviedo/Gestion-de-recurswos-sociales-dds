package domain;

import java.util.List;

public class OSC extends Juridica {

	OSC(String razonSocial, String nombreFicticio, int cuit, String direccionPostal, int codInscripcion,List<Base> listaDeEntidades) {
		super(razonSocial, nombreFicticio, cuit, direccionPostal, codInscripcion,listaDeEntidades);
	}

}
