import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Gameplay extends JPanel{
	private ImageIcon titleImage; //nieuw object voor image Icon, class title image

	
	public Gameplay ()//constructor, 
	{
			
	}
		
	public void paint (Graphics g) //Paint method
	{
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
		
		
		
		
	}
		
}
