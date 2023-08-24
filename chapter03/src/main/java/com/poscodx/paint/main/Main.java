package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;


public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
//		point1.setX(10);
//		point1.setY(20);

//		drawPoint(point1); 인터페이스 구현
		draw(point1);
//		point1.disappear();
		point1.show(false);

		Point point2 = new ColorPoint();
//		ColorPoint point2 = new ColorPoint();

		point2.setX(20);
		point2.setY(20);

//		ColorPoint p = (ColorPoint)point2;
		((ColorPoint) point2).setColor("red");

//		drawColorPoint(point2); 인터페이스 구현
//		drawPoint(point2);
		draw(point2);

		Rect rect = new Rect();
//		drawRect(rect); 인터페이스 구현
//		drawShape(rect); // 업캐스
		draw(rect); // 업캐스

		Triangle triangle = new Triangle();
//		drawTriangle(triangle); 
//		drawShape(triangle); 인터페이스 구현
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle); 인터페이스 구현
		draw(circle);

		draw(new GraphicText("Hello World!"));
		// 라면은 있지만, 음식은 없다!
//		new Shape();
		
		
		// instance of //Test//pass
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Object);
		
		// 연산자 우측항인 경우 인터페이스의 경우, 
		// (hierachy x) 기능의 구현의 의미이므로 호출 가능
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
		
		// instanceof //Test//error 
		// -> 연산자 우측항이 클래스인 경우, ref하고 있는 클래스 타입의 hierachy 상의 
		// 하위, 상위만 instanceof 사용 가
//		System.out.println(circle instanceof Rect);
		
		
		
	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawPoint(Point point) {
//		point.show(true);
//
//	}

	
////	public static void drawColorPoint(ColorPoint colorPoint) {
////		colorPoint.show();
////		
////	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//
////	public static void drawRect(Rect rect) {
////		rect.draw();
////	}
////
////	public static void drawTriangle(Triangle triangle) {
////		triangle.draw();
////
////	}
}
