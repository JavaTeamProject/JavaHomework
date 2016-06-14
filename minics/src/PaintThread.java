package minics;

public class PaintThread extends Thread{
	MainPanel mainPanel;
	public PaintThread(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public void run() {
		while(MainRole.isDie == false)
		{
			mainPanel.repaint();
			MiniCSLaunch.weaponpanel.refresh();
			try {
	            Thread.sleep(MainPanel.REFRESH_TIME);
	        } catch (InterruptedException e) {e.printStackTrace();}
		}
		MiniCSLaunch.mainpanel.setVisible(false);
		MiniCSLaunch.weaponpanel.setVisible(false);
		MiniCSLaunch.gameoverpanel.setVisible(true);
		MiniCSLaunch.mainpanel.requestFocusInWindow();
		
	}
}
