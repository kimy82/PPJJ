package ca.Entitys;

import java.util.Set;

public class Obra implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1492312563578830683L;

	private  Set images;
	
	private  Set noticies;
	
	private  Set pdf;

	private int id;
	
	private String TitolPag;
	
	private String TitolMenu;
	
	private String TipusObra;	

	//	 Geters i setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set getImages() {
		return images;
	}

	public void setImages(Set images) {
		this.images = images;
	}

	public String getTitolMenu() {
		return TitolMenu;
	}

	public void setTitolMenu(String titolMenu) {
		TitolMenu = titolMenu;
	}

	public String getTitolPag() {
		return TitolPag;
	}

	public void setTitolPag(String titolPag) {
		TitolPag = titolPag;
	}

	public String getTipusObra() {
		return TipusObra;
	}

	public void setTipusObra(String tipusObra) {
		TipusObra = tipusObra;
	}

	public Set getNoticies() {
		return noticies;
	}

	public void setNoticies(Set noticies) {
		this.noticies = noticies;
	}

	public Set getPdf() {
		return pdf;
	}

	public void setPdf(Set pdf) {
		this.pdf = pdf;
	}

	
	
}
