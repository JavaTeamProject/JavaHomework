package minics;

import java.util.Iterator;

public class EnemyThread extends Thread {
	public void run(){
		while(true){
			Iterator<Enemy> itr = MainPanel.enemy_hashset.iterator();
			while(itr.hasNext()){
				itr.next().action(itr.next());
			}
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
