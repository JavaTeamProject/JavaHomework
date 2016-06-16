package minics;

import java.util.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;



public class WeaponPanel extends JPanel {

	final double WEAPON_ATTR_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.15;
	final double GUN_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.25;
	final double MACHINE_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.37;
	final double SNIPER_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.49;
	final double SHOT_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.61;
	
	final double BUTTON_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.02;
	final double AVAILABLE_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
	final double AVAILABLE_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.55;
	final double TOTAL_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
	final double TOTAL_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.63;
	final double COST_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
	final double COST_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.71;
	final double ROLE_ATTR_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.75;
	final double ROLE_ATTR_S_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.9;
	
	
	JButton gun_button;
	JButton gun_button_y;
	JButton machine_button;
	JButton machine_button_y;
	JButton sniper_button;
	JButton sniper_button_y;
	JButton shot_button;
	JButton shot_button_y;
	
	
	private JLabel gun_available_label;
	private JLabel gun_total_label;
	private JLabel gun_cost_label;
	private JLabel machine_available_label;
	private JLabel machine_total_label;
	private JLabel machine_cost_label;
	private JLabel sniper_available_label;
	private JLabel sniper_total_label;
	private JLabel sniper_cost_label;
	private JLabel shot_available_label;
	private JLabel shot_total_label;
	private JLabel shot_cost_label;
	
	private JLabel money_s_label;
	private JLabel ko_s_label;
	private JLabel distance_s_label;
	
	
	public WeaponPanel() {
		initialButton();
		initialLable();
	    setLayout(null);
	}
	
