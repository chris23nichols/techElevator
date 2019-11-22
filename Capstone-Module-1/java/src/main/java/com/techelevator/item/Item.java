package com.techelevator.item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.FileReader;

public class Item {

	private String name;
	private Double price;
	private String slot;
	private String noise;
	private String itemCount;

	public Item(String slot) {
		this.itemCount = "5";
		this.slot = slot;
	}

	public String getName() {

		FileReader file = new FileReader();
		File inputFile = file.setInputFile();

		List<String> outputList = new ArrayList<String>();
		outputList = file.createVendingMachineList(inputFile);

		for (int i = 0; i < outputList.size(); i++) {
			String[] splitLine = outputList.get(i).split("\\|");

			if (splitLine[0].equals(slot)) {
				name = splitLine[1];
			}
		}
		return name;
	}

	public Double getPrice() {

		FileReader file = new FileReader();
		File inputFile = file.setInputFile();

		List<String> outputList = new ArrayList<String>();
		outputList = file.createVendingMachineList(inputFile);

		for (int i = 0; i < outputList.size(); i++) {
			String[] splitLine = outputList.get(i).split("\\|");

			if (splitLine[0].equals(slot)) {
				price = Double.valueOf(splitLine[2]);
			}
		}
		return price;
	}

	public String makeNoise() {
		return noise;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void purchaseItem() {
		Integer currentCount = Integer.parseInt(itemCount) - 1;
		if (currentCount > 0) {
			itemCount = String.valueOf(currentCount);
		} else {
			itemCount = "SOLD OUT";
		}
	}

	public Object getVendingMachineList(FileReader file) {

		return file; 
	}

}
