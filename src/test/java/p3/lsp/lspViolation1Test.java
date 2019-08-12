package p3.lsp;

import static org.junit.Assert.*;
import org.junit.Test;

import p3.lsp.violation1.AreaCalculator;
import p3.lsp.violation1.Rectangle;
import p3.lsp.violation1.Square;

public class lspViolation1Test {

	@Test
	public void sixFor2X3Rectangle() {
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(2);
		rectangle.setWidth(3);
		assertEquals(6, AreaCalculator.calculateArea(rectangle), 0);
	}
	
	@Test
	public void nineFor3X3Square()
	{
		Square square = new Square();
		square.setHeight(3);		
		assertEquals(9, AreaCalculator.calculateArea(square), 0);
	}
	
	@Test
	public void twentyFor4X5RectangleFromSquare() {
		Rectangle rectangle = new Square();
		rectangle.setWidth(4);
		rectangle.setHeight(5);
		assertEquals(20, AreaCalculator.calculateArea(rectangle), 0);
	}
}