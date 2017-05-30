package service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;
/*
 * This class is used to evaluate the input to see if there is an existing user in the database
 */
public class LoginService {

	/*
	 * validate the credential 
	 */
    public boolean authenticateUser(String userId, String password) {
        User user = getUserByUserEmail(userId);          
        if(user!=null && user.getEmail().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }
    /*
     * get the user info by email
     */
    public User getUserByUserEmail(String userEmail) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where userEmail='"+userEmail+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    /*
     * Retrieve all the records in the database and store them into an ArrayList
     */
    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                        
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
