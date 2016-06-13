package minics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.Graphics;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

public class GameOverPanel extends JPanel{
	public Image image;
	public Vector<String> gameover = new Vector();
	public Vector readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			Vector sb = new Vector(19);
			String line = br.readLine();

			while (line != null) {
				sb.add(line);
				line = br.readLine();
			}
			return sb;
		}
		finally {
			br.close();
		}
	}
	public void Die() {
		try {
			gameover = readFile("txt/gameovertext.tst");
		}
		catch(Exception ex) {
			System.out.println("GGININDER");
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		int h = 0;
		int w = 0;
		try {
			image = ImageIO.read(new File("pic/gameover.jpg"));
			h = image.getHeight(null);
			w = image.getWidth(null);
		}
        catch (Exception ex) {
            System.out.println("No example.jpg!!");
        }
		double scale = 1.5;
		g.drawImage(image, 0, 0, (int)(w*scale), (int)(h*scale), null);
	}
	
}
