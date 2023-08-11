package prob6;

import java.io.IOException;
import java.nio.CharBuffer;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public void resize(double d) {
		width = width * d;
		height = height * d;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height) * 2;
	}

}
