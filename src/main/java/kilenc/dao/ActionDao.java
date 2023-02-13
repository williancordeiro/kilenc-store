package kilenc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import kilenc.model.Action;
import kilenc.util.HibernateUtil;

public class ActionDao {

	public void saveGame(Action game) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.save(game);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public void updateGame(Action game) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.saveOrUpdate(game);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public Action getGameById(long id) {

		Transaction transaction = null;
		Action game = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendt object
			game = session.get(Action.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
		return game;
	}

	public List<Action> listAllStudents() {

		Transaction transaction = null;
		List<Action> games = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendts
			games = session.createQuery("from games").list();
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}

		return games;
	}

	public void deleteStudent(long id) {

		Transaction transaction = null;
		Action game = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// delete the studendt object
			game = session.get(Action.class, id);
			session.delete(game);

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
