package login.beans;

import java.io.File;

import org.apache.struts.action.ActionForm;



public class SaveObraNewForm extends ActionForm {

	private String obraRef;
	private String titolPag;
	private String titolMenu;
	private String[] url;
	private String[] urlnoticia;
	private String[] textca;
	private String[] textes;
	private String[] texten;
	private File[] plano;
	private String[] platextes;
	private String[] platexten;
	private String[] platextca;
	
	
	
	
	public File[] getPlano() {
		return plano;
	}
	public void setPlano(File[] plano) {
		this.plano = plano;
	}
	public String getObraRef() {
		return obraRef;
	}
	public void setObraRef(String obraRef) {
		this.obraRef = obraRef;
	}
	public String getTitolMenu() {
		return titolMenu;
	}
	public void setTitolMenu(String titolMenu) {
		this.titolMenu = titolMenu;
	}
	public String getTitolPag() {
		return titolPag;
	}
	public void setTitolPag(String titolPag) {
		this.titolPag = titolPag;
	}
	public String[] getUrl() {
		return url;
	}
	public void setUrl(String[] url) {
		this.url = url;
	}
	public String[] getUrlnoticia() {
		return urlnoticia;
	}
	public void setUrlnoticia(String[] urlnoticia) {
		this.urlnoticia = urlnoticia;
	}
	public String[] getTextca() {
		return textca;
	}
	public void setTextca(String[] textca) {
		this.textca = textca;
	}
	public String[] getTexten() {
		return texten;
	}
	public void setTexten(String[] texten) {
		this.texten = texten;
	}
	public String[] getTextes() {
		return textes;
	}
	public void setTextes(String[] textes) {
		this.textes = textes;
	}
	public String[] getPlatextca() {
		return platextca;
	}
	public void setPlatextca(String[] platextca) {
		this.platextca = platextca;
	}
	public String[] getPlatexten() {
		return platexten;
	}
	public void setPlatexten(String[] platexten) {
		this.platexten = platexten;
	}
	public String[] getPlatextes() {
		return platextes;
	}
	public void setPlatextes(String[] platextes) {
		this.platextes = platextes;
	}

	
	
	
}