	public void initialButton()
	{
		// Gun
	    ImageIcon icon5 = new ImageIcon("img/gun_button.png");
	    gun_button = new JButton(icon5);
	    gun_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.24),(int)BUTTON_HIGHT,130,130);
	    gun_button.addActionListener(new EventControl());
	    gun_button.setActionCommand("gun_button");
	    gun_button.setVisible(false);
	    add(gun_button);
	    
	    ImageIcon icon15 = new ImageIcon("img/gun_button_y.png");
	    gun_button_y = new JButton(icon15);
	    gun_button_y.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.24),(int)BUTTON_HIGHT,130,130);
	    gun_button_y.addActionListener(new EventControl());
	    gun_button_y.setActionCommand("gun_button");
	    gun_button_y.setVisible(true);
	    add(gun_button_y);
	    
	    // MachineGun
	    ImageIcon icon6 = new ImageIcon("img/machinegun_button.png");
	    machine_button = new JButton(icon6);
	    machine_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.36),(int)BUTTON_HIGHT,132,132);
	    machine_button.addActionListener(new EventControl());
	    machine_button.setActionCommand("machine_button");
	    machine_button.setVisible(true);
	    add(machine_button);
	    
	    ImageIcon icon16 = new ImageIcon("img/machinegun_button_y.png");
        machine_button_y = new JButton(icon16);
        machine_button_y.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.36),(int)BUTTON_HIGHT,132,132);
        machine_button_y.addActionListener(new EventControl());
        machine_button_y.setActionCommand("machine_button");
        machine_button_y.setVisible(false);
        add(machine_button_y);
	    
	    // SniperRfile
	    ImageIcon icon7 = new ImageIcon("img/sniper_button.png");
	    sniper_button = new JButton(icon7);
	    sniper_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.48),(int)BUTTON_HIGHT,130,130);
	    sniper_button.addActionListener(new EventControl());
	    sniper_button.setActionCommand("sniper_button");
	    sniper_button.setVisible(true);
	    add(sniper_button);
	    
	    ImageIcon icon17 = new ImageIcon("img/sniper_button_y.png");
	    sniper_button_y = new JButton(icon17);
	    sniper_button_y.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.48),(int)BUTTON_HIGHT,130,130);
	    sniper_button_y.addActionListener(new EventControl());
	    sniper_button_y.setActionCommand("sniper_button");
	    sniper_button_y.setVisible(false);
	    add(sniper_button_y);
        
	    
	    // ShotGun
	    ImageIcon icon8 = new ImageIcon("img/shotgun_button.png");
	    shot_button = new JButton(icon8);
	    shot_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.6),(int)BUTTON_HIGHT,130,130);
	    shot_button.addActionListener(new EventControl());
	    shot_button.setActionCommand("shot_button");
	    shot_button.setVisible(true);
	    add(shot_button);
        
        ImageIcon icon18 = new ImageIcon("img/shotgun_button_y.png");
	    shot_button_y = new JButton(icon18);
	    shot_button_y.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.6),(int)BUTTON_HIGHT,130,130);
	    shot_button_y.addActionListener(new EventControl());
	    shot_button_y.setActionCommand("shot_button");
	    shot_button_y.setVisible(false);
	    add(shot_button_y);
	}
	public void initialLable()
	{
		// Weapon NO.
		ImageIcon icon20 = new ImageIcon("img/Weapon_NO.png");
	    JLabel weapon_no = new JLabel(icon20);
	    weapon_no.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.01),(int)(MiniCSLaunch.WEAPONPANEL_HIGHT*0.05),200,150);
	    add(weapon_no);
		
		// Weapon Attribute
	    ImageIcon icon2 = new ImageIcon("img/available_label.png");
	    JLabel available_label = new JLabel(icon2);
	    available_label.setBounds((int)WEAPON_ATTR_WIDTH,(int)AVAILABLE_HIGHT,100,20);
	    add(available_label);
	    
	    ImageIcon icon3 = new ImageIcon("img/total_label.png");
	    JLabel total_label = new JLabel(icon3);
	    total_label.setBounds((int)WEAPON_ATTR_WIDTH,(int)TOTAL_HIGHT,100,20);
	    add(total_label);
	    
	    ImageIcon icon4 = new ImageIcon("img/cost_label.png");
	    JLabel cost_label = new JLabel(icon4);
	    cost_label.setBounds((int)WEAPON_ATTR_WIDTH,(int)COST_HIGHT,100,20);
	    add(cost_label);
		
		/////Gun
		//	int gun_available = MainPanel.main_role.readyBullet.get(new Gun());
	    gun_available_label = new JLabel("gunavailable");
	    gun_available_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    gun_available_label.setForeground(Color.white);	    
	    gun_available_label.setBounds((int)GUN_WIDTH,(int)AVAILABLE_HIGHT,100,20);
	    add(gun_available_label); 
	    
	    //	int gun_total = MainPanel.main_role.totalBullet.get(new Gun());
	    gun_total_label = new JLabel("gun_total");
	    gun_total_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    gun_total_label.setForeground(Color.white);	    
	    gun_total_label.setBounds((int)GUN_WIDTH,(int)TOTAL_HIGHT,100,20);
	    add(gun_total_label);
	    
	    gun_cost_label = new JLabel("gun cost");
	    gun_cost_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    gun_cost_label.setForeground(Color.white);	    
	    gun_cost_label.setBounds((int)GUN_WIDTH,(int)COST_HIGHT,100,20);
	    add(gun_cost_label);
	    
	    /////MachineGun
	    //	int machine_available = MainPanel.main_role.readyBullet.get(new MachineGun());
	    machine_available_label = new JLabel("machine_available");
	    machine_available_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    machine_available_label.setForeground(Color.white);	    
	    machine_available_label.setBounds((int)MACHINE_WIDTH,(int)AVAILABLE_HIGHT,100,20);
	    add(machine_available_label);
	    
	    //	int machine_total = MainPanel.main_role.totalBullet.get(new MachineGun());
	    machine_total_label = new JLabel("machine_total");
	    machine_total_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    machine_total_label.setForeground(Color.white);	    
	    machine_total_label.setBounds((int)MACHINE_WIDTH,(int)TOTAL_HIGHT,100,20);
	    add(machine_total_label);
	    
	    machine_cost_label = new JLabel("machine cost");
	    machine_cost_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    machine_cost_label.setForeground(Color.white);	    
	    machine_cost_label.setBounds((int)MACHINE_WIDTH,(int)COST_HIGHT,100,20);
	    add(machine_cost_label);
    
	    /////SniperRfile
	    //	int sniper_available = MainPanel.main_role.readyBullet.get(new SniperRfile());
	    sniper_available_label = new JLabel("sniper_available");
	    sniper_available_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    sniper_available_label.setForeground(Color.white);	    
	    sniper_available_label.setBounds((int)SNIPER_WIDTH,(int)AVAILABLE_HIGHT,100,20);
	    add(sniper_available_label);
	    
	    //	int sniper_total = MainPanel.main_role.totalBullet.get(new SniperRfile());
	    sniper_total_label = new JLabel("sniper_total");
	    sniper_total_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    sniper_total_label.setForeground(Color.white);	    
	    sniper_total_label.setBounds((int)SNIPER_WIDTH,(int)TOTAL_HIGHT,100,20);
	    add(sniper_total_label);
	    
	    sniper_cost_label = new JLabel("sniper cost");
	    sniper_cost_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    sniper_cost_label.setForeground(Color.white);
	    sniper_cost_label.setBounds((int)SNIPER_WIDTH,(int)COST_HIGHT,100,20);
	    add(sniper_cost_label);
    
	    ///// ShotGun
	    //	int shot_available = MainPanel.main_role.readyBullet.get(new ShotGun());
	    shot_available_label = new JLabel("shot_available");
	    shot_available_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    shot_available_label.setForeground(Color.white);	    
	    shot_available_label.setBounds((int)SHOT_WIDTH,(int)AVAILABLE_HIGHT,100,20);
	    add(shot_available_label);
	    
	    //	int shot_total = MainPanel.main_role.totalBullet.get(new ShotGun());
	    shot_total_label = new JLabel("shot_total");
	    shot_total_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    shot_total_label.setForeground(Color.white);	    
	    shot_total_label.setBounds((int)SHOT_WIDTH,(int)TOTAL_HIGHT,100,20);
	    add(shot_total_label);
	    
	    shot_cost_label = new JLabel("shot cost");
	    shot_cost_label.setFont(new Font("Verdana", Font.PLAIN, 16));
	    shot_cost_label.setForeground(Color.white);	    
	    shot_cost_label.setBounds((int)SHOT_WIDTH,(int)COST_HIGHT,100,20);
	    add(shot_cost_label);
	    
	    
	    // MainRole Attribute
	    //money
	    ImageIcon icon10 = new ImageIcon("img/money_label.png");
	    JLabel money_label = new JLabel(icon10);
	    money_label.setBounds((int)ROLE_ATTR_WIDTH,20,100,20);
	    add(money_label);
	    
	    int money = MainPanel.main_role.getMoney();
	    
	    money_s_label = new JLabel(money+"");
	    money_s_label.setFont(new Font("Verdana", Font.BOLD, 28));
	    money_s_label.setForeground(Color.yellow);
	    money_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,20,100,30);
	    add(money_s_label);
	    //ko
	    ImageIcon icon11 = new ImageIcon("img/ko_label.png");
	    JLabel ko_label = new JLabel(icon11);
	    ko_label.setBounds((int)ROLE_ATTR_WIDTH,100,150,20);
	    add(ko_label);
	   
	    int ko = MainPanel.main_role.getKill();
	    
	    ko_s_label = new JLabel(ko+"");
	    ko_s_label.setFont(new Font("Verdana", Font.BOLD, 20));
	    ko_s_label.setForeground(Color.white);
	    ko_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,100,100,20);
	    add(ko_s_label);
	    //distance
	    ImageIcon icon12 = new ImageIcon("img/distance_label.png");
	    JLabel distance_label = new JLabel(icon12);
	    distance_label.setBounds((int)ROLE_ATTR_WIDTH,120,140,20);
	    add(distance_label);
	    
	    int distance = MainPanel.main_role.getDistance();
	    
	    distance_s_label = new JLabel(distance+"");
	    distance_s_label.setFont(new Font("Verdana", Font.BOLD, 20));
	    distance_s_label.setForeground(Color.white);
	    distance_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,120,100,20);
	    add(distance_s_label);
	    
	    //background
	    ImageIcon icon1 = new ImageIcon("img/bg.png");
	    JLabel bg_label = new JLabel(icon1);
	    bg_label.setBounds(0,-20,(int)MiniCSLaunch.WEAPONPANEL_WIDTH,(int)MiniCSLaunch.WEAPONPANEL_HIGHT);
	    add(bg_label);
	    
	}
	
	public void refresh()
	{
		gun_available_label.setText(MainPanel.main_role.getReady("gun")+"");
		gun_total_label.setText(MainPanel.main_role.getTotal("gun")+"");
		gun_cost_label.setText(new Gun().getPrice()+"");
		machine_available_label.setText(MainPanel.main_role.getReady("machinegun")+"");
		machine_total_label.setText(MainPanel.main_role.getTotal("machinegun")+"");
		machine_cost_label.setText(new MachineGun().getPrice()+"");
		sniper_available_label.setText(MainPanel.main_role.getReady("sniperrfile")+"");
		sniper_total_label.setText(MainPanel.main_role.getTotal("sniperrfile")+"");
		sniper_cost_label.setText(new SniperRfile().getPrice()+"");
		shot_available_label.setText(MainPanel.main_role.getReady("shotgun")+"");
		shot_total_label.setText(MainPanel.main_role.getTotal("shotgun")+"");
		shot_cost_label.setText(new ShotGun().getPrice()+"");
		
		money_s_label.setText(MainPanel.main_role.getMoney()+"");
		ko_s_label.setText(MainPanel.main_role.getKill()+"");
		distance_s_label.setText(MainPanel.main_role.getDistance()+"");
	}
}

