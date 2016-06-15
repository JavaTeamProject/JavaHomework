package minics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class Bullet extends MapElement{
	public double x;
	public double y;
	public double x_shift;
	public double y_shift;
	public int atk;
	public int E;	//who's bullet  1:main_role  2:enemy
	
	public Bullet(int x,int y,int x_vector, int y_vector,int E,int atk)
	{
		this.x = x;
		this.y = y;
		this.map_x_shift = 10;
		this.map_value = 0;
		this.x_shift = (x_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		this.y_shift = (y_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		
		this.exist = 1;
		this.E = E;
		this.atk = atk;
	}
	
	public void moveLeft()
	{
		x -= map_x_shift;
		if(x <= 0)
		{
			exist = 0;
		}	
	}
	public void fly()
	{
		x+=x_shift;
		y+=y_shift;
		if(x <= 0 || x >= MiniCSLaunch.MAINPANEL_WIDTH || y <= 0 || y >= MiniCSLaunch.MAINPANEL_HIGHT)	//fly outside
		{
			exist = 0;
		}	
		else if(MainPanel.map[(int)(x/10)][(int)(y/10)] == (E==2?1:2) )	//hit people
		{
			if(E==1){
				Iterator<Enemy> itr4 = MainPanel.enemy_hashset.iterator();
				while(itr4.hasNext()){
					Enemy tmp = itr4.next();
					if((int)(tmp.x/10-1)==(int)(x/10) && (int)(tmp.y/10-3)==(int)(y/10)
							|| (int)(tmp.x/10-1)==(int)(x/10) && (int)(tmp.y/10-2)==(int)(y/10)
							|| (int)(tmp.x/10-1)==(int)(x/10) && (int)(tmp.y/10-1)==(int)(y/10)
							|| (int)(tmp.x/10-1)==(int)(x/10) && (int)(tmp.y/10)==(int)(y/10)
							|| (int)(tmp.x/10)==(int)(x/10) && (int)(tmp.y/10-3)==(int)(y/10)
							|| (int)(tmp.x/10)==(int)(x/10) && (int)(tmp.y/10-2)==(int)(y/10)
							|| (int)(tmp.x/10)==(int)(x/10) && (int)(tmp.y/10-1)==(int)(y/10)
							|| (int)(tmp.x/10)==(int)(x/10) && (int)(tmp.y/10)==(int)(y/10))
					{
						tmp.hit(atk);
						if(!(MainPanel.main_role.currentWeapon instanceof SniperRfile))
						{
							exist = 0;
							break;
						}
					}
				}
			}
			else if(E==2)
			{
				MainPanel.main_role.hit(atk);
				if(!(MainPanel.main_role.currentWeapon instanceof SniperRfile))
				{
					exist = 0;
				}
			}
		}
		else if(MainPanel.map[(int)(x/10)][(int)(y/10)] == 3 || MainPanel.map[(int)(x/10)][(int)(y/10)] == 4)	//hit floor or obstacle
		{
			exist = 0;
		}
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval((int)x-2,(int)y-2,6,6);
		
	}

}
