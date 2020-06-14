package domain;

public class ValidarCompraEnBaseAPresupuesto implements Validacion {
	
	public boolean validar(Egreso unEgreso) {
		
		return unEgreso.getPresupuestos().stream().anyMatch(unPresupuesto -> unEgreso.getListaDeItems().equals(unPresupuesto.getListaItems())); // Se puede delegar
	}

}
