package ca.Actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.serveis.impl.ServiceObraImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class PreObraModifAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceObraImpl obraServ = new ServiceObraImpl();
		try {
//			obra
			List obraList = obraServ.getObras();
			request.setAttribute("obraList", obraList);
			
	

		} catch (Exception e) {
			return mapping.findForward(Constants.FAILURE);
		}

		return mapping.findForward(Constants.SUCCESS);

	}
}
