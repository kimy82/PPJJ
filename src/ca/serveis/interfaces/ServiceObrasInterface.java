package ca.serveis.interfaces;

import java.util.List;

import ca.Entitys.Obra;

/**
 * Aquest session façade s'encarrega de fer les crides corresponents als
 * components de negoci i transformar les dades entre els dos models (negoci
 * <--> ws).
 * 
 * @author Pedro Bueno
 * 
 */
public interface ServiceObrasInterface {

	/**
	 * Lista las inspecciones consultadas
	 * 
	 * @return Lista de Inspecciones
	 * @throws Exception
	 */
	

	public void saveORUpdateObra(Obra obra) throws Exception;
	public void UpdateObra(Obra obra) throws Exception;
	public Integer maxIDObra() throws Exception;
	public Obra getObra(int id) throws Exception;
	public List getObras() throws Exception;
	public void deleteObra(Obra obra) throws Exception;
	
}
