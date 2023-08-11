package chapter04;

import java.util.Objects;

public class Rect {
	private int width;
	private int height;
	
	

	public Rect(int width, int height) {
		this.width = width;
		this.height=height;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("rect[x=" + width+ ",y=" + height + "]을 그렸습니다.");
	}

	@Override
	public int hashCode() {
		return Objects.hash(height *width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return height*width == other.height*other.width;
	}
}
