package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Event;
import model.User;
import util.HibernateUtil;

/*
 * This class is used to retrieve the event records from database
 */
public class DisplayEventService {
	
	/*
     * Retrieve all the event records in the database and store them into an ArrayList
     */
    public List<Event> getListOfEvents(){
        List<Event> list = new ArrayList<Event>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Event").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
