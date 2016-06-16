package minics;

import java.util.*;

import javax.swing.*;

import java.awt.Graphics;
import java.util.Timer;

public class MainPanel extends JPanel{
	
	public static final int REFRESH_TIME = 10;  //refresh time(ms)
	public static final int REFLY_TIME = 10;	//bullet fly time(ms)
	public static final int PIC_LENGTH = 10;    //game unit
	
	public static final int MAP_WIDTH = (int)(MiniCSLaunch.MAINPANEL_WIDTH/PIC_LENGTH);
	public static final int MAP_HIGHT = (int)(MiniCSLaunch.MAINPANEL_HIGHT/PIC_LENGTH);
	
	public static int[][] map;
	public static int level;
	public static long map_go_length;
	public static MainRole main_role;
	public static HashSet<Enemy> enemy_hashset = new HashSet<Enemy>();
	public static HashSet<Enemy> out_enemy_hashset = new HashSet<Enemy>();
	public static HashSet<Bullet> bullet_hashset = new HashSet<Bullet>();	
	public static HashSet<Bullet> out_bullet_hashset = new HashSet<Bullet>();	
	public static HashSet<Obstacle> obstacle_hashset = new HashSet<Obstacle>();	
	public static HashSet<Obstacle> out_obstacle_hashset = new HashSet<Obstacle>();	
	public static HashSet<Floor> floor_hashset = new HashSet<Floor>();
	public static HashSet<Floor> out_floor_hashset = new HashSet<Floor>();
	
	public MainPanel() {
		initialEvent();
		initialMap();
		initialHashSet();
		initialThread();
	}
	
	public void initialEvent()
	{
		addKeyListener(new EventControl());
		addMouseListener(new EventControl());
		setFocusable(true);
	}
	
	public void initialMap()
	{
		map = new int[MAP_WIDTH][MAP_HIGHT];
		for(int i = 0;i<MAP_WIDTH;i++)
		{
			for(int j = 0; j<MAP_HIGHT ; j++)
			{
				map[i][j] = 0;
			}
		}
	}
	
	public void initialHashSet()
	{
		initialFloor();
		initialObstacle();
		initialMainRole();
	}
	public void initialThread()
	{
		Thread paintThread = new PaintThread(this);
	    paintThread.start();
	    Thread enemyCreateThread = new EnemyCreateThread();
	    enemyCreateThread.start();
	    Thread enemyActionThread = new EnemyActionThread();
	    enemyActionThread.start();
	}
	public void initialFloor()
	{
		for(int i=0; i<MiniCSLaunch.MAINPANEL_WIDTH ; i+=10)
		{
			floor_hashset.add(new Floor(i, (int)(MiniCSLaunch.MAINPANEL_HIGHT*0.75)));
		}
	}
	public void initialObstacle()
	{
		level = 0;
		for(int i=200; i<MiniCSLaunch.MAINPANEL_WIDTH ; i+=20)
		{
			level += (int)(Math.random()*3)-1;
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(i, (int)(MiniCSLaunch.MAINPANEL_HIGHT*0.75)-j-10));
			}
		}
	}
	
	public void initialMainRole()
	{
		main_role = new MainRole((int)(MiniCSLaunch.MAINPANEL_WIDTH*0.2),(int)(MiniCSLaunch.MAINPANEL_HIGHT*0.75)-10);
	}
	
	public static void map_go()
	{
		map_go_length++;
		main_role.setDistance(1);
		MainPanel.main_role.setMoney(0,1);
		
		Iterator<Floor> itr0 = floor_hashset.iterator();	//
		while(itr0.hasNext()){
			itr0.next().moveLeft();
		}
		
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//
		while(itr1.hasNext()){
			itr1.next().moveLeft();
		}
		
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//
		while(itr2.hasNext()){
			itr2.next().moveLeft();
		}
		
		Iterator<Enemy> itr4 = enemy_hashset.iterator();
		while(itr4.hasNext()){
			itr4.next().moveLeft();
		}
		
		
		floor_hashset.add(new Floor((int)MiniCSLaunch.MAINPANEL_WIDTH-10, (int)(MiniCSLaunch.MAINPANEL_HIGHT*0.75))); //

		if(map_go_length%2 == 0)
		{
			
			level += (int)(Math.random()*3)-1;
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(((int)MiniCSLaunch.MAINPANEL_WIDTH/20)*19, (int)(MiniCSLaunch.MAINPANEL_HIGHT*0.75)-j-10));	//
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		//draw floor
		Iterator<Floor> itr0 = floor_hashset.iterator();
		while(itr0.hasNext()){
			Floor tmp = itr0.next();
			if(tmp.exist == 0)
				out_floor_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		floor_hashset.removeAll(out_floor_hashset);	//
		out_floor_hashset.clear();
		
		//draw obstacle
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//
		while(itr1.hasNext()){
			Obstacle tmp = itr1.next();
			if(tmp.exist == 0)
				out_obstacle_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		obstacle_hashset.removeAll(out_obstacle_hashset);	//
		out_obstacle_hashset.clear();
		
		//draw bullet
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//
		while(itr2.hasNext()){
			Bullet tmp = itr2.next();
			if(tmp.exist == 0)
				out_bullet_hashset.add(tmp);
			else
			{
				tmp.fly();
				tmp.draw(g);
			}
		}
		bullet_hashset.removeAll(out_bullet_hashset);	//
		out_bullet_hashset.clear();
		
		//draw enemy
		Iterator<Enemy> itr4 = enemy_hashset.iterator();	//
		while(itr4.hasNext()){
			Enemy tmp = itr4.next();
			if(tmp.exist == 0)
				out_enemy_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		enemy_hashset.removeAll(out_enemy_hashset);	//
		out_enemy_hashset.clear();
		
		//draw main role
		main_role.draw(g);
	}
}