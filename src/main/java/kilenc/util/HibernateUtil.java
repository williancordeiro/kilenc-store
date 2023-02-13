package kilenc.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import kilenc.model.Action;
import kilenc.model.Adventure;
import kilenc.model.Game;
import kilenc.model.User;



public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if( sessionFactory==null ) {
			try {
				Configuration configuration = new Configuration();
				// equivalente ao hibernate.cfg.xml
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/kilencStore");
				settings.put(Environment.USER, "will");
				settings.put(Environment.PASS, "will1");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Game.class);
				configuration.addAnnotatedClass(Adventure.class);
				configuration.addAnnotatedClass(Action.class);
				configuration.addAnnotatedClass(User.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro no HibernateUtil");
			}
		}
		return sessionFactory;
	}
	
	
}
