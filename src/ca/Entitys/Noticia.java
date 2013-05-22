package ca.Entitys;

public class Noticia implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4303307367682287126L;

	private String noticiaUrl;

	private int id;
	
	private Obra obra;
	
	private String nomCA;
	
	private String nomEN;
	
	private String nomES;

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

	public String getNoticiaUrl() {
		return noticiaUrl;
	}

	public void setNoticiaUrl(String noticiaUrl) {
		this.noticiaUrl = noticiaUrl;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}
