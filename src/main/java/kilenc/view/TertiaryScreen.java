package kilenc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import kilenc.control.ControlGame;
import kilenc.model.Game;
//import kilenc.util.ThreadUtil;

//import com.utfpr.util.dataBase.DataBase;

public class TertiaryScreen extends JPanel implements VisualWindow {
	
	private FrameBase frameB;
	
	private ControlGame ctrlGame;
	
	private JLabel title, lSearch, lResult;
	//private JTextField search;
	private JTextArea result;
	
	private JButton bSearch;
	
	public TertiaryScreen(FrameBase frameB) {
		this.frameB = frameB;
		ctrlGame = new ControlGame();
		setLayout();
		setComponents();
		setEvents();
	}

	public void setLayout() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.lightGray);
		
	}

	public void setComponents() {
		title = new JLabel("Buscar por Jogo:");
		title.setFont(new Font(null, Font.BOLD, 30));
		title.setBounds(260, 0, 800, 100);
		add(title);
		
		lSearch = new JLabel("Listar Jogos: ");
		lSearch.setFont(new Font(null, Font.BOLD, 15));
		lSearch.setBounds(85, 110, 170, 30);
		add(lSearch);
//		search = new JTextField();
//		search.setBounds(85, 140, 220, 30);
//		add(search);
		
		bSearch = new JButton("Listar todos:");
		bSearch.setBounds(140, 140, 150, 30);
		add(bSearch);
		
		lResult = new JLabel("Informações encontradas:");
		lResult.setFont(new Font(null, Font.BOLD, 20));
		lResult.setBounds(30, 190, 320, 30);
		add(lResult);
		result = new JTextArea();
		result.setBounds(30, 220, 390, 280);
		add(result);
	}

	public void setEvents() {
		bSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				try {
					@SuppressWarnings("unchecked")
					Iterator<Game> games = (Iterator<Game>) ctrlGame.getGames();
					
					while (games.hasNext()) {
						 Game gm = games.next();
						 	result.append(gm.getName());
							result.append(System.lineSeparator());
							result.append(String.format("R$%.2f",gm.getPrice()));
							result.append(System.lineSeparator());
							result.append(String.format("%d",gm.getAge()));
							result.append(System.lineSeparator());
							result.append(gm.getType());
							result.append(System.lineSeparator());
							result.append("---------");
							result.append(System.lineSeparator());
					}
				} catch (NullPointerException e2) {
					result.append("Não foi possivel localizar.");
				}
			}
		});
		
	}

}
