package kilenc.control;


import java.util.Collections;
import java.util.List;

import kilenc.dao.ActionDao;
import kilenc.dao.AdventureDao;
import kilenc.dao.GameDao;
import kilenc.model.Action;
import kilenc.model.Adventure;
import kilenc.model.Game;

public class ControlGame {
	
	private GameDao game;
	private Adventure ad;
	private Action ac;
	private ActionDao acDao;
	private AdventureDao adDao;
	
	public ControlGame() {
		acDao = new ActionDao();
		adDao = new AdventureDao();
		game = new GameDao();
	}
	
	public void addAdventureGame(String name, int age, double price) {
		ad = new Adventure(name, age, price);
		adDao.saveGame(ad);
	}
	
	public void addActionGame(String name, int age, double price) {
		ac = new Action(name, age, price);
		acDao.saveGame(ac);
	}
	
//	public ArrayList<Game> listGames() {
//		g.addAll(game.listAllGames());
//		
//		return g;
//	}
	
	public List<Game> getGames() {
		return Collections.unmodifiableList(game.listAllGames());
	}
}
