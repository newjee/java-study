package tv;

public class TV {
	private int channel; 	//1 ~ 255 rotate
	private int volume; 	//0 ~ 100 rotate...
	private boolean power;
	
	public TV() {
		
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		power =  on;
	}
	
	public void channel(boolean up) {
		
	}
	
	public void channel(int channel) {
		this.channel = channel;
	}

	public void volume(boolean up) {
		
	}
	
	public void volume(int channel) {
		this.volume = channel;
	}
	
	public void status() {
		System.out.println("TV[power =" + (power? "on" : "off") +
							"channel " + channel+ "," +
							"volume " + volume
								);
	}
	
	
}
