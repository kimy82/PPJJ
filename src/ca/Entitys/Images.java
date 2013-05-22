package ca.Entitys;

public class Images implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1216634076853661831L;

	private String imageUrl;

	private int id;
	
	private Obra obra;
	
	private String onn;

	// Geters i setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOnn() {
		return onn;
	}

	public void setOnn(String onn) {
		this.onn = onn;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}
