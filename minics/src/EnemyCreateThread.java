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
				MainPanel.enemy_hashset.add(new Enemy((int)(MiniCSLaunch.FRAME_WIDTH*0.9), (int)(MiniCSLaunch.FRAME_WIDTH*0.5), 2));
			else
				MainPanel.enemy_hashset.add(new Enemy((int)(MiniCSLaunch.FRAME_WIDTH*0.1), (int)(MiniCSLaunch.FRAME_WIDTH*0.5), 2));
			
			try {
	            Thread.sleep(randomNum * 100);
	        } catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
