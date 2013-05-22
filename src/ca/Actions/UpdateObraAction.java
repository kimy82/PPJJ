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
public class UpdateObraAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceObraImpl obraServ = new ServiceObraImpl(); 
		UpdateObraForm saveObraForm = (UpdateObraForm) form;
		Set images = new HashSet();
		Set pdflist = new HashSet();
		Set noticies = new HashSet();
		Obra obra = new Obra();
		try {
			System.out.println("action update");
			String[] urls = saveObraForm.getUrl();
			String[] urlids = saveObraForm.getUrlid();
			String[] urlsnoticies = saveObraForm.getUrlnoticia();
			String[] nomsca = saveObraForm.getTextca();
			String[] nomses = saveObraForm.getTextes();
			String[] nomsen = saveObraForm.getTexten();
			String[] idnot = saveObraForm.getUrlidnoticia();
			File[] planos = saveObraForm.getPlano();
			String[] pltxten = saveObraForm.getPlatxten();
			String[] pltxtes = saveObraForm.getPlatxtes();
			String[] pltxtca = saveObraForm.getPlatxtca();
			String[] idplanols = saveObraForm.getPlanolid();
			
			obra.setTipusObra(saveObraForm.getObraRef());
			obra.setTitolMenu(saveObraForm.getTitolmenu());
			obra.setTitolPag(saveObraForm.getTitolpag());
			obra.setId(Integer.parseInt(saveObraForm.getIdObra()));
			
			System.out.println("plessss"+saveObraForm.getTitolpag());
			int i=0;
			//imatges
			if(urls!=null){
			for(i=0;i<urls.length;i++){
				
				String url = urls[i].toString();
				Images image = new Images();
				System.out.println("urlImage"+url);
				image.setImageUrl(url);
				if(urlids!=null && urlids.length >i && urlids[i]!=null){
					image.setId(Integer.parseInt(urlids[i].toString()));
				}
				image.setOnn(saveObraForm.getObraRef());
				image.setObra(obra);
				images.add(image);
			
			}
			
			obra.setImages(images);
			}
			//System.out.println("plessss"+urls.length);
			if(urlsnoticies!=null){
			for(i=0;i<urlsnoticies.length;i++){
				String urlnot = urlsnoticies[i].toString();
				Noticia not = new Noticia();
				not.setNoticiaUrl(urlnot);
				String ca = nomsca[i].toString();
				String es = nomses[i].toString();
				String en = nomsen[i].toString();
				not.setNomCA(ca);
				not.setNomES(es);
				not.setNomEN(en);
				not.setObra(obra);
				if(idnot.length >i && idnot[i]!=null && !idnot[i].toString().equals("")){
				not.setId(Integer.parseInt(idnot[i].toString()));
				}
				noticies.add(not);
			}
			obra.setNoticies(noticies);
			}
			//pdfs
		
		
			if(planos!=null){
				System.out.println("Hi ha planols");
			for(i=0;i<planos.length;i++){
				String urlpl = planos[i].getAbsolutePath().toString();
				Pdf pdf = new Pdf();
				//TODO: duardar els pdf en base de dades
				pdf.setData("pooo");
				System.out.println("eeee-...."+pltxtca.length);
				String ca = pltxtca[i].toString();
				String es = pltxtes[i].toString();
				String en = pltxten[i].toString();
				pdf.setNomCA(ca);
				pdf.setNomES(es);
				pdf.setNomEN(en);
				pdf.setNomPDF(planos[i].getName());
				pdf.setObra(obra);
				if(idplanols !=null && idplanols.length >i && idplanols[i]!=null && !idplanols[i].toString().equals("")){
				pdf.setId(Integer.parseInt(idplanols[i].toString()));
				}
				pdflist.add(pdf);
			}
			obra.setPdf(pdflist);
			}
			
			System.out.println("action Obra plena");
			obraServ.UpdateObra(obra);
			
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
