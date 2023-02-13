package kilenc.dao;

import java.util.List;

import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import kilenc.model.User;
import kilenc.util.HibernateUtil;

public class UserDao {

	public void saveUser(User user) {

		Transaction transaction = null;
		try {
			//System.out.println("Teste GameDao");
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.save(user);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public void updateUser(User user) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.saveOrUpdate(user);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public User getUserById(long id) {

		Transaction transaction = null;
		User user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendt object
			user = session.get(User.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
		return user;
	}

	public List<User> listAllUsers() {

		Transaction transaction = null;
		List<User> users = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendts
			users = session.createQuery("from games").list();
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}

		return users;
	}

	public void deleteStudent(long id) {

		Transaction transaction = null;
		User user = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// delete the studendt object
			user = session.get(User.class, id);
			session.delete(user);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

}
