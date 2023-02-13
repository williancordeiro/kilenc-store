package kilenc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import kilenc.model.Adventure;
import kilenc.util.HibernateUtil;

public class AdventureDao {

	public void saveGame(Adventure adventure) {

		Transaction transaction = null;
		try {
			//System.out.println("Teste GameDao");
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.save(adventure);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public void updateGame(Adventure adventure) {

		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// save the studendt object
			session.saveOrUpdate(adventure);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
	}

	public Adventure getGameById(long id) {

		Transaction transaction = null;
		Adventure adventure = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendt object
			adventure = session.get(Adventure.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}
		return adventure;
	}

	public List<Adventure> listAllGames() {

		Transaction transaction = null;
		List<Adventure> adventures = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendts
			adventures = session.createQuery("from games").list();
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("abriu transaction mas falhou");
			}
		}

		return adventures;
	}

	public void deleteGame(long id) {

		Transaction transaction = null;
		Adventure adventure = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// delete the studendt object
			adventure = session.get(Adventure.class, id);
			session.delete(adventure);

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
