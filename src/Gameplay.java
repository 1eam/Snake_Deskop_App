import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4300610749422495781L;
	private int[] snakeXrange = new int[750];		//class om arrays Xpositie en Y positie te bepalen, max length
	private int[] snakeYrange = new int[750];
	
	private boolean up = false;						//variablen  om te controleren welke kant wij opgaan
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	
	private ImageIcon faceUp;						//variabelen voor de jpeg-koppen
	private ImageIcon faceDown;
	private ImageIcon faceLeft;
	private ImageIcon faceRight;
	
	private int snakeLength = 3;					//default length is 3 bolletjes

	private Timer movement;							//bepaalt snelheid slang
	private int delay = 100;
	private ImageIcon snakeBody;					//variabel voor lichaam: snakebody
	
	private int [] foodXposition = {25, 50, 75, 100, 125, 150, 175, 200, 225, 
			250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 
			575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850,};
	private int [] foodYposition = {75, 100, 125, 150, 175, 200, 225, 250, 275, 
			300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private ImageIcon food;
	
	private Random random = new Random();
	private int randomXposition = random.nextInt(34);
	private int randomYposition = random.nextInt(23);
		
	
	private int moves = 0;
	
	private ImageIcon icon;							//nieuw object voor image Icon, class Icon

	
	public Gameplay ()								//De Constructor, (default positie snake/nottrue)
	{
		addKeyListener (this);						//is Gameplay implementatie
		setFocusable (true);
		setFocusTraversalKeysEnabled (false);
		movement = new Timer(delay, this);
		movement.start();
	}
		
	public void paint (Graphics g)					//Paint method
	{
		if(moves == 0)								//Wanneer het spel (opnieuw) start: voer deze positie uit. Wanneer spel bezig: custom gegevens
		{
			snakeXrange[2] = 50;					//bepaalt de positie van elk bolletje: de ketting
			snakeXrange[1] = 75;
			snakeXrange[0] = 100;
			
			snakeYrange[2] = 100;
			snakeYrange[1] = 100;
			snakeYrange[0] = 100;
		}
		
		// rectangle Header
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		// view the Header, variabel 
		icon = new ImageIcon("D:\\Java Projects\\snakeDesktopApp\\src\\gameHeader.jpg");
		icon.paintIcon(this, g, 25, 11);
		
		// draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 75, 851, 577);
		
		// draw background gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		faceRight = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\faceRight.png");							//Slang zonder movement/ Snake draw (verander naar right later)
		faceRight.paintIcon(this, g, snakeXrange[0], snakeYrange[0]);
		
		for (int a = 0; a< snakeLength; a++)									//Loop, en in brackets; if-statement om de richting te bepalen
		{
			
			if (a==0 && up)
			{
				faceUp = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\faceUp.png");
				faceUp.paintIcon(this, g, snakeXrange[a], snakeYrange[a]);
			}
			if (a==0 && down)
			{
				faceDown = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\faceDown.png");
				faceDown.paintIcon(this, g, snakeXrange[a], snakeYrange[a]);
			}
			if (a==0 && left)
			{
				faceLeft = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\faceLeft.png");
				faceLeft.paintIcon(this, g, snakeXrange[a], snakeYrange[a]);
			}
			if (a==0 && right)
			{
				faceRight = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\faceRight.png");
				faceRight.paintIcon(this, g, snakeXrange[a], snakeYrange[a]); 
			}
			
			if (a!=0)
			{
				snakeBody = new ImageIcon ("D:\\Java Projects\\snakeDesktopApp\\src\\snakeBody.png");
				snakeBody.paintIcon(this, g, snakeXrange[a], snakeYrange[a]);	//(teken) Paint (deze) this (afb) icon (afb) aan de hand van de snake X positie, en volg de loop. (en .painticon is on its own)
			}
		}
		
		
		food = new ImageIcon("D:\\Java Projects\\snakeDesktopApp\\src\\food.png");
		
		if((foodXposition [randomXposition] == snakeXrange[0] && foodYposition [randomYposition] == snakeYrange[0])) //has the head collided?
		{
			snakeLength++;								//has the head collided? if true add length: "++". "++"increases the VALUE of an VARIABLE by one increment
			randomXposition = random.nextInt (34);
			randomYposition = random.nextInt (23);
		}
		
		food.paintIcon(this, g, foodXposition [randomXposition], foodYposition [randomYposition]);

		
		g.dispose();
	}

@Override																		//Deze code wordt opgeroepen wanneer de timer is gestart
public void actionPerformed(ActionEvent e) {
	movement.start();
	if (up)
	{
		for (int r = snakeLength-1; r>=0; r--)
		{
			snakeXrange[r+1] = snakeXrange[r];
		}
		for (int r = snakeLength; r>=0; r--)
		{
			if (r==0)
			{
				snakeYrange [r] = snakeYrange [r] - 25;
			}
			else
			{
				snakeYrange[r] = snakeYrange[r-1];
			}
			if (snakeYrange[r] < 75) //als de slang 75 raakt, dan van andere kant komen (positie resetten naar 25)
			{
				snakeYrange[r] = 625;
			}
			
			repaint(); //deze method roept de paintmethod bovenin roept
		}
	}
	if (down)
	{
		for (int r = snakeLength-1; r>=0; r--)
		{
			snakeXrange[r+1] = snakeXrange[r];
		}
		for (int r = snakeLength; r>=0; r--)
		{
			if (r==0)
			{
				snakeYrange [r] = snakeYrange [r] + 25;
			}
			else
			{
				snakeYrange[r] = snakeYrange[r-1];
			}
			if (snakeYrange[r] > 625) //als de slang 625 raakt, dan van andere kant komen (positie resetten naar 25)
			{
				snakeYrange[r] = 75;
			}
			
			repaint(); //deze method roept de paintmethod bovenin roept
		}
	}
	if (left)
	{
		for (int r = snakeLength-1; r>=0; r--)
		{
			snakeYrange[r+1] = snakeYrange[r];
		}
		for (int r = snakeLength; r>=0; r--)
		{
			if (r==0)
			{
				snakeXrange [r] = snakeXrange [r] - 25;
			}
			else
			{
				snakeXrange[r] = snakeXrange[r-1];
			}
			if (snakeXrange[r] < 25) //als de slang 850 raakt, dan van andere kant komen (positie resetten naar 25)
			{
				snakeXrange  [r] = 850;
			} 
			
			repaint(); //deze method roept de paintmethod bovenin roept
		}
	}
	if (right)
	{
		
		for (int r = snakeLength-1; r>=0; r--)
		{
			snakeYrange[r+1] = snakeYrange[r];
		}
		for (int r = snakeLength; r>=0; r--)
		{
			if (r==0)
			{
				snakeXrange [r] = snakeXrange [r] + 25;
			}
			else
			{
				snakeXrange[r] = snakeXrange[r-1];
			}
			if (snakeXrange[r] > 850) //als de slang 850 raakt, dan van andere kant komen (positie resetten naar 25)
			{
				snakeXrange  [r] = 25;
			}
			
			repaint(); //deze method roept de paintmethod bovenin roept
		}
	}
	
}
																				//Methods van de KeyListener 3
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {											//37:01
	if(e.getKeyCode() == KeyEvent.VK_UP)
	{
		moves++;
		up = true;
		if(!down)
		{
			up = true;
		}
		else
		{
			up = false;
			down = true;
		}
		
		left = false;
		right = false;
				
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN)
	{
		moves++;
		down = true;
		if(!up)
		{
			down = true;
		}
		else
		{
			down = false;
			up = true;
		}
		
		left = false;
		right = false;
				
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT)
	{
		moves++;
		left = true;
		if(!right)
		{
			left = true;
		}
		else
		{
			left = false;
			right = true;
		}
		
		up = false;
		down = false;
				
	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	{
		moves++;
		right = true;
		if(!left)
		{
			right = true;
		}
		else
		{
			right = false;
			left = true;
		}
		
		up = false;
		down = false;
				
	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
		
}
