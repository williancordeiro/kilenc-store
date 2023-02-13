package kilenc.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class PanelBase extends JPanel implements VisualWindow {
	
	private FrameBase frameB;
	private InitialScreen inicialJP;
	private SecondScreen secondJP;
	private TertiaryScreen tertiaryJP;
	
	public PanelBase(FrameBase frameB) {
		this.frameB = frameB;
		setLayout();
		setComponents();
		setEvents();
	}

	public void setLayout() {
		setLayout(new CardLayout());
		setSize(800, 550);
		//setBackground(Color.RED);
		setVisible(true);
		
	}

	public void setComponents() {
		inicialJP = new InitialScreen(frameB);
		secondJP = new SecondScreen(frameB);
		tertiaryJP = new TertiaryScreen(frameB);
		
		//cardLayout:
		add(inicialJP, "initial");
		
		//flowLayout:
		add(secondJP, "second");
		
		//springLayout
		add(tertiaryJP, "tertiary");
		
	}

	public void setEvents() {
		// TODO Auto-generated method stub
		
	}
	
	

}
