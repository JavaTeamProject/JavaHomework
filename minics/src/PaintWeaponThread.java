package minics;

public class PaintWeaponThread extends Thread{
	WeaponPanel weaponPanel;
	public PaintWeaponThread(WeaponPanel weaponPanel) {
		this.weaponPanel = weaponPanel;
	}
	public void run() {
		weaponPanel.repaint();
		try {
            Thread.sleep(MainPanel.REFRESH_TIME);
        } catch (InterruptedException e) {e.printStackTrace();}
	}
}

