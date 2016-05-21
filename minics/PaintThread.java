package minics;

public class PaintThread extends Thread{
	MainPanel mainPanel;
	public PaintThread(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public void run() {
		while(true)
		{
			mainPanel.repaint();
			try {
	            Thread.sleep(MainPanel.REFRESH_TIME);
	        } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
