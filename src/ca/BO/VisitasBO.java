package ca.BO;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import ca.Entitys.Visitas;
import ca.utils.HibernateUtil;

public class VisitasBO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	Session session = sessionFactory.openSession();

	/** Default constructor. */
	public VisitasBO() {
		super();
	}

	public void saveVisitaBO(Visitas visita) throws Exception {

		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(visita);
		tx.commit();
		session.close();
	}

	public int getNumVisitesAvuiBO() throws Exception {

		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Visitas.class);
		criteria.add(Expression.eq("visitaDate", new java.util.Date()));
				

		int numeroVisitas = criteria.list().size();

		tx.commit();
		session.close();

		
		return numeroVisitas;
	}

	public int getNumVisitesUltimMesBO() throws Exception {

		System.out.println("vis12");
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		java.util.Date date = new java.util.Date();
		java.util.Calendar dateCal = java.util.Calendar.getInstance();
		dateCal.setTime(date);
		int month = dateCal.MONTH;
		int day = dateCal.DATE;
		int year = dateCal.YEAR;
		if (month != 1) {
			dateCal.set(year, month - 1, day);
		} else {
			dateCal.set(year, 12, day);
		}

		Criteria criteria = session.createCriteria(Visitas.class);
		criteria.add(Expression.between("visitaDate", new java.util.Date(
				dateCal.getTimeInMillis()), new java.util.Date()));

		int numeroVisitas = criteria.list().size();

		tx.commit();
		session.close();
		System.out.println("vis14" + numeroVisitas);
		return numeroVisitas;
	}

}
