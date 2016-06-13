package minics;

import java.util.*;

import javax.swing.*;

import java.awt.Graphics;
import java.util.Timer;

public class MainPanel extends JPanel{
	
	public static final int REFRESH_TIME = 10;  //refresh time(ms)
	public static final int REFLY_TIME = 10;	//bullet fly time(ms)
	public static final int PIC_LENGTH = 10;    //game unit
	
	public static final int MAP_WIDTH = (int)(MiniCSLaunch.FRAME_WIDTH/PIC_LENGTH);
	public static final int MAP_HIGHT = (int)(MiniCSLaunch.FRAME_HIGHT/PIC_LENGTH);
	
	public static int[][] map;
	public static int level;
	public static long map_go_length;
	public static People main_role;
	public static Enemy enemy;
	public static HashSet<Enemy> enemy_hashset = new HashSet<Enemy>();
	public static HashSet<Enemy> out_enemy_hashset = new HashSet<Enemy>();
	public static HashSet<People> people_hashset = new HashSet<People>();
	public static HashSet<People> out_people_hashset = new HashSet<People>();	
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
				//System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public void initialHashSet()
	{
		initialFloor();
		initialObstacle();
		initialMainRole();
		/*initialEnemy();
		initialEnemy();*/
	}
	public void initialThread()
	{
		Thread paintThread = new PaintThread(this);
	    paintThread.start();
	    Thread bulletThread = new BulletThread();
	    bulletThread.start();
	    Thread enemyCreateThread = new EnemyCreateThread();
	    enemyCreateThread.start();
	    Thread enemyActionThread = new EnemyActionThread();
	    enemyActionThread.start();
	    
	}
	public void initialFloor()
	{
		for(int i=0; i<MiniCSLaunch.FRAME_WIDTH ; i+=10)
		{
			floor_hashset.add(new Floor(i, (int)(MiniCSLaunch.FRAME_HIGHT*0.75)));
		}
	}
	public void initialObstacle()
	{
		level = 0;
		for(int i=200; i<MiniCSLaunch.FRAME_WIDTH ; i+=20)
		{
			level += (int)(Math.random()*3)-1;
			//System.out.println(level);
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(i, (int)(MiniCSLaunch.FRAME_HIGHT*0.75)-j-10));
			}
		}
	}
	
	public void initialMainRole()
	{
		main_role = new MainRole((int)(MiniCSLaunch.FRAME_WIDTH*0.2),(int)(MiniCSLaunch.FRAME_HIGHT*0.75)-10,1);
		people_hashset.add(main_role);
	}
	
	public static void initialEnemy()
	{
		enemy_hashset.add(new Enemy((int)(MiniCSLaunch.FRAME_WIDTH*0.9), (int)(MiniCSLaunch.FRAME_WIDTH*0.7), 2));
	}
	
	public static void map_go()
	{
		map_go_length++;
		
		Iterator<Floor> itr0 = floor_hashset.iterator();	//??嚙踝蕭?嚙踝蕭??嚙踐秘嚙踐瓷
		while(itr0.hasNext()){
			itr0.next().moveLeft();
		}
		
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//??嚙踝蕭?嚙踝蕭?嚙踝蕭嚙踐鬲嚙踝蕭?嚙踝
		while(itr1.hasNext()){
			itr1.next().moveLeft();
		}
		
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//??嚙踝蕭?嚙踝蕭??嚙踝蕭??嚙踝蕭嚙�?
		while(itr2.hasNext()){
			itr2.next().moveLeft();
		}
		
		Iterator<People> itr3 = people_hashset.iterator();	//??嚙踝蕭?嚙踝蕭??嚙踝蕭?嚙踝蕭?嚙踝蕭
		while(itr3.hasNext()){
			People tmp = itr3.next();
			if(tmp.map_value !=1)
				tmp.moveLeft();
		}
		
		Iterator<Enemy> itr4 = enemy_hashset.iterator();
		while(itr4.hasNext()){
			People tmp = itr4.next();
			if(tmp.map_value !=2)
				tmp.moveLeft();
		}
		floor_hashset.add(new Floor((int)MiniCSLaunch.FRAME_WIDTH-10, (int)(MiniCSLaunch.FRAME_HIGHT*0.75))); //��?��?���?

		if(map_go_length%2 == 0)
		{
			
			level += (int)(Math.random()*3)-1;
			//System.out.println(level);
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(((int)MiniCSLaunch.FRAME_WIDTH/20)*19, (int)(MiniCSLaunch.FRAME_HIGHT*0.75)-j-10));	//嚙踝蕭?嚙踝蕭?嚙踐筐嚙踐鬲嚙踝蕭?嚙踝
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Iterator<Floor> itr0 = floor_hashset.iterator();	//嚙踐嚙踐秘嚙踐瓷
		while(itr0.hasNext()){
			Floor tmp = itr0.next();
			if(tmp.exist == 0)
				out_floor_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		floor_hashset.removeAll(out_floor_hashset);	//??嚙踝蕭?嚙踝蕭?嚙踝蕭嚙踝嚙踐?嚙踝蕭嚙踐嚙踝蕭??嚙踐秘嚙踐瓷嚙踝蕭
		
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//嚙踐嚙踝蕭謚穿蕭謕
		while(itr1.hasNext()){
			Obstacle tmp = itr1.next();
			if(tmp.exist == 0)
				out_obstacle_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		obstacle_hashset.removeAll(out_obstacle_hashset);	//??嚙踝蕭?嚙踝蕭?嚙踝蕭嚙踝嚙踐?嚙踝蕭嚙踐嚙踝蕭??嚙踝蕭謚穿蕭謕嚙踝蕭
		
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//嚙踐?嚙踝蕭??嚙踝蕭嚙�?
		while(itr2.hasNext()){
			Bullet tmp = itr2.next();
			if(tmp.exist == 0)
				out_bullet_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		bullet_hashset.removeAll(out_bullet_hashset);	//??嚙踝蕭?嚙踝蕭?嚙踝蕭嚙踝嚙踝蕭?嚙踝嚙踐嚙踝蕭??嚙踝蕭??嚙踝蕭??嚙踝蕭嚙�?
		
		Iterator<People> itr3 = people_hashset.iterator();	//嚙踐?嚙踝蕭蝞
		while(itr3.hasNext()){
			People tmp = itr3.next();
			if(tmp.exist == 0)
				out_people_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		people_hashset.removeAll(out_people_hashset);
		
		Iterator<Enemy> itr4 = enemy_hashset.iterator();	//嚙踐?嚙踝蕭蝞
		while(itr4.hasNext()){
			Enemy tmp = itr4.next();
			if(tmp.exist == 0)
				out_enemy_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		enemy_hashset.removeAll(out_enemy_hashset);	//??嚙踝蕭?嚙踝蕭?嚙踝蕭嚙踝嚙踝蕭?嚙踝嚙踐嚙踝蕭??嚙踝蕭?嚙踝蕭嚙�?
		
	}

	
}