package com.techelevator.view;

import java.io.File;

import org.junit.*;

import com.techelevator.FileReader;
import com.techelevator.VendoMatic800;
import com.techelevator.item.Item;

public class VendoMatic800Test {

	private VendoMatic800 vendingMachine;
	private Item item;

	@Before
	public void setup() {
		vendingMachine = new VendoMatic800();
		item = new Item("A1");
	}

	@Test
	public void slotReturnsCorrectName() {
		Item ourName = vendingMachine.makeVendingMachine().get("A1");
		Assert.assertTrue("Potato Crisps".equals(ourName.getName()));
	}

	@Test
	public void slotReturnsCorrectPricing() {
		Item ourPrice = vendingMachine.makeVendingMachine().get("A1");
		Assert.assertEquals(Double.valueOf(3.05), ourPrice.getPrice());
	}

}