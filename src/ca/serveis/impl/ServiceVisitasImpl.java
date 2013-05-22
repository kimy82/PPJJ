package ca.serveis.impl;

import ca.BO.VisitasBO;
import ca.Entitys.Visitas;
import ca.serveis.interfaces.ServiceVisitasInterface;

/**
 * Implementació de {@link MciSignaturaServiceFacade}.
 * @author Pedro Bueno <pedro.bueno@cast-info.es> 
 * @author Iván Ortiz <ivan.ortiz@cast-info.es>
 */
public class ServiceVisitasImpl implements ServiceVisitasInterface {

	VisitasBO visitaBO = new VisitasBO();
	
	public ServiceVisitasImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void afegirVisita() throws Exception{
		
		Visitas visita = new Visitas();
		visita.setVisitaDate(new java.util.Date());
		visitaBO.saveVisitaBO(visita);
		
	}
	
	public int getNumVisitesAvui() throws Exception{
		
		return visitaBO.getNumVisitesAvuiBO();
	}
	
	public int getNumVisitesUltimMes() throws Exception{
		
		return visitaBO.getNumVisitesUltimMesBO();
	}
}
