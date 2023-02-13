package kilenc.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class FrameBase extends JFrame implements VisualWindow {
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem item1, item2, item3;
	
	public CardLayout cl;
	
	private PanelBase baseJP;

	public FrameBase() {
		setLayout();
		setComponents();
		setEvents();
		repaintAll();
		validate();
	}

	public void setLayout() {
		setSize(800, 600);
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public void setComponents() {
		menuBar = new JMenuBar();
		menu = new JMenu("Opções");
		item1 = new JMenuItem("Acesso");
		item2 = new JMenuItem("Registro");
		item3 = new JMenuItem("Listar");
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menuBar.add(menu);
		
		baseJP = new PanelBase(this);
		cl = new CardLayout();
		cl = (CardLayout)baseJP.getLayout();
		
		add(menuBar, BorderLayout.NORTH);
		add(baseJP, BorderLayout.CENTER);
		
	}

	public void setEvents() {
		item1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "initial");
				//System.out.println("initial");
				repaintAll();
			}
		});
		
		
		item2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "second");
				//System.out.println("second");
				//repaintAll();
			}
		});
		
		item3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cl.show(baseJP, "tertiary");
				//repaintAll();
				
			}
		});
	}
	
	private void repaintAll() {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				repaint();
				
			}
		});
	}
	
	

}
