package ca.serveis.impl;

import java.util.LinkedList;
import java.util.List;

import ca.BO.ImagesBO;
import ca.Entitys.Images;
import ca.serveis.interfaces.ServiceImagesInterface;

/**
 * Implementació de {@link MciSignaturaServiceFacade}.
 * @author Pedro Bueno <pedro.bueno@cast-info.es> face
 * @author Iván Ortiz <ivan.ortiz@cast-info.es>
 */
public class ServiceImagesImpl implements ServiceImagesInterface {

	ImagesBO imagesBO = new ImagesBO();
	
	public ServiceImagesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getUrlImage(Images image) throws Exception{
		
		image =imagesBO.getUrlImageBO(image);
		
		return image.getImageUrl();
	}
	
	public List getImages(String onn) throws Exception{
		
		 
		List images =imagesBO.getImagesBO(onn);
		
		return images;
	}
	public void saveORUpdateImage(Images img) throws Exception{
		
		 
		imagesBO.saveORUpdateImage(img);
		
		
	}
	
}
