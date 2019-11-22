package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.item.Beverage;

public class BeverageTest {

	private Beverage beverage; 

	@Before
	public void setup() {
		beverage = new Beverage("C1");
	}

	@Test
	public void getNameReturnsName() {
		Assert.assertTrue("Cola".equals(beverage.getName()));
	}

	@Test
	public void getPriceReturnsPricing() {
		Assert.assertEquals(Double.valueOf(1.25), beverage.getPrice());
	}

}
