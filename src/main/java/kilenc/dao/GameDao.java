package kilenc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import kilenc.model.Game;
import kilenc.util.HibernateUtil;

public class GameDao {

	public void saveGame(Game game) {

		Transaction transaction = null;
		try {
			//System.out.println("Teste GameDao");
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

	public void updateGame(Game game) {

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

	public Game getGameById(long id) {

		Transaction transaction = null;
		Game game = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// get the studendt object
			game = session.get(Game.class, id);
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

	public List<Game> listAllGames() {

		Transaction transaction = null;
		List<Game> games = null;
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

	public void deleteGame(long id) {

		Transaction transaction = null;
		Game game = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();
			// delete the studendt object
			game = session.get(Game.class, id);
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
