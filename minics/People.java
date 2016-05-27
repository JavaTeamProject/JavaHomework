package minics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Random;

public class People extends MapElement{
	public Color color;
	public int x_shift;
	public int y_shift;
	public int hp;
	public String currentWeapon;
	public HashMap<String, Integer> readyBullet;
	public HashMap<String, Integer> totalBullet;
	
	/*public People(int x,int y,int map_value)
	{
		this.x = x;
		this.y = y;
		this.map_value = map_value;

		x_shift = 10;
		y_shift = 10;
		map_x_shift = x_shift;
		hp = (map_value==1)?1000:100;
		
		exist = 1;
	}*/
	public void hit(int atk)
	{
		hp = hp - atk;
		if(hp <= 0)
		{
			die();
		}
	}
	public int shot() //mouse Event
	{
		int ready = readyBullet.get(currentWeapon);
		int total = totalBullet.get(currentWeapon);
		if(ready>0)
		{
			readyBullet.put(currentWeapon,ready-1);
			totalBullet.put(currentWeapon,total-1);
			//wait to do:發射子彈
			return 1;
		}
		else if(ready<=0&&total>0)
		{
			waitForReload();
			return 0;
		}
		else
		{
			//wait to do : 無法發射子彈
			return 0;
		}		
	}
	public void waitForReload() //override @ enemy
	{
		//wait to do : alert("reload");
		while(readyBullet.get(currentWeapon)<=0)
		{
			waitForReload();
		}
	}
	public void reload() //mouse Event
	{
		//wait to do : get bulletAmount from weapon shop
		int bulletAmount = 12; 
		readyBullet.put(currentWeapon,bulletAmount);
	}

	public void die() //override @ mainRole & enemy
	{
		//GameOver or knee down
	}

	public void moveHorizontal(Boolean b)
	{
		edit_map(0);
		
		x+=b?x_shift:-x_shift;
		if(x > MiniCSLaunch.FRAME_WIDTH*0.5)
		{
			x -= x_shift;
			MainPanel.map_go();
		}
		else if(x < MiniCSLaunch.FRAME_WIDTH*0.1)
			x += x_shift;
	}
	public void moveVertical(Boolean b)
	{
		edit_map(0);
		y += b?y_shift:-y_shift;
	}
	
	public static void action(){
		int randomNum;
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
	
	public void draw(Graphics g)
	{
		if(MainPanel.map[x/10][y/10+1] != 3 && MainPanel.map[x/10-1][y/10+1] != 3 && MainPanel.map[x/10][y/10+1] != 4 && MainPanel.map[x/10-1][y/10+1] != 4)
		{
			moveVertical(true);
		}
		else if(MainPanel.map[x/10][y/10] == 3 || MainPanel.map[x/10-1][y/10] == 3)
		{
			moveVertical(false);
		}
		
		g.setColor(color);
		g.fillOval(x-10,y-30,20,20);
		g.drawLine(x, y-10, x, y+2);
		g.drawLine(x, y-8, x+7, y);
		g.drawLine(x, y-8, x-7, y);
		g.drawLine(x, y+1, x+7, y+9);
		g.drawLine(x, y+1, x-7, y+9);
		
		edit_map(map_value);
		
	}
	public void edit_map(int map_value)
	{
		for(int i=-1;i<1;i++)
			for(int j=-3;j<1;j++)
				MainPanel.map[x/10+i][y/10+j] = map_value;
	}
}