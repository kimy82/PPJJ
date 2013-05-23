package ca.BO;

import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ca.Entitys.Obra;
import ca.utils.HibernateUtil;

public class ObraBO {

	

	Session session = HibernateUtil.getSession();

	/** Default constructor. */
	public ObraBO() {
		super();
	}


	public void saveORUpdateObra(Obra obra)throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(obra);
		tx.commit();
		session.close();
		
	}
	
	public void UpdateObra(Obra obra)throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(obra);
		tx.commit();
		session.close();
		
	}
	
	public Integer maxIDObra()throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Integer fid = (Integer)session.createSQLQuery("select max(ID) from obra").uniqueResult();
		session.getTransaction().commit();
		session.close();
		return fid;
	}
	public Obra getObraBO(int id)throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String  sql="select ob from Obra ob where ob.id="+id;
		Obra obra = (Obra)session.createQuery(sql).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return obra;
		
	}
	
	public List getObrasBO()throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String sql="select ob from Obra ob";
		List obraList = session.createQuery(sql).list();
		session.getTransaction().commit();
		session.close();
		return obraList;
		
	}
	public void deleteObraBO(Obra obra){
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Obra obra1= new Obra();
		try {
			obra1 = (Obra)getObraBO(obra.getId());
			Statement statement = session.connection().createStatement();
			String sqlDelete = "delete from obra where id="+obra1.getId();
			statement.execute(sqlDelete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		session.delete(obra1);
		tx.commit();
		session.close();
	}

}
