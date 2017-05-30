package service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

/*
 * This class will handles the operation on users such as update user info.
 */
public class UserService {

	/*
	 * UPDATE USER EMAIL
	 * My question is how do we the current user?? in order to update the email
	 */
	public void updateEmail(String email){
		
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
      
	}
	
public void updatePassword(){
		
	}

public void updateName(){
	
}
	
	
	
}
