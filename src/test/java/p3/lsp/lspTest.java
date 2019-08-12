package p3.lsp;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import p3.lsp.Rectangle;
import p3.lsp.Shape;
import p3.lsp.Square;

import static org.junit.Assert.*;

public class lspTest {
	
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
	public void twentyFor4X5ShapeFromRectangle()
    {
        Shape shape = new Rectangle(4, 5);
        assertEquals(20, shape.area(), 0);
    }
		
	@Test
	public void twentyFor4X5ShapeFromRectangleAnd9For3X3Square() {
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Rectangle(4, 5));
		shapes.add(new Square(3));
		List<Integer> areas = new ArrayList<Integer>();
		for (Shape shape : shapes)
		{			
            areas.add(shape.area());
		}
		assertEquals(20, areas.get(0), 0);
		assertEquals(9, areas.get(1), 0);
	}
}