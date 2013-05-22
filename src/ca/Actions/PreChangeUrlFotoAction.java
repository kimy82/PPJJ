package ca.Actions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class PreChangeUrlFotoAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String imgNum = request.getParameter("img").toString();
		String id = request.getParameter("id").toString();
		try {

			request.setAttribute("img", imgNum);
			request.setAttribute("id", id);

		} catch (Exception e) {
			return mapping.findForward(Constants.FAILURE);
		}

		return mapping.findForward(Constants.SUCCESS);

	}
}
