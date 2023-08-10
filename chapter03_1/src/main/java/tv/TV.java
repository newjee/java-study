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
		if (up) {
			if (channel == 255) {
				this.channel = 1;
			}
			else {
				this.channel++;
			}
		} else {
			if (channel == 1) {
				this.channel = 255;
			}
			else {
				this.channel--;
			}
		}
	}
	
	public void channel(int channel) {
		if (channel >= 1 && channel <=255) {
			this.channel = channel;
		} else if(channel <1){
			this.channel = 255;
		} else {
			this.channel= 1;
		}
	}

	public void volume(boolean up) {
		if (up) {
			if (volume == 100) {
				this.volume = 0;
			}
			else {
				this.volume++;
			}
		} else {
			if (volume == 0) {
				this.volume = 100;
			}
			else {
				this.volume--;
			}
		}
		
	}
	
	public void volume(int volume) {
		if (volume >= 0 && volume <=100) {
			this.volume = volume;
		} else if (volume >100){
			this.volume = 0;
		} else {
			this.volume = 100;
		}
	}
	
	public void status() {
		System.out.println("TV[power =" + (power? "on" : "off") +
							", channel " + channel+ "," +
							" volume " + volume +  "]"
								);
	}
	
	
}
