package minics;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends MapElement{

	public Obstacle(int x,int y)
	{
		this.x = x;
		this.y = y;
		this.map_x_shift = 10;
		this.map_value = 3;
		
		this.exist = 1;
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(x+1, y+1, 18, 8);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 20, 10);
		
		edit_map(map_value);
	}
	public void edit_map(int map_value)
	{
		for(int i=0;i<2;i++)
			MainPanel.map[x/10+i][y/10] = map_value;
	}
}