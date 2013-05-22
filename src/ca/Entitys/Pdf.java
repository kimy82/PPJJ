package ca.Entitys;

public class Pdf implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4303307367682287126L;

	private String nomPDF;

	private int id;
	
	private Obra obra;
	
	private String nomCA;
	
	private String nomEN;
	
	private String nomES;
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String
			data) {
		this.data = data;
	}

	// Geters i setters
	public int getId() {
		return id;
	}

	public String getNomCA() {
		return nomCA;
	}

	public void setNomCA(String nomCA) {
		this.nomCA = nomCA;
	}

	public String getNomEN() {
		return nomEN;
	}

	public void setNomEN(String nomEN) {
		this.nomEN = nomEN;
	}

	public String getNomES() {
		return nomES;
	}

	public void setNomES(String nomES) {
		this.nomES = nomES;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNomPDF() {
		return nomPDF;
	}

	public void setNomPDF(String nomPDF) {
		this.nomPDF = nomPDF;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}
