package minics;
import javax.swing.*;
import java.awt.Graphics;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
public class GameOverPanel extends JPanel{
	public Image image;
	
	public GameOverPanel()
	{
			addKeyListener(new EventControl());
			addMouseListener(new EventControl());
			setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int h = 0;
		int w = 0;
		String resmoney = "Your Money ";
		String resdistance = "You have walked ";
		String killenemy = "You have killed ";
		try {
			image = ImageIO.read(new File("img/gameover.jpg"));
			h = image.getHeight(null);
			w = image.getWidth(null);
		}
        catch (Exception ex) {
            System.out.println("No example.jpg!!");
        }
		double scale = 1.5;
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawImage(image, 200, 100, (int)(w*scale), (int)(h*scale), null);
		g.drawString(resmoney + MiniCSLaunch.mainpanel.main_role.getMoney() + " dollars", 200, 100 +(int)(h*scale) + 40);
		g.drawString(resdistance + MiniCSLaunch.mainpanel.main_role.getDistance() + " meters", 200, 100 +(int)(h*scale) + 80);
		g.drawString(killenemy + MiniCSLaunch.mainpanel.main_role.getKill() + " enemies", 200, 100 +(int)(h*scale) + 120);
	}
	
}
