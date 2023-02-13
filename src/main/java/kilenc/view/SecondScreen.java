package kilenc.view;

import java.awt.Color;
import java.awt.Font;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.type.TrueFalseType;

import kilenc.control.ControlGame;



public class SecondScreen extends JPanel implements VisualWindow {
	
	private FrameBase frameB;
	
	private JLabel title, lName, lPreco, lAno;	
	private JTextField name, preco, ano;	
	private JButton register;
	private JCheckBox gTipeA, gTipeB;
	
	private ControlGame r;
	
	public SecondScreen(FrameBase frameB) {
		this.frameB = frameB;
		r = new ControlGame();
		setLayout();
		setComponents();
		setEvents();
	}

	public void setLayout() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.darkGray);
		
	}
	
	public void setComponents() {
		title = new JLabel("Cadastrar um novo Jogo:");
		title.setFont(new Font(null, Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		title.setBounds(180, 0, 800, 100);
		add(title);
		
		gTipeA = new JCheckBox("Aventura");
		gTipeA.setBounds(75, 85, 90, 15);
		add(gTipeA);
		
		gTipeB = new JCheckBox("Ação");
		gTipeB.setBounds(215, 85, 70, 15);
		add(gTipeB);
		
		lName = new JLabel("Nome do game: ");
		lName.setFont(new Font(null, Font.BOLD, 15));
		lName.setForeground(Color.WHITE);
		lName.setBounds(75, 110, 150, 30);
		add(lName);
		name = new JTextField();
		name.setBounds(210, 110, 220, 30);
		add(name);
		
		lPreco = new JLabel("Preço: ");
		lPreco.setFont(new Font(null, Font.BOLD, 15));
		lPreco.setForeground(Color.WHITE);
		lPreco.setBounds(75, 150, 150, 30);
		add(lPreco);
		preco = new JTextField();
		preco.setBounds(210, 150, 220, 30);
		add(preco);
		
		lAno = new JLabel("Ano: ");
		lAno.setFont(new Font(null, Font.BOLD, 15));
		lAno.setForeground(Color.WHITE);
		lAno.setBounds(75, 190, 150, 30);
		add(lAno);
		ano = new JTextField();
		ano.setBounds(210, 190, 220, 30);
		add(ano);
		
		register = new JButton("Cadastrar Jogo");
		register.setBounds(235, 230, 150, 25);
		add(register);
		
		
	}

	public void setEvents() {
		register.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String nameGame = "";
					double precoGame= 0;
					int anoGame = 0;
					
					nameGame = name.getText();
					precoGame = Double.parseDouble(preco.getText());
					anoGame = Integer.parseInt(ano.getText());
				
					if (gTipeA.isSelected())
						r.addAdventureGame(nameGame, anoGame, precoGame);
					
					if (gTipeB.isSelected()) 
						r.addActionGame(nameGame, anoGame, precoGame);
			
					//System.out.println("Cadastrado!");
				} catch (NumberFormatException e2) {
					System.out.println("Preencha os campos!");
				}
				
			}
		});
		
	}

}
