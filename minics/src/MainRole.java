package minics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Timer;

public class MainRole extends People{

	public static Boolean isDie = false;
	public Color color = Color.BLUE;
	public int x_shift;
	public int y_shift;
	public int hp;
	public Weapon currentWeapon ;
	public HashMap<Weapon, Integer> readyBullet = new HashMap<Weapon, Integer>();
	public HashMap<Weapon, Integer> totalBullet = new HashMap<Weapon, Integer>();
	public int map_value = 2;

	public int money = 0;
	public int kill = 0;
	public int distance = 0;
	private int reload;

	private Weapon gun = new Gun();
	private Weapon shotgun = new ShotGun();
	private Weapon machinegun = new MachineGun();
	private Weapon sniperRfile = new SniperRfile();

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
		currentWeapon = gun;
		readyBullet.put(currentWeapon,currentWeapon.getClipAmount());
		totalBullet.put(currentWeapon,99999);
		readyBullet.put(shotgun,0);
		totalBullet.put(shotgun,200);
		readyBullet.put(machinegun,0);
		totalBullet.put(machinegun,0);
		readyBullet.put(sniperRfile,0);
		totalBullet.put(sniperRfile,200);
	}
	public void moveLeft()
	{
	}
	public void changeWeapon(String weapon)
	{
		if(weapon.equals("gun"))
		{
			currentWeapon = gun;
	    }
		else if(weapon.equals("shotgun"))
		{
			currentWeapon = shotgun;
	    }
		else if(weapon.equals("machinegun"))
		{
			currentWeapon = machinegun;
		}
		else if(weapon.equals("sniperrfile"))
		{
			currentWeapon = sniperRfile;
	    }
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
	public void setMoney(int add)
	{
		money += add;
	}
	public void setDistance(int add)
	{
		distance += add;
	}
	public void setKill(int add)
	{
		kill += add;
	}
	public int getMoney()
	{
		return money;
	}
	public int getDistance()
	{
		return distance;
	}
	public int getKill()
	{
		return kill;
	}
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
		/*else if(ready<=0&&total>0)
		{
			reload = 1;
			return 0;
		}*/
		else
		{
			reload = 1;
			return 0;
		}
	}
	public void reload() //mouse Event
	{
		int bulletAmount = currentWeapon.getClipAmount();

		if((currentWeapon instanceof Gun) && totalBullet.get(currentWeapon)<=bulletAmount)
		{
			totalBullet.put(currentWeapon,99999);
		}
		if(totalBullet.get(currentWeapon)>= bulletAmount)
		{
			readyBullet.put(currentWeapon,bulletAmount);
			reload = 0;
		}

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
		//GameOver
		isDie = true;
    }

	public void moveHorizontal(Boolean b)
	{
		edit_map(0);

		x+=b?x_shift:-x_shift;
		if(x > MiniCSLaunch.MAINPANEL_WIDTH*0.5)
		{
			x -= x_shift;
			MainPanel.map_go();
		}
		else if(x < MiniCSLaunch.MAINPANEL_WIDTH*0.1)
			x += x_shift;
	}
	public void moveVertical(Boolean b)
	{
		edit_map(0);
		y += b?y_shift:-y_shift;
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
		if(reload!=0){
			g.drawString("reload!", x-15, y-32);
		}
		edit_map(map_value);

	}
	public void edit_map(int map_value)
	{
		for(int i=-1;i<1;i++)
			for(int j=-3;j<1;j++)
				MainPanel.map[x/10+i][y/10+j] = map_value;
	}
}
