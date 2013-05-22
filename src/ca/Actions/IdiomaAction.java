package ca.Actions;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.serveis.impl.ServiceImagesImpl;
import ca.serveis.impl.ServiceObraImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class IdiomaAction extends Action

{
	
	ServiceImagesImpl imgSrv = new ServiceImagesImpl();
	ServiceObraImpl obraSrv = new ServiceObraImpl();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String idioma = request.getParameter("idioma").toString();
		request.getSession().setAttribute("idioma", idioma);
		Locale locale1;
		try {
			if (idioma.equals("CA")) {
				 locale1 = new Locale("es", "CA");
				Locale.setDefault(locale1);
			} else if (idioma.equals("ES")) {
				 locale1 = new Locale("es", "E");
				Locale.setDefault(locale1);
			} else if (idioma.endsWith("EN")) {
				 locale1 = new Locale("en", "EN");
				Locale.setDefault(locale1);
			} else {
				// to-do informar log
				 locale1 = Locale.getDefault();
			}
			request.getSession().setAttribute(Globals.LOCALE_KEY,locale1); 
			//Recuperem imatges
			List images = imgSrv.getImages("principals");
			request.getSession().setAttribute("images", images);
			
			List obres = obraSrv.getObras();
			request.getSession().setAttribute("obres", obres);
			System.out.println("OBRESSSSSS....."+obres);
			System.out.println("obres size....."+obres.size());

		} catch (Exception e) {
			return  mapping.findForward(Constants.FAILURE);
		}

		return  mapping.findForward(Constants.SUCCESS);

	}
}
