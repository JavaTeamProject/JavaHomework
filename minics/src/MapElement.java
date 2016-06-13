package minics;

import java.awt.Graphics;

public class MapElement{
	
	public int x;
	public int y;
	public int map_x_shift;
	public int map_value;
	public int exist;
	
	public void moveLeft()
	{
		edit_map(0);
		x -= map_x_shift;
		if(x < 0)	
		{
			exist = 0;
		}	
	}
	public void draw(Graphics g){};
	public void edit_map(int map_value){};
}