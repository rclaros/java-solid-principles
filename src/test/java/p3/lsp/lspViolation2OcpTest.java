package p3.lsp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import p3.lsp.violation2ocp.Rectangle;
import p3.lsp.violation2ocp.Shape;
import p3.lsp.violation2ocp.Square;

public class lspViolation2OcpTest {

	@Test
	public void sixFor2X3Rectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(2);
		rectangle.setWidth(3);
		assertEquals(6, rectangle.area(), 0);
	}
	
	@Test
	public void nineFor3X3Square()
	{
		Square square = new Square();
		square.setSideLength(3);
		assertEquals(9, square.area(), 0);
	}
	
	@Test
	public void twentyFor4X5ShapeFromRectangleAnd9For3X3Square() {
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Rectangle(4, 5));
		shapes.add(new Square(3));
		List<Integer> areas = new ArrayList<Integer>();
		for (Shape shape : shapes) {
			if (shape instanceof Rectangle) {
                areas.add(((Rectangle) shape).area());
            }
			if (shape instanceof Square) {
                areas.add(((Square) shape).area());
            }
		}
		assertEquals(20, areas.get(0), 0);
		assertEquals(9, areas.get(1), 0);
	}
}