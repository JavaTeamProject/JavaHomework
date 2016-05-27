package minics;

public class Weapon {
	private int price;
	private int clip_amount;
	private int CD_time;
	private int atk;
	private int bullet_speed;
	private Boolean passthrough;
	private int exist_time;
	public Weapon(int price, int clip_amount, int CD_time, int atk, int bullet_speed, Boolean passthrough, int exist_time) {
		this.price = price;
		this.clip_amount = clip_amount;
		this.CD_time = CD_time;
		this.atk = atk;
		this.bullet_speed = bullet_speed;
		this.passthrough = passthrough;
		this.exist_time = exist_time;
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
