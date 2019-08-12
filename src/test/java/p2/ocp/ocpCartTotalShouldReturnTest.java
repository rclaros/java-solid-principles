package p2.ocp;

import static org.junit.Assert.*;
import java.text.DecimalFormat;
import org.junit.Before;
import org.junit.Test;

import p2.ocp.Cart;
import p2.ocp.OrderItem;

public class ocpCartTotalShouldReturnTest {

	private Cart cart;		
	
	@Before
	public void setUp() {
		cart = new Cart();
	}
	
	@Test
	public void zeroWhenEmpty() {
		assertEquals(0, cart.totalAmount(), 0);
	}
	
	@Test
	public void fiveWithOneEachItem()
    {
        cart.add(new OrderItem("EACH_WIDGET", 1));        
        assertEquals(5.0, cart.totalAmount(), 0);
    }
	
	@Test
	public void twoWithHalfKiloWeightItem()
    {        
        cart.add(new OrderItem("WEIGHT_PEANUTS", 500));        
        assertEquals(2, cart.totalAmount(), 0);
    }
	
	@Test
	public void eightyCentsWithTwoSpecialItem()
    {        
        cart.add(new OrderItem("SPECIAL_CANDYBAR", 2));        
        assertEquals(0.8, cart.totalAmount(), 0);
    }
	
	@Test
	public void twoDollarsWithSixSpecialItem()
    {        
        cart.add(new OrderItem("SPECIAL_CANDYBAR", 6));        
        assertEquals(2.0, round(cart.totalAmount()), 0);
    }
	
	@Test
	public void fourDollarsWithFourBuy4Get1FreeItems()
    {        
        cart.add(new OrderItem("B4GO_APPLE", 4));
        assertEquals(4.0, round(cart.totalAmount()), 0);
    }
	
	@Test
	public void fourDollarsWithFiveBuy4Get1FreeItems()
    {        
        cart.add(new OrderItem("B4GO_APPLE", 5));
        assertEquals(4.0, round(cart.totalAmount()), 0);
    }
	
	public double round(double value)
	{
		DecimalFormat newFormat = new DecimalFormat("#.#");
		return Double.valueOf(newFormat.format(value));
	}
}