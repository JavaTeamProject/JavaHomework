package minics;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventControl implements KeyListener,MouseListener{
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
						/*case KeyEvent.VK_DOWN:
							MainPanel.main_role.moveVertical(true);
							break;
						case KeyEvent.VK_UP:
							MainPanel.main_role.moveVertical(false);
							break;*/
						case KeyEvent.VK_LEFT:
							MainPanel.main_role.moveHorizontal(false);
							break;
						case KeyEvent.VK_RIGHT:
							MainPanel.main_role.moveHorizontal(true);
							break;
						case KeyEvent.VK_ESCAPE:
							System.exit(0);
							break;
						default: break;
		}
	}
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent e) {}
	public void actionPerformed(ActionEvent e){}
	public void mousePressed(MouseEvent event)
	{
        if (event.getButton() == MouseEvent.BUTTON1) //left button
        {
        	if(MainPanel.main_role.shot()==1)
    		{
    			int atk = MainPanel.main_role.getAtk();
        		MainPanel.bullet_hashset.add(new Bullet(MainPanel.main_role.x, MainPanel.main_role.y, event.getX()-MainPanel.main_role.x, event.getY()-MainPanel.main_role.y,1,atk));
    		}
        }
        if (event.getButton() == MouseEvent.BUTTON3) //right button
        {
        	MainPanel.main_role.reload();
        }
		//System.out.println(bullet_hashset.size());
		
		//point_hashset.add(new Point(event.getX(), event.getY()));
		System.out.println("-----------------------------------------------------");
		for(int i = 0;i<MainPanel.MAP_HIGHT;i++)
		{
			for(int j = 0; j<MainPanel.MAP_WIDTH ; j++)
			{
				System.out.print(MainPanel.map[j][i]);
			}
			System.out.println();
		}
	}

	public void mouseReleased(MouseEvent event){}
	public void mouseClicked(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
}
