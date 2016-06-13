package minics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Timer;

public class MainRole extends People{
	public Color color = Color.BLUE;
	public int x_shift;
	public int y_shift;
	public int hp;
	private Weapon currentWeapon;
	private HashMap<Weapon, Integer> readyBullet = new HashMap<Weapon, Integer>();
	private HashMap<Weapon, Integer> totalBullet = new HashMap<Weapon, Integer>();
	public int map_value = 2;
	private int die = 0;

	public MainRole(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.map_value = value;

		x_shift = 10;
		y_shift = 10;
		map_x_shift = x_shift;
		hp = 1000;
		
		exist = 1;
		
		initWeapon();
	}
	public void initWeapon()
	{
		currentWeapon = new Gun();
		readyBullet.put(currentWeapon,12);
		totalBullet.put(currentWeapon,99999);
	}
	public void moveLeft()
	{	
	}
	public void hit(int atk)
	{
		hp = hp - atk;
		if(hp <= 0)
		{
			die();
		}
	}
	/*public int getAtk()
	{
		return currentWeapon.getAtk();
	}*/
	public int shot() //mouse Event
	{
		int ready = readyBullet.get(currentWeapon);
		int total = totalBullet.get(currentWeapon);
		if(ready>0)
		{
			readyBullet.put(currentWeapon,ready-1);
			totalBullet.put(currentWeapon,total-1);
			return 1;
		}
		else if(ready<=0&&total>0)
		{
			waitForReload();
			return 1;
		}
		else
		{
			return 0;
		}		
	}
	public void waitForReload() //override @ enemy
	{
		//wait to do : alert("reload"); --> UI
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
	public void buyWeapon(Weapon weapon)
	{
		if(totalBullet.containsKey(weapon))
		{
			int total = weapon.getClipAmount() + totalBullet.get(weapon);
			//readyBullet.put(weapon,bulletAmount);
			totalBullet.put(weapon,total);
		}
		else
		{
			readyBullet.put(weapon,weapon.getClipAmount());
			totalBullet.put(weapon,weapon.getClipAmount());
		}
	}
	public void die() //override @ mainRole & enemy
	{
		die = 1 ;
		Timer timer = new Timer();
		timer.schedule(new Die(),0 ,100);
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

	public void draw(Graphics g)
	{
		if(die == 0)
		{
			if(MainPanel.map[x/10][y/10+1] != 3 && MainPanel.map[x/10-1][y/10+1] != 3 && MainPanel.map[x/10][y/10+1] != 4 && MainPanel.map[x/10-1][y/10+1] != 4)
			{
				moveVertical(true);
			}
			else if(MainPanel.map[x/10][y/10] == 3 || MainPanel.map[x/10-1][y/10] == 3)
			{
				moveVertical(false);
			}
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
