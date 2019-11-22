package com.techelevator.item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.FileReader;

public class Gum extends Item {

	private String noise;
	private String slot;

	public Gum(String slot) {
		super(slot);
		this.slot = slot;
	}

	public String getSlot() {
		return slot;
	}
}
  