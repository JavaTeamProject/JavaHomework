package minics;

public class Weapon {
    protected int price;
    protected int clip_amount;
    protected int CD_time;
    protected int atk;
    protected int bullet_speed;
    protected Boolean passthrough = false;
    protected int exist_time;
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
	public int getPrice() {
		return price;
	}
}
