package minics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Random;

public class Enemy extends MapElement{
	
	public Color color = Color.PINK;
	public int x_shift;
	public int y_shift;
	public final int max_hp = 5;
	public int hp;
	public Weapon currentWeapon;
	public HashMap<Weapon, Integer> readyBullet = new HashMap<Weapon, Integer>();
	public HashMap<Weapon, Integer> totalBullet = new HashMap<Weapon, Integer>();
	
	private int die = 0;
	
	

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		
		x_shift = 10;
		y_shift = 10;
		map_x_shift = 10;
		
		map_value = 2;
		hp = 5;
		
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
		edit_map(0);
		x -= map_x_shift;
		if(x < 10)	
		{
			exist = 0;
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
	
	public int getAtk()
	{
		return currentWeapon.getAtk();
	}
	public int shot() 
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
			//wait for random time
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			reload();
			return 1;
		}
		else
		{
			return 0;
		}		
	}

	public void reload() 
	{
		int bulletAmount = currentWeapon.getClipAmount(); 
		readyBullet.put(currentWeapon,bulletAmount);
		
	}
	public void die()
	{
		MainPanel.main_role.setKill(1);
		MainPanel.main_role.setMoney(0,100);
		die = 1 ;
		/*edit_map(0);
		exist = 0;*/
		/*Timer timer = new Timer();
		timer.schedule(new Die(),0 ,100);*/
	}
	
	
	public void moveHorizontal(Boolean b)
	{
		edit_map(0);
		
		x+=b?x_shift:-x_shift;
	}
	public void moveVertical(Boolean b)
	{
		edit_map(0);
		y += b?y_shift:-y_shift;
	}
	
	public void action(){
		if(die==0){
			int randomNum;
			Random ran = new Random();
			randomNum = (ran.nextInt(3)) % 3;
				
			switch(randomNum){
				case 0: //toward to main_role
					if(this.x < MainPanel.main_role.x){
						this.moveHorizontal(true);
					}
					else if(this.x > MainPanel.main_role.x){
						this.moveHorizontal(false);
					}
					else ;
					break;
				case 1: //shot
					int atk = getAtk();
					MainPanel.bullet_hashset.add(new Bullet(this.x, this.y, MainPanel.main_role.x-this.x, MainPanel.main_role.y-this.y,2,atk));
					break;
				case 2: //stay
					break;
			}
		}
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
		
		
			g.setColor(color);
			g.fillOval(x-10,y-30,20,20);
			g.drawLine(x, y-10, x, y+2);
			g.drawLine(x, y-8, x+7, y);
			g.drawLine(x, y-8, x-7, y);
			g.drawLine(x, y+1, x+7, y+9);
			g.drawLine(x, y+1, x-7, y+9);
			g.setColor(Color.DARK_GRAY);
			g.drawRect(x-15, y-42, 30, 8);
			g.setColor(Color.RED);
			g.fillRect(x-14, y-41, 29, 7);
			
			g.setColor(Color.GREEN);
			g.fillRect(x-14, y-41, hp*29/max_hp, 7);
			
			edit_map(map_value);
		}
		else if(die==1)
		{
			g.setColor(color);
			g.fillOval(x-30,y-10,20,20);
			g.drawLine(x-10,y, x+5, y);
			g.drawLine(x+5, y, x+5, y+10);
			g.drawLine(x+5, y+10, x+10, y+10);
			g.drawLine(x-5, y, x-5, y+10);
			
			edit_map(0);
			die = -1;
		}
		else{
			g.setColor(color);
			g.fillOval(x-30,y-10,20,20);
			g.drawLine(x-10,y, x+5, y);
			g.drawLine(x+5, y, x+5, y+10);
			g.drawLine(x+5, y+10, x+10, y+10);
			g.drawLine(x-5, y, x-5, y+10);
		}
	}
	public void edit_map(int map_value)
	{
		for(int i=-1;i<1;i++)
			for(int j=-3;j<1;j++)
				MainPanel.map[x/10+i][y/10+j] = map_value;
	}
}
