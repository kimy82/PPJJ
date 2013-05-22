package ca.Entitys;

public class Visitas implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8889556940513433166L;
	public java.util.Date visitaDate;
	public int idVisitas;

	
	//Geters i setters
	public java.util.Date getVisitaDate() {
		return visitaDate;
	}

	public void setVisitaDate(java.util.Date visitaDate) {
		this.visitaDate = visitaDate;
	}

	public int getIdVisitas() {
		return idVisitas;
	}

	public void setIdVisitas(int idVisitas) {
		this.idVisitas = idVisitas;
	}
	
}
