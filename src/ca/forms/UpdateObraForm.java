package ca.forms;

import java.io.File;

import org.apache.struts.action.ActionForm;



public class UpdateObraForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642302682358193105L;
	private String obraRef;
	private String titolpag;
	private String titolmenu;
	private String idObra;
	private String[] url;
	private String[] urlid;
	private String[] urlnoticia;
	private String[] urlidnoticia;
	private String[] textca;
	private String[] textes;
	private String[] texten;
	private File[] plano;
	private String[] platxtes;
	private String[] platxten;
	private String[] platxtca;
	private String[] planolid;
	
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
	public String getObraRef() {
		return obraRef;
	}
	public void setObraRef(String obraRef) {
		this.obraRef = obraRef;
	}
	
	public String getTitolpag() {
		return titolpag;
	}
	public void setTitolpag(String titolpag) {
		this.titolpag = titolpag;
	}
	public String[] getUrl() {
		return url;
	}
	public void setUrl(String[] url) {
		this.url = url;
	}
	public String getIdObra() {
		return idObra;
	}
	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}
	public String[] getUrlid() {
		return urlid;
	}
	public void setUrlid(String[] urlid) {
		this.urlid = urlid;
	}
	public void setTitolmenu(String titolmenu) {
		this.titolmenu = titolmenu;
	}
	public String getTitolmenu() {
		return titolmenu;
	}
	public String[] getUrlidnoticia() {
		return urlidnoticia;
	}
	public void setUrlidnoticia(String[] urlidnoticia) {
		this.urlidnoticia = urlidnoticia;
	}
	public String[] getUrlnoticia() {
		return urlnoticia;
	}
	public void setUrlnoticia(String[] urlnoticia) {
		this.urlnoticia = urlnoticia;
	}
	public File[] getPlano() {
		return plano;
	}
	public void setPlano(File[] plano) {
		this.plano = plano;
	}
	public String[] getPlanolid() {
		return planolid;
	}
	public void setPlanolid(String[] planolid) {
		this.planolid = planolid;
	}
	public String[] getPlatxtca() {
		return platxtca;
	}
	public void setPlatxtca(String[] platxtca) {
		this.platxtca = platxtca;
	}
	public String[] getPlatxten() {
		return platxten;
	}
	public void setPlatxten(String[] platxten) {
		this.platxten = platxten;
	}
	public String[] getPlatxtes() {
		return platxtes;
	}
	public void setPlatxtes(String[] platxtes) {
		this.platxtes = platxtes;
	}
	
	
	
	
}
