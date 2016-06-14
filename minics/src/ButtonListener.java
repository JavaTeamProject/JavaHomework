package minics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){ 
			switch(e.getActionCommand())
			{
			case "gun_button":
				MainPanel.main_role.buyWeapon(new Gun());
			break;	
			
			case "machine_button":
				MainPanel.main_role.buyWeapon(new MachineGun());
			break;	
			
			case "sniper_button":
				MainPanel.main_role.buyWeapon(new SniperRfile());
			break;
			
			case "shot_button":
				MainPanel.main_role.buyWeapon(new ShotGun());
			break;	
			}
		}
		
}