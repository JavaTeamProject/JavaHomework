package minics;

import java.util.Iterator;

public class BulletThread extends Thread{
	public void run() {
		while(true)
		{
			Iterator<Bullet> itr2 = MainPanel.bullet_hashset.iterator();
			while(itr2.hasNext()){
				itr2.next().fly();
			}
			try {
	            Thread.sleep(MainPanel.REFLY_TIME);
	        } catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}
}
