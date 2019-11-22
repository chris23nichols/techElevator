package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.item.Candy;

public class CandyTest {

	private Candy candy;

	@Before
	public void setup() {
		candy = new Candy("B1");
	}

	@Test
	public void getNameReturnsName() {
		Assert.assertTrue("Moonpie".equals(candy.getName()));
	}

	@Test
	public void getPriceReturnsPrice() {
		Assert.assertEquals(Double.valueOf(1.80), candy.getPrice());
	}

}
