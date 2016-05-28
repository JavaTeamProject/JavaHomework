package minics;

import java.util.Iterator;

public class EnemyActionThread extends Thread {
	public void run(){
		while(true){
		
			Iterator<Enemy> itr = MainPanel.enemy_hashset.iterator();
			while(itr.hasNext()){
				itr.next().action();
			}
			
			try{
				Thread.sleep(400);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
