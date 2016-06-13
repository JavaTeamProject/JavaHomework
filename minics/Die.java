package minics;

import java.util.TimerTask;

public class Die extends TimerTask {
	public void run(){
		MainPanel.main_role.moveVertical(true);
	}
}
