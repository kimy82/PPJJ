package ca.Actions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.Entitys.Obra;
import ca.serveis.impl.ServiceObraImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class ObreObraAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceObraImpl obraSrv = new ServiceObraImpl(); 
		
		try {
			
			System.out.println("action obre obra");
			String idObra = request.getParameter("idObra").toString();
			Obra obra = obraSrv.getObra(Integer.parseInt(idObra));
			request.getSession().setAttribute("obra",obra);
			
			List obres = obraSrv.getObras();
			request.getSession().setAttribute("obres", obres);

			
		} catch (Exception e) {
			System.out.println(stack2string(e));
			return mapping.findForward(Constants.FAILURE);
		}

		return mapping.findForward(Constants.SUCCESS);

	}
	 public static String stack2string(Exception e) {
		  try {
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
		    return "------\r\n" + sw.toString() + "------\r\n";
		  }
		  catch(Exception e2) {
		    return "bad stack2string";
		  }

	 }
}
