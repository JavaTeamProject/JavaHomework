package minics;

import java.util.TimerTask;
import java.util.Random;

public class EnemyAction extends TimerTask {
	int randomNum;
	public void run(){
		Random ran = new Random();
		randomNum = (ran.nextInt(3)) % 3;
		
		switch(randomNum){
			case 0: //toward to main_role
				if(MainPanel.enemy.x < MainPanel.main_role.x){
					MainPanel.enemy.moveHorizontal(true);
				}
				else if(MainPanel.enemy.x > MainPanel.main_role.x){
					MainPanel.enemy.moveHorizontal(false);
				}
				else ;
				break;
			case 1: //shot
				MainPanel.bullet_hashset.add(new Bullet(MainPanel.enemy.x, MainPanel.enemy.y, MainPanel.main_role.x-MainPanel.enemy.x, MainPanel.main_role.y-MainPanel.enemy.y,2));
				break;
			case 2: //stay
				break;
		}
	}
}
