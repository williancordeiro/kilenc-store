package kilenc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kilenc.control.ControlUser;
import kilenc.model.Texts;
import kilenc.util.ThreadUtil;



public class InitialScreen extends JPanel implements VisualWindow {
	
	private FrameBase frameB;
	
	private JTextField login, password, name, email, rPassword;
	private JButton btLogar, btRegister;
	private JLabel title1, lLogin, lPassword, lName, lEmail, lRPassword, titleStore;
	
	private ControlUser user;
	
	public InitialScreen(FrameBase frameB) {
		this.frameB = frameB;
		user = new ControlUser();
		setLayout();
		setComponents();
		setEvents();
	}

	public void setLayout() {
		setLayout(null);
		setVisible(true);
		setBackground(Color.GRAY);
		
	}

	public void setComponents() {
		title1 = new JLabel("Bem-vindo(a) Kilenc Store");
		title1.setFont(new Font(null, Font.BOLD, 30));
		title1.setBounds(170, 0, 800, 100);
		add(title1);
		
		lLogin = new JLabel("Nome: ");
		lLogin.setBounds(85, 100, 100, 25);
		add(lLogin);	
		login = new JTextField();
		login.setBounds(135, 100, 140, 25);
		add(login);
		
		lPassword = new JLabel("Senha: ");
		lPassword.setBounds(85, 130, 100, 25);
		add(lPassword);
		password = new JTextField();
		password.setBounds(135, 130, 140, 25);
		add(password);
		
		lName = new JLabel("Nome: ");
		lName.setBounds(485, 100, 100, 25);
		add(lName);
		name = new JTextField();
		name.setBounds(535, 100, 140, 25);
		add(name);
		
		lEmail = new JLabel("Email: ");
		lEmail.setBounds(485, 130, 100, 25);
		add(lEmail);
		email = new JTextField();
		email.setBounds(535, 130, 140, 25);
		add(email);
		
		lRPassword = new JLabel("Senha: ");
		lRPassword.setBounds(485, 160, 100, 25);
		add(lRPassword);
		rPassword = new JTextField();
		rPassword.setBounds(535, 160, 140, 25);
		add(rPassword);
		
		btLogar = new JButton("Logar");
		btLogar.setBounds(150, 160, 100, 25);
		add(btLogar);
		
		btRegister = new JButton("Registrar-se");
		btRegister.setBounds(540, 190, 130, 25);
		add(btRegister);
		
		titleStore = new JLabel("Conheça a Loja!");
		titleStore.setFont(new Font(null, Font.BOLD, 50));
		titleStore.setBounds(190, 300, 800, 100);
		add(titleStore);
	}

	public void setEvents() {
		btLogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome = "";
					String senha = "";
					
					nome = lLogin.getText();
					senha = lPassword.getText();
					
					if (user.login(nome, senha))
						System.out.println("Usuário logado!");
				} catch (NullPointerException e2) {
					System.out.println("Usuário não localizado!");
				}
							
				
				ThreadUtil thread = new ThreadUtil();
				
				int amount = 0;
				Random r = new Random();
				
				amount = r.nextInt(10);
				
				
				thread.start();
				
				while(thread.isAlive()) {
					System.out.println(thread.getWating());
					
					for (int i = 0; i < amount; i++)
						System.out.println(thread.getComplite());
				}
				
			}
		});
		
		btRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = "";
				String rEmail = "";
				String senha = "";
				
				nome = name.getText();
				rEmail = email.getText();
				senha = rPassword.getText();
				
				if (!nome.isEmpty() && !rEmail.isEmpty() && !senha.isEmpty()) {
					if (user.validateEmail(rEmail)) {
						user.registerUser(nome, rEmail, senha);
						System.out.println("Usuário Cadastrado!");
					}
					else
						System.out.println("Email invalido!");
				}
				
			}
		});
		
		titleStore.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				titleStore.setBounds(170, 300, 800, 100);
				titleStore.setText(Texts.ADVENTURE.getValor());
				
			}
			
			public void mousePressed(MouseEvent e) {
				titleStore.setBounds(190, 300, 800, 100);
				titleStore.setText(Texts.ACTION.getValor());

				
			}
			
			public void mouseExited(MouseEvent e) {
				titleStore.setBounds(190, 300, 800, 100);
				titleStore.setText("Conheça a Loja!");
				
			}
			
			public void mouseEntered(MouseEvent e) {
				titleStore.setBounds(130, 300, 800, 100);
				titleStore.setText(Texts.KILENC.getValor());
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
