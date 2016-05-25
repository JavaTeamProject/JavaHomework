package minics;

import java.util.TimerTask;

public class EnemyAppeal {
	public static void run(){
		Thread enemyThread = new EnemyThread();
		enemyThread.start();
	}
}
