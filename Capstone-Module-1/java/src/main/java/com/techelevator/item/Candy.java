package com.techelevator.item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.FileReader;

public class Candy extends Item {

	private String noise;
	private String slot;

	public Candy(String slot) {
		super(slot);
		this.slot = slot;
	}

	public String getSlot() {
		return slot;
	}

	public String getNoise(String noise) {
		return this.noise = noise;
	}

}
