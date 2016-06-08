package minics;

public class Weapon {
	private int price;
	private int clip_amount;
	private int CD_time;
	private int atk;
	private int bullet_speed;
	private Boolean passthrough = false;
	private int exist_time;
	public Weapon() {
	}
	public int getAtk() {
		return atk;
	}
	public int getClipAmount() {
		return clip_amount;
	}
	public int getCDTime() {
		return CD_time;
	}
	public int getBulletSpeed() {
		return bullet_speed;
	}
	public Boolean getPassThrough() {
		return passthrough;
	}
	public int getExistTime() {
		return exist_time;
	}
	public boolean isaffordable(int money) {
		if(money >= this.price)
			return true;
		else
			return false;
	}
}
