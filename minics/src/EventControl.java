package minics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventControl implements KeyListener,MouseListener,ActionListener{
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN:
				MainPanel.main_role.moveVertical(true);
				break;
			/*case KeyEvent.VK_UP:
				MainPanel.main_role.moveVertical(false);
				break;*/
			case KeyEvent.VK_LEFT:
				MainPanel.main_role.moveHorizontal(false);
				break;
			case KeyEvent.VK_RIGHT:
				MainPanel.main_role.moveHorizontal(true);
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			
			case 49:
				MainPanel.main_role.changeWeapon("gun");
				MiniCSLaunch.weaponpanel.gun_button.setVisible(false);
				MiniCSLaunch.weaponpanel.machine_button.setVisible(true);
				MiniCSLaunch.weaponpanel.sniper_button.setVisible(true);
				MiniCSLaunch.weaponpanel.shot_button.setVisible(true);
				MiniCSLaunch.weaponpanel.gun_button_y.setVisible(true);
				MiniCSLaunch.weaponpanel.machine_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.sniper_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.shot_button_y.setVisible(false);
				
				break;
			case 50:
				MainPanel.main_role.changeWeapon("machinegun");
				MiniCSLaunch.weaponpanel.gun_button.setVisible(true);
				MiniCSLaunch.weaponpanel.machine_button.setVisible(false);
				MiniCSLaunch.weaponpanel.sniper_button.setVisible(true);
				MiniCSLaunch.weaponpanel.shot_button.setVisible(true);
				MiniCSLaunch.weaponpanel.gun_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.machine_button_y.setVisible(true);
				MiniCSLaunch.weaponpanel.sniper_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.shot_button_y.setVisible(false);
				break;
			case 51:
				MainPanel.main_role.changeWeapon("sniperrfile");
				MiniCSLaunch.weaponpanel.gun_button.setVisible(true);
				MiniCSLaunch.weaponpanel.machine_button.setVisible(true);
				MiniCSLaunch.weaponpanel.sniper_button.setVisible(false);
				MiniCSLaunch.weaponpanel.shot_button.setVisible(true);
				MiniCSLaunch.weaponpanel.gun_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.machine_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.sniper_button_y.setVisible(true);
				MiniCSLaunch.weaponpanel.shot_button_y.setVisible(false);
				break;
			case 52:
				MainPanel.main_role.changeWeapon("shotgun");
				MiniCSLaunch.weaponpanel.gun_button.setVisible(true);
				MiniCSLaunch.weaponpanel.machine_button.setVisible(true);
				MiniCSLaunch.weaponpanel.sniper_button.setVisible(true);
				MiniCSLaunch.weaponpanel.shot_button.setVisible(false);
				MiniCSLaunch.weaponpanel.gun_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.machine_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.sniper_button_y.setVisible(false);
				MiniCSLaunch.weaponpanel.shot_button_y.setVisible(true);
				break;
			
			default: break;
		}
	}
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent e) {}
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "gun_button":
			MainPanel.main_role.buyWeapon("gun");
		break;	
		
		case "machine_button":
			MainPanel.main_role.buyWeapon("machinegun");
		break;	
		
		case "sniper_button":
			MainPanel.main_role.buyWeapon("sniperrfile");
		break;
		
		case "shot_button":
			MainPanel.main_role.buyWeapon("shotgun");
		break;	
		}
		MiniCSLaunch.mainpanel.requestFocusInWindow();
	}
	public void mousePressed(MouseEvent event)
	{
        if (event.getButton() == MouseEvent.BUTTON1) //left button
        {
        	if(MainPanel.main_role.shot()==1)
    		{
    			int atk = MainPanel.main_role.getAtk();
    			if (MainPanel.main_role.currentWeapon instanceof ShotGun)
    				for (int i = -2; i < 3; i++)
        				MainPanel.bullet_hashset.add(new Bullet(MainPanel.main_role.x, MainPanel.main_role.y, event.getX()-MainPanel.main_role.x + i * 10, event.getY()-MainPanel.main_role.y + i * 10,1,atk));
    			else
    				MainPanel.bullet_hashset.add(new Bullet(MainPanel.main_role.x, MainPanel.main_role.y, event.getX()-MainPanel.main_role.x, event.getY()-MainPanel.main_role.y,1,atk));
    		}
        }
        if (event.getButton() == MouseEvent.BUTTON3) //right button
        {
        	MainPanel.main_role.reload();
        }
		//System.out.println(bullet_hashset.size());
		
		//point_hashset.add(new Point(event.getX(), event.getY()));
		/*System.out.println("-----------------------------------------------------");
		for(int i = 0;i<MainPanel.MAP_HIGHT;i++)
		{
			for(int j = 0; j<MainPanel.MAP_WIDTH ; j++)
			{
				System.out.print(MainPanel.map[j][i]);
			}
			System.out.println();
		}*/
	}

	public void mouseReleased(MouseEvent event){}
	public void mouseClicked(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
}
