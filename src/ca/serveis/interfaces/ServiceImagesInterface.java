package ca.serveis.interfaces;

import java.util.List;

import ca.Entitys.Images;

/**
 * Aquest session façade s'encarrega de fer les crides corresponents als
 * components de negoci i transformar les dades entre els dos models (negoci
 * <--> ws).
 * 
 * @author Pedro Bueno
 * 
 */
public interface ServiceImagesInterface {

	/**
	 * Lista las inspecciones consultadas
	 * 
	 * @return Lista de Inspecciones
	 * @throws Exception
	 */
	public String getUrlImage(Images image) throws Exception;

	public void saveORUpdateImage(Images image) throws Exception;
	
	public List getImages(String onn) throws Exception;
}
