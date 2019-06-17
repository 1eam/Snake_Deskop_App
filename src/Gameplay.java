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
	
	
	private int[] snakeXLength = new int[750];		//arrays om Xpositie en Y positie te bealen
	private int[] snakeYLength = new int[750];
	
	private boolean up = false;						//variablen  om te controleren welke kant wij opgaan
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	
	private ImageIcon upmouth;						//variabelen voor de jpeg-koppen
	private ImageIcon leftmouth;
	private ImageIcon downmouth;
	private ImageIcon rightmouth;
	
	private int lengthOfSnake = 3;					//default length is 3 bolletjes

	private Timer timer;							//bepaalt snelheid slang
	private int delay = 100;
	private ImageIcon snakeimage;					//variabel voor lichaam: snakebody
	
	private int moves = 0;
	
	private ImageIcon titleImage;					//nieuw object voor image Icon, class title image

	
	public Gameplay ()								//De Constructor, (default positie snake/nttrue)
	{
		addKeyListener (this);						//is Gameplay implementatie
		setFocusable (true);
		setFocusTraversalKeysEnabled (false);
		timer = new Timer(delay, this);
		timer.start();
	}
		
	public void paint (Graphics g)					//Paint method
	{
		if(moves == 0)								//Wanneer het spel (opnieuw) start: voer deze positie uit. Wanneer spel bezig is stop
		{
			snakeXLength[2] = 50;
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
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		// draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 75, 851, 577);
		
		// draw background gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		upmouth = new ImageIcon ("rightmouth.png");								//Slang zonder movement/ Snake draw
		upmouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
		
		for (int a = 0; a< lengthOfSnake; a++)									//Loop, en in brackets; if-statement om de richting te bepalen
		{
			
			if (a==0 && up)
			{
				upmouth = new ImageIcon ("upmouth.png");
				upmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && down)
			{
				downmouth = new ImageIcon ("downmouth.png");
				downmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && left)
			{
				leftmouth = new ImageIcon ("leftmouth.png");
				leftmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			if (a==0 && right)
			{
				rightmouth = new ImageIcon ("rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			
			if (a!=0)
			{
				snakeimage = new ImageIcon ("snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
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
