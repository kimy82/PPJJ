package ca.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.Entitys.Images;
import ca.serveis.impl.ServiceImagesImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class ChangeUrlFotoAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceImagesImpl imageServ = new ServiceImagesImpl();
		String url = request.getParameter("url").toString();
		String id = request.getParameter("id").toString();
		String onn = request.getParameter("onn").toString();
		try {
			Images img = new Images();
			img.setId(Integer.parseInt(id));
			img.setImageUrl(url);
			img.setOnn(onn);
			imageServ.saveORUpdateImage(img);

		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward(Constants.FAILURE);
		}

		return mapping.findForward(Constants.SUCCESS);

	}
}
