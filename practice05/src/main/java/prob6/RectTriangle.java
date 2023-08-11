package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	public double getArea() {
		// TODO Auto-generated method stub
		return (width * height) * 0.5;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height + Math.sqrt(width * width + height * height));
		
	}
}
