package ca.Actions;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.beans.SaveObraNewForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.Entitys.Images;
import ca.Entitys.Noticia;
import ca.Entitys.Obra;
import ca.Entitys.Pdf;
import ca.serveis.impl.ServiceObraImpl;
import ca.utils.Constants;

/**
 * @version 1.0
 * @author
 */
public class SaveNewObraAction extends Action

{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ServiceObraImpl obraServ = new ServiceObraImpl(); 
		SaveObraNewForm saveObraForm = (SaveObraNewForm) form;
		Set images = new HashSet();
		Set pdfList = new HashSet();
		Obra obra = new Obra();
		Set noticies = new HashSet();
		try {
			System.out.println("action save");
			String[] urls = saveObraForm.getUrl();
			String[] urlsnot = saveObraForm.getUrlnoticia();
			String[] txtca = saveObraForm.getTextca();
			String[] txtes = saveObraForm.getTextes();
			String[] txten = saveObraForm.getTexten();
			File[] planos = saveObraForm.getPlano();
			String[] pltxten = saveObraForm.getPlatexten();
			String[] pltxtes = saveObraForm.getPlatextes();
			String[] pltxtca = saveObraForm.getPlatextca();
			
			Integer idmax =obraServ.maxIDObra();
			obra.setTipusObra(saveObraForm.getObraRef());
			obra.setTitolMenu(saveObraForm.getTitolMenu());
			obra.setTitolPag(saveObraForm.getTitolPag());
			if(idmax==null)idmax=0;
			obra.setId(Integer.parseInt(idmax.toString())+1);

			//imatges
			int i=0;
			for(i=0;i<urls.length;i++){
				
			String url = urls[i].toString();
			Images image = new Images();
			image.setImageUrl(url);
			image.setOnn(saveObraForm.getObraRef());
			image.setObra(obra);
			images.add(image);
			
			}
			obra.setImages(images);
	
			//noticies
			int j=0;
			for(i=0;i<urlsnot.length;i++){
				
			String url = urlsnot[i].toString();
			if(url==null || url.equals("")) continue;
			Noticia noti = new Noticia();
			noti.setNoticiaUrl(url);
			noti.setObra(obra);
			noti.setNomCA(txtca[i].toString());
			noti.setNomEN(txten[i].toString());
			noti.setNomES(txtes[i].toString());
			noticies.add(noti);
			}
			obra.setNoticies(noticies);
			
			//pdf's
			if(planos!=null && planos.length != 0){
				int jj =0;
				for(jj=0 ; jj<planos.length; jj++){
					Pdf filePDF = new Pdf();
					File pl = planos[jj];
					System.out.println("name pdf......."+pl.getName());
					System.out.println("name pdf......."+pl.getAbsolutePath());
					System.out.println("name pdf......."+pl.getCanonicalPath());
					System.out.println("name pdf......."+pl.getAbsoluteFile().getAbsolutePath());
		
	
					//	filePDF.setData(pl.getAbsolutePath());
					    filePDF.setNomCA(pltxtca[jj]);
					    filePDF.setNomEN(pltxten[jj]);
					    filePDF.setNomES(pltxtes[jj]);
					    filePDF.setObra(obra);
					    filePDF.setNomPDF(pl.getName());
					    pdfList.add(filePDF);
				}
			}
			obra.setPdf(pdfList);
			
			System.out.println("action Obra plena");
			obraServ.saveORUpdateObra(obra);
			
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
