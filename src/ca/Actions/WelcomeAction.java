package ca.Actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class WelcomeAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			ServiceImagesImpl imgSrv = new ServiceImagesImpl();
			ServiceObraImpl obraSrv = new ServiceObraImpl();
		try {

				//Recuperem imatges
				List images = imgSrv.getImages("principals");
				request.getSession().setAttribute("images", images);
				
				List obres = obraSrv.getObras();
				request.getSession().setAttribute("obres", obres);

		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward(Constants.FAILURE);
		}

		return mapping.findForward(Constants.SUCCESS);

	}
}
