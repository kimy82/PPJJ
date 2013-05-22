package ca.Actions;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.Entitys.Images;
import ca.Entitys.Noticia;
import ca.Entitys.Obra;
import ca.Entitys.Pdf;
import ca.forms.UpdateObraForm;
import ca.serveis.impl.ServiceObraImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class DeleteObraAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceObraImpl obraServ = new ServiceObraImpl(); 

	
		Obra obra = new Obra();
		try {
			System.out.println("action delete");
			int id = Integer.parseInt(request.getParameter("id"));
			obra = obraServ.getObra(id);
			obraServ.deleteObra(obra);
		}catch(Exception e2) {
			    System.out.println(stack2string(e2));
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
