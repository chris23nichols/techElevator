package com.techelevator.item;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techelevator.FileReader;

public class Chip extends Item {

	private String noise;
	private String slot;

	public Chip(String slot) {
		super(slot);
		this.slot = slot;
	}

	public String getSlot() {
		return slot;
	}
}
 