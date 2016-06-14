package minics;

import java.util.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;



public class WeaponPanel extends JPanel {

	public WeaponPanel() {
				
	//	JFrame frame = new JFrame();
	 //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//application will be closed when you close frame
	 //   frame.setSize(1280,220);
	 //   frame.setLocation(0,0);

		final double BUTTON_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
		final double BUTTON_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.02;
		final double AVAILABLE_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
		final double AVAILABLE_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.55;
		final double TOTAL_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
		final double TOTAL_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.63;
		final double COST_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH;
		final double COST_HIGHT= MiniCSLaunch.WEAPONPANEL_HIGHT*0.71;
		final double ROLE_ATTR_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.75;
		final double ROLE_ATTR_S_WIDTH = MiniCSLaunch.WEAPONPANEL_WIDTH*0.9;

	    
	    setLayout(null);
	    
	    ImageIcon icon1 = new ImageIcon("img/bg.png");
	    JLabel bg_label = new JLabel(icon1);
	    bg_label.setBounds(0,-20,(int)MiniCSLaunch.WEAPONPANEL_WIDTH,(int)MiniCSLaunch.WEAPONPANEL_HIGHT);
	/*    
	    // CD
	    
	    ImageIcon icon9 = new ImageIcon("img/cd_label.png");
	    JLabel cd_label = new JLabel(icon9);
	    cd_label.setBounds(0,140,200,20);
	    add(cd_label);
	    
	    ImageIcon icon14 = new ImageIcon("img/cd_circle8.png");
	    JLabel cd_circle = new JLabel(icon14);
	    cd_circle.setBounds(30,0,150,150);
	    add(cd_circle);
	 */   
	    // Gun
	    
	    ImageIcon icon5 = new ImageIcon("img/gun_button.png");
	    JButton gun_button = new JButton(icon5);
	    gun_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.24),(int)BUTTON_HIGHT,130,130);
	    gun_button.addActionListener(new ButtonListener());
	    gun_button.setActionCommand("gun_button");
	    add(gun_button);
	    
	 //   int gun_available = MainPanel.main_role.readyBullet.get(new Gun());
	    
	    JLabel gun_available_label = new JLabel("gunavailable");
	    gun_available_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    gun_available_label.setBounds(350,(int)AVAILABLE_HIGHT,100,20);
	    add(gun_available_label); 
	    
	 //   int gun_total = MainPanel.main_role.totalBullet.get(new Gun());
	    
	    JLabel gun_total_label = new JLabel("gun_total");
	    gun_total_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    gun_total_label.setBounds(350,(int)TOTAL_HIGHT,100,20);
	    add(gun_total_label);
	    
	    JLabel gun_cost_label = new JLabel("gun cost");
	    gun_cost_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    gun_cost_label.setBounds(350,(int)COST_HIGHT,100,20);
	    add(gun_cost_label);
	    
	    // MachineGun
	    
	    ImageIcon icon6 = new ImageIcon("img/machinegun_button.png");
	    JButton machine_button = new JButton(icon6);
	    machine_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.36),(int)BUTTON_HIGHT,132,132);
	    machine_button.addActionListener(new ButtonListener());
	    machine_button.setActionCommand("machine_button");
	    add(machine_button);
	    
	    
	//    int machine_available = MainPanel.main_role.readyBullet.get(new MachineGun());
	    
	    JLabel machine_available_label = new JLabel("machine_available");
	    machine_available_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    machine_available_label.setBounds(500,(int)AVAILABLE_HIGHT,100,20);
	    add(machine_available_label);
	    
	//    int machine_total = MainPanel.main_role.totalBullet.get(new MachineGun());
	    
	    JLabel machine_total_label = new JLabel("machine_total");
	    machine_total_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    machine_total_label.setBounds(500,(int)TOTAL_HIGHT,100,20);
	    add(machine_total_label);
	    
	    JLabel machine_cost_label = new JLabel("machine cost");
	    machine_cost_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    machine_cost_label.setBounds(500,(int)COST_HIGHT,100,20);
	    add(machine_cost_label);
	    
	    
	    // SniperRfile
	    
	    ImageIcon icon7 = new ImageIcon("img/sniper_button.png");
	    JButton sniper_button = new JButton(icon7);
	    sniper_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.48),(int)BUTTON_HIGHT,130,130);
	    sniper_button.addActionListener(new ButtonListener());
	    sniper_button.setActionCommand("sniper_button");
	    add(sniper_button);
	    
	//    int sniper_available = MainPanel.main_role.readyBullet.get(new SniperRfile());
	    
	    JLabel sniper_available_label = new JLabel("sniper_available");
	    sniper_available_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    sniper_available_label.setBounds(650,(int)AVAILABLE_HIGHT,100,20);
	    add(sniper_available_label);
	    
	//    int sniper_total = MainPanel.main_role.totalBullet.get(new SniperRfile());
	    
	    JLabel sniper_total_label = new JLabel("sniper_total");
	    sniper_total_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    sniper_total_label.setBounds(650,(int)TOTAL_HIGHT,100,20);
	    add(sniper_total_label);
	    
	    JLabel sniper_cost_label = new JLabel("sniper cost");
	    sniper_cost_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    sniper_cost_label.setBounds(650,(int)COST_HIGHT,100,20);
	    add(sniper_cost_label);
	    
	    // ShotGun
	    
	    ImageIcon icon8 = new ImageIcon("img/shotgun_button.png");
	    JButton shot_button = new JButton(icon8);
	    shot_button.setBounds((int)(MiniCSLaunch.WEAPONPANEL_WIDTH*0.6),(int)BUTTON_HIGHT,130,130);
	    shot_button.addActionListener(new ButtonListener());
	    shot_button.setActionCommand("shot_button");
	    add(shot_button);
	    

	//    int shot_available = MainPanel.main_role.readyBullet.get(new ShotGun());
	    
	    JLabel shot_available_label = new JLabel("shot_available");
	    shot_available_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    shot_available_label.setBounds(800,(int)AVAILABLE_HIGHT,100,20);
	    add(shot_available_label);
	    
	//    int shot_total = MainPanel.main_role.totalBullet.get(new ShotGun());
	    
	    JLabel shot_total_label = new JLabel("shot_total");
	    shot_total_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    shot_total_label.setBounds(800,(int)TOTAL_HIGHT,100,20);
	    add(shot_total_label);
	    
	    JLabel shot_cost_label = new JLabel("shot cost");
	    shot_cost_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    shot_cost_label.setBounds(800,(int)COST_HIGHT,100,20);
	    add(shot_cost_label);
	    
	    // Weapon Attribute
	    
	    ImageIcon icon2 = new ImageIcon("img/available_label.png");
	    JLabel available_label = new JLabel(icon2);
	    available_label.setBounds(180,(int)AVAILABLE_HIGHT,100,20);
	    add(available_label);
	    
	    ImageIcon icon3 = new ImageIcon("img/total_label.png");
	    JLabel total_label = new JLabel(icon3);
	    total_label.setBounds(180,(int)TOTAL_HIGHT,100,20);
	    add(total_label);
	    
	    ImageIcon icon4 = new ImageIcon("img/cost_label.png");
	    JLabel cost_label = new JLabel(icon4);
	    cost_label.setBounds(180,(int)COST_HIGHT,100,20);
	    add(cost_label);
	    
	    // MainRole Attribute
	    
	    ImageIcon icon10 = new ImageIcon("img/money_label.png");
	    JLabel money_label = new JLabel(icon10);
	    money_label.setBounds((int)ROLE_ATTR_WIDTH,20,100,20);
	    add(money_label);
	    
	    JLabel money_s_label = new JLabel("money_label");
	    money_s_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    money_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,20,100,20);
	    add(money_s_label);
	    
	    ImageIcon icon11 = new ImageIcon("img/ko_label.png");
	    JLabel ko_label = new JLabel(icon11);
	    ko_label.setBounds((int)ROLE_ATTR_WIDTH,100,150,20);
	    add(ko_label);
	    
	    JLabel ko_s_label = new JLabel("ko_label");
	    ko_s_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    ko_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,100,100,20);
	    add(ko_s_label);
	    
	    ImageIcon icon12 = new ImageIcon("img/distance_label.png");
	    JLabel distance_label = new JLabel(icon12);
	    distance_label.setBounds((int)ROLE_ATTR_WIDTH,120,140,20);
	    add(distance_label);
	    
	    JLabel distance_s_label = new JLabel("distance_label");
	    distance_s_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    distance_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,120,100,20);
	    add(distance_s_label);
	    
	    ImageIcon icon13 = new ImageIcon("img/time_label.png");
	    JLabel time_label = new JLabel(icon13);
	    time_label.setBounds((int)ROLE_ATTR_WIDTH,140,170,20);
	    add(time_label);
	    
	    JLabel time_s_label = new JLabel("time_label");
	    time_s_label.setFont(new Font("Serif", Font.PLAIN, 12));
	    time_s_label.setBounds((int)ROLE_ATTR_S_WIDTH,140,100,20);
	    add(time_s_label);
   
	    
	    add(bg_label);
	    
	    setVisible(true);
	}
}

