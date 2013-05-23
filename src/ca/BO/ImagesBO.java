package ca.BO;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import ca.Entitys.Images;
import ca.utils.HibernateUtil;

public class ImagesBO {

	Session session = HibernateUtil.getSession();

	/** Default constructor. */
	public ImagesBO() {
		super();
	}

	public Images getUrlImageBO(Images image) throws Exception {

		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Images imag = (Images)session.load(Images.class, image.getImageUrl());
		tx.commit();
		session.close();
		return imag;
	}
	public List getImagesBO(String onn) throws Exception {

		
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String queryString ="select img from Images img where img.onn='principals'";
		Query query = session.createQuery(queryString);
		List imagesList = query.list();
	//	Criteria criteria = session.createCriteria(Images.class);
	//List imagesList = (List)criteria.add(Expression.eq("onn", onn)).list();
		tx.commit();
		session.close();
		return imagesList;
	}
	public void saveORUpdateImage(Images img)throws Exception{
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(img);
		tx.commit();
		session.close();
		
	}

}
