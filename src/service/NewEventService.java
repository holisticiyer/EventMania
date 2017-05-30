package service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Event;
import util.HibernateUtil;

/*
 * This class is used to connect to the database using HibernateUtil, and then save the data to the database
 */
public class NewEventService {

	/*
	 * Open database connection and add new event details to the database
	 */
	public boolean addNewEvent(Event event){
		 Session session = HibernateUtil.openSession();
		 if(isEventExists(event)) return false;	
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(event);		
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}

	public boolean isEventExists(Event event){
		 Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Event where eventId='"+event.getId()+"'");
			 Event u = (Event)query.uniqueResult();
			 tx.commit();
			 if(u!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}
	
}
