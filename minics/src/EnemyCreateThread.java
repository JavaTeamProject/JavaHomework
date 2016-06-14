package minics;

import java.util.Random;

public class EnemyCreateThread extends Thread {
	int randomNum;
	public void run(){
		while(true)
		{
			Random ran = new Random();
			randomNum = ran.nextInt(10)+1;
			
			if(randomNum%3 != 0)
				MainPanel.enemy_hashset.add(new Enemy((int)(MiniCSLaunch.MAINPANEL_WIDTH*0.9), (int)(MiniCSLaunch.MAINPANEL_WIDTH*0.25)));
			else
				MainPanel.enemy_hashset.add(new Enemy((int)(MiniCSLaunch.MAINPANEL_WIDTH*0.1), (int)(MiniCSLaunch.MAINPANEL_WIDTH*0.25)));
			
			try {
	            Thread.sleep(randomNum * 1000);
	        } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
