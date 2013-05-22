package login.Actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.beans.LoginForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.Entitys.*;
import ca.serveis.impl.ServiceImagesImpl;
import ca.serveis.impl.ServiceObraImpl;
import ca.serveis.impl.ServiceVisitasImpl;

public class LoginAction extends org.apache.struts.action.Action {

	private final static String SUCCESS = "success";

	private final static String FAILURE = "failure";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginForm loginForm = (LoginForm) form;

		if (loginForm.getUserName().equals("jorra") && loginForm.getPassword().equals("jorraweb78")) {

			ServiceVisitasImpl visitServ = new ServiceVisitasImpl();
			ServiceImagesImpl imageServ = new ServiceImagesImpl();
			
			// numero de visites de lúltim mes
			request.setAttribute("NumVisitsLastMonth",
					"Numero visites ultim mes: "
							+ visitServ.getNumVisitesUltimMes());

			// numero de visites d'avui
			request.setAttribute("NumVisitsAvui", "Numero visites d avui: "
					+ visitServ.getNumVisitesAvui());
			
			//Recuperem imatges
			List images = imageServ.getImages("principals");
			request.getSession().setAttribute("images", images);			
			request.getSession().setAttribute("admin", "yes");

			
			return mapping.findForward(SUCCESS);

		} else {

			return mapping.findForward(FAILURE);

		}
	}
}