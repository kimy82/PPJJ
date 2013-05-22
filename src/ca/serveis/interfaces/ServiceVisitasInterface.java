package ca.serveis.interfaces;


/**
 * Aquest session façade s'encarrega de fer les crides corresponents als
 * components de negoci i transformar les dades entre els dos models (negoci
 * <--> ws).
 * 
 * @author Pedro Bueno
 * 
 */
public interface ServiceVisitasInterface {

	/**
	 * Lista las inspecciones consultadas
	 * 
	 * @return Lista de Inspecciones
	 * @throws Exception
	 */
	public void afegirVisita()
			throws Exception;
}
