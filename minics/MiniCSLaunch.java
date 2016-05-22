package minics;

import javax.swing.JFrame;
import java.awt.Dimension;

public class SmallSmallCS_GO{
	
	public static final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	//public static final double FRAME_WIDTH = (int)(screenSize.getWidth()/10)*10;
	//public static final double FRAME_HIGHT = (int)(screenSize.getHeight()/10)*10;
	public static final double FRAME_WIDTH = 800;
	public static final double FRAME_HIGHT = 600;
	
	
	public static JFrame frame;
	
	public static void main(String[] args) {
		initialFrame();
		initialPanel();
		frame.setVisible(true);
	}
	public static void initialWeapon() {
	
	}
	
	public static void initialFrame() {
		frame = new JFrame();
		//frame.setUndecorated(true);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize((int)FRAME_WIDTH,(int)FRAME_HIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void initialPanel() {
		
		frame.add(new MainPanel());
		/*
		 * 
		 * 
		 * 
		 * */
	}
}
