package minics;

import java.awt.Color;
import java.awt.Graphics;

public class Floor extends MapElement{

	public Floor(int x,int y)
	{
		this.x = x;
		this.y = y;
		this.map_x_shift = 10;
		this.map_value = 4;
		
		this.exist = 1;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawLine(x, y, x+20, y);
		g.setColor(new Color(125, 102, 66));
		g.fillRect(x, y+1, 20, (int)(MiniCSLaunch.FRAME_HIGHT*0.25)-2);
		
		
		edit_map(map_value);
	}
	public void edit_map(int map_value)
	{
		for(int i=0;i<2;i++)
			for(int j=0 ; j<6 ;j++)
			MainPanel.map[x/10+i][y/10+j] = map_value;
	}
}