import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DrawGraphics {

	BouncingBox box;

	Image star;
	BufferedImage star2;

	/** Initializes this class for drawing. */
	public DrawGraphics() {
		box = new BouncingBox(200, 50, Color.RED);

		java.net.URL imgURL = getClass().getResource("star.png");
		ImageIcon myImageIcon = new ImageIcon(imgURL); 
		star=myImageIcon.getImage();
		
		star2 = null;
		try {
		    star2 = ImageIO.read(getClass().getResource("star.png"));
		} catch (IOException e) {
			System.out.println("Image did not read correctly");
		}

	}

	/** Draw the contents of the window on surface. Called 20 times per second. */
	public void draw(Graphics surface){
		surface.drawLine(50, 50, 250, 250);
		box.draw(surface);

		surface.setColor(Color.CYAN);
		((Graphics2D) surface).setStroke(new BasicStroke(2.0f));
		surface.drawRoundRect(10, 20, 100, 60, 20, 20);

		surface.setColor(Color.CYAN);
		((Graphics2D) surface).setStroke(new BasicStroke(5.0f));
		surface.drawRoundRect(10, 120, 150, 60, 20, 20);

		// simple image at 50,50
		surface.drawImage(star, 50, 50, null);
		surface.drawImage(star2, 100, 50, null);

	}
}