import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	
	private int[] snakeXLength = new int[750];		//arrays om Xpositie en Y positie te bepalen
	private int[] snakeYLength = new int[750];
	
	private boolean up = false;						//variablen  om te controleren welke kant wij opgaan
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	
	private ImageIcon faceUp;						//variabelen voor de jpeg-koppen
	private ImageIcon faceDown;
	private ImageIcon faceLeft;
	private ImageIcon faceRight;
	
	private int snakeLength = 3;					//default length is 3 bolletjes

	private Timer speed;							//bepaalt snelheid slang
	private int delay = 100;
	private ImageIcon snakeBody;					//variabel voor lichaam: snakebody
	
	private int moves = 0;
	
	private ImageIcon icon;							//nieuw object voor image Icon, class Icon

	
	public Gameplay ()								//De Constructor, (default positie snake/nttrue)
	{
		addKeyListener (this);						//is Gameplay implementatie
		setFocusable (true);
		setFocusTraversalKeysEnabled (false);
		speed = new Timer(delay, this);
		speed.start();
	}
		
	public void paint (Graphics g)					//Paint method
	{
		if(moves == 0)								//Wanneer het spel (opnieuw) start: voer deze positie uit. Wanneer spel bezig is stop
		{
			snakeXLength[2] = 50;                   //bepaalt de positie van elk bolletje: de ketting
			snakeXLength[1] = 75;
			snakeXLength[0] = 100;
			
			snakeYLength[2] = 100;
			snakeYLength[1] = 100;
			snakeYLength[0] = 100;
		}
		
		// draw title Image border
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		// draw the title Image
		icon = new ImageIcon("gameHeader.jpg");
		icon.paintIcon(this, g, 25, 11);
		
		// draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 75, 851, 577);
		
		// draw background gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		faceRight = new ImageIcon ("faceRight.png");							//Slang zonder movement/ Snake draw (verander naar right later)
		faceRight.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
		
		for (int a = 0; a< snakeLength; a++)									//Loop, en in brackets; if-statement om de richting te bepalen
		{
			
			if (a==0 && up)
			{
				faceUp = new ImageIcon ("faceUp.png");
				faceUp.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && down)
			{
				faceDown = new ImageIcon ("faceDown.png");
				faceDown.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && left)
			{
				faceLeft = new ImageIcon ("faceLeft.png");
				faceLeft.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && right)
			{
				faceRight = new ImageIcon ("faceRight.png");
				faceRight.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			
			if (a!=0)
			{
				snakeBody = new ImageIcon ("snakeBody.png");
				snakeBody.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
		}
		
		
		g.dispose();
	}

@Override																		//Method van de actionListener
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
																				//Methods van de KeyListener 3
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
		
}
