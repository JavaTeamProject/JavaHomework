package minics;

import java.util.*;

import javax.swing.*;

import java.awt.Graphics;

public class MainPanel extends JPanel{
	
	public static final int REFRESH_TIME = 10;	//螢幕刷新時間(ms)
	public static final int REFLY_TIME = 10;	//子彈移動時間間隔(ms)
	public static final int PIC_LENGTH = 10;	//地圖單位方塊長度
	public static final int MAP_WIDTH = (int)(SmallSmallCS_GO.FRAME_WIDTH/PIC_LENGTH);
	public static final int MAP_HIGHT = (int)(SmallSmallCS_GO.FRAME_HIGHT/PIC_LENGTH);
	
	public static int[][] map;
	public static int level;
	public static long map_go_length;
	public static People main_role;
	public static HashSet<People> people_hashset = new HashSet<People>();	//存People物件
	public static HashSet<People> out_people_hashset = new HashSet<People>();	//存跑出視窗外的People物件
	public static HashSet<Bullet> bullet_hashset = new HashSet<Bullet>();	//存Bullet物件
	public static HashSet<Bullet> out_bullet_hashset = new HashSet<Bullet>();	//存跑出視窗外的Bullet物件
	public static HashSet<Obstacle> obstacle_hashset = new HashSet<Obstacle>();	//存Obstacle物件
	public static HashSet<Obstacle> out_obstacle_hashset = new HashSet<Obstacle>();	//存跑出視窗外的Obstacle物件
	public static HashSet<Floor> floor_hashset = new HashSet<Floor>();	//存Floor物件
	public static HashSet<Floor> out_floor_hashset = new HashSet<Floor>();	//存跑出視窗外的Floor物件
	
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
	
	//地圖值 [0]:無物品 [1]:主角 [2]:敵人 [3]:障礙物 [4]:地板
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
		initialEnemy();
		
	}
	public void initialThread()
	{
		Thread paintThread = new PaintThread(this);
	    paintThread.start();
	    Thread bulletThread = new BulletThread();
	    bulletThread.start();
	}
	public void initialFloor()
	{
		for(int i=0; i<SmallSmallCS_GO.FRAME_WIDTH ; i+=20)
		{
			floor_hashset.add(new Floor(i, (int)(SmallSmallCS_GO.FRAME_HIGHT*0.75)));
		}
	}
	public void initialObstacle()
	{
		level = 0;
		for(int i=200; i<SmallSmallCS_GO.FRAME_WIDTH ; i+=20)
		{
			level += (int)(Math.random()*3)-1;
			//System.out.println(level);
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(i, (int)(SmallSmallCS_GO.FRAME_HIGHT*0.75)-j-10));
			}
		}
	}
	
	public void initialMainRole()
	{
		main_role = new MainRole((int)(SmallSmallCS_GO.FRAME_WIDTH*0.2),(int)(SmallSmallCS_GO.FRAME_HIGHT*0.75)-10,1);
		people_hashset.add(main_role);
	}
	
	public void initialEnemy()
	{
		people_hashset.add(new Enemy(700,300,2));
	}
	
	public static void map_go()
	{
		map_go_length++;
		
		Iterator<Floor> itr0 = floor_hashset.iterator();	//移動地板
		while(itr0.hasNext()){
			itr0.next().moveLeft();
		}
		
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//移動障礙物
		while(itr1.hasNext()){
			itr1.next().moveLeft();
		}
		
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//移動子彈
		while(itr2.hasNext()){
			itr2.next().moveLeft();
		}
		
		Iterator<People> itr3 = people_hashset.iterator();	//移動人物
		while(itr3.hasNext()){
			People tmp = itr3.next();
			if(tmp.map_value !=1)
				tmp.moveLeft();
		}
		if(map_go_length%2 == 0)
		{
			floor_hashset.add(new Floor(((int)SmallSmallCS_GO.FRAME_WIDTH/20)*19, (int)(SmallSmallCS_GO.FRAME_HIGHT*0.75))); //新增地板
			
			level += (int)(Math.random()*3)-1;
			//System.out.println(level);
			level = (level==-1)?0:level;
			level = (level==7)?6:level;
			for(int j=0 ; j<level*10 ; j+=10)
			{
				obstacle_hashset.add(new Obstacle(((int)SmallSmallCS_GO.FRAME_WIDTH/20)*19, (int)(SmallSmallCS_GO.FRAME_HIGHT*0.75)-j-10));	//新增障礙物
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Iterator<Floor> itr0 = floor_hashset.iterator();	//畫地板
		while(itr0.hasNext()){
			Floor tmp = itr0.next();
			if(tmp.exist == 0)
				out_floor_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		floor_hashset.removeAll(out_floor_hashset);	//移除掉跑出去的地板們
		
		Iterator<Obstacle> itr1 = obstacle_hashset.iterator();	//畫障礙物
		while(itr1.hasNext()){
			Obstacle tmp = itr1.next();
			if(tmp.exist == 0)
				out_obstacle_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		obstacle_hashset.removeAll(out_obstacle_hashset);	//移除掉跑出去的障礙物們
		
		Iterator<Bullet> itr2 = bullet_hashset.iterator();	//畫子彈
		while(itr2.hasNext()){
			Bullet tmp = itr2.next();
			if(tmp.exist == 0)
				out_bullet_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		bullet_hashset.removeAll(out_bullet_hashset);	//移除掉飛出去的子彈們
		
		Iterator<People> itr3 = people_hashset.iterator();	//畫人物
		while(itr3.hasNext()){
			People tmp = itr3.next();
			if(tmp.exist == 0)
				out_people_hashset.add(tmp);
			else
				tmp.draw(g);
		}
		people_hashset.removeAll(out_people_hashset);	//移除掉飛出去的人們
		
	}

	
}