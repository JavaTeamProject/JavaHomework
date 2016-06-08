package minics;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends MapElement{
	public double x;
	public double y;
	public double x_shift;
	public double y_shift;
	public int map_x_shift;
	public int exist;
	public int atk;
	public int E;
	
	public Bullet(int x,int y,int x_vector, int y_vector,int E)
	{
		this.x = x;
		this.y = y;
		this.map_x_shift = 10;
		this.x_shift = (x_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		this.y_shift = (y_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		
		this.exist = 1;
		this.E = E;
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
		if(x <= 0 || x >= MiniCSLaunch.FRAME_WIDTH || y <= 0 || y >= MiniCSLaunch.FRAME_HIGHT)	//fly outside
		{
			exist = 0;
		}	
		else if(MainPanel.map[(int)(x/10)][(int)(y/10)] == (E==2?1:2) )	//hit people
		{
			exist = 0;
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