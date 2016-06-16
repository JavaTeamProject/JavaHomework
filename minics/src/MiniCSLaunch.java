package minics;

import javax.swing.JFrame;

import java.awt.Dimension;

public class MiniCSLaunch{
	
	public static final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	public static final double FRAME_WIDTH = (int)(screenSize.getWidth()/100)*100+100;
	public static final double FRAME_HIGHT = (int)(screenSize.getHeight()/100)*100+100;
	//public static final double FRAME_WIDTH = 1280;
	//public static final double FRAME_HIGHT = 800;
	public static final double MAINPANEL_WIDTH = FRAME_WIDTH;
	public static final double MAINPANEL_HIGHT = FRAME_HIGHT*0.7;
	public static final double WEAPONPANEL_WIDTH = FRAME_WIDTH;
	public static final double WEAPONPANEL_HIGHT = FRAME_HIGHT*0.3;
	
	public static MainPanel mainpanel = new MainPanel();
	public static WeaponPanel weaponpanel = new WeaponPanel();
	public static GameOverPanel gameoverpanel = new GameOverPanel();
	public static JFrame frame;
	
	public static void main(String[] args)
	{
		initialFrame();
		initialPanel();
		frame.setVisible(true);
	}

	public static void initialFrame()
	{
		frame = new JFrame();
		frame.setLayout(null);
		frame.setUndecorated(true);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize((int)FRAME_WIDTH,(int)FRAME_HIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void initialPanel()
	{
		mainpanel.setSize((int)MAINPANEL_WIDTH,(int) MAINPANEL_HIGHT);
		mainpanel.setLocation(0,0);
		frame.add(mainpanel);	
		mainpanel.setVisible(true);
		
		weaponpanel.setSize((int)WEAPONPANEL_WIDTH,(int) WEAPONPANEL_HIGHT);
		weaponpanel.setLocation(0,(int)(FRAME_HIGHT*0.7));
		frame.add(weaponpanel);
		weaponpanel.setVisible(true);
		
		gameoverpanel.setSize((int)FRAME_WIDTH,(int) FRAME_HIGHT);
		gameoverpanel.setLocation(0,0);
		frame.add(gameoverpanel);	
		gameoverpanel.setVisible(false);
	}
}