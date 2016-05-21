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
	
	public Bullet(int x,int y,int x_vector, int y_vector)
	{
		this.x = x;
		this.y = y;
		this.map_x_shift = 10;
		this.x_shift = (x_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		this.y_shift = (y_vector/Math.sqrt(x_vector*x_vector+y_vector*y_vector))*10;
		
		this.exist = 1;
		
	}
	
	public void moveLeft()
	{
		x -= map_x_shift;
		if(x <= 0)	//頝�鈭���
		{
			exist = 0;
		}	
	}
	public void fly()
	{
		x+=x_shift;
		y+=y_shift;
		if(x <= 0 || x >= SmallSmallCS_GO.FRAME_WIDTH || y <= 0 || y >= SmallSmallCS_GO.FRAME_HIGHT)	//憌�鈭���
		{
			exist = 0;
		}	
		else if(MainPanel.map[(int)(x/10)][(int)(y/10)] == 2)	//��鈭箔�__Q
		{
			exist = 0;
		}
		else if(MainPanel.map[(int)(x/10)][(int)(y/10)] == 3 || MainPanel.map[(int)(x/10)][(int)(y/10)] == 4)	//����_>��
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