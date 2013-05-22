package ca.serveis.impl;

import java.util.List;

import ca.BO.ObraBO;
import ca.Entitys.Obra;
import ca.serveis.interfaces.ServiceObrasInterface;

/**
 * Implementació de {@link MciSignaturaServiceFacade}.
 * @author Pedro Bueno <pedro.bueno@cast-info.es> face
 * @author Iván Ortiz <ivan.ortiz@cast-info.es>
 */
public class ServiceObraImpl implements ServiceObrasInterface {

	ObraBO obraBO = new ObraBO();
	
	public ServiceObraImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void saveORUpdateObra(Obra obra) throws Exception{
		
		 
		obraBO.saveORUpdateObra(obra);
		
		
	}
	public void UpdateObra(Obra obra) throws Exception{
		
		 
		obraBO.UpdateObra(obra);
		
		
	}
	
	public Integer maxIDObra() throws Exception{
		
		 
		return obraBO.maxIDObra();
		
		
	}
	
	public Obra getObra(int id) throws Exception{
		
		 
		return obraBO.getObraBO(id);
		
		
	}
	public List getObras() throws Exception{
		
		 
		return obraBO.getObrasBO();
		
		
	}
	public void deleteObra(Obra obra) throws Exception{
		obraBO.deleteObraBO(obra);
	}
	
}
