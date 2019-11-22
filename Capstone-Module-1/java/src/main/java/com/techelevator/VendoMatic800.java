package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.techelevator.item.*;

public class VendoMatic800 { 
 
	private Map<String, Item> VendingMachine; 
	private Set<String> orderedSet;

	public Map<String, Item> makeVendingMachine() {  
		
		FileReader file = new FileReader();
		File inputFile = file.setInputFile();
		
		List<String> outputList = new ArrayList<String>();
		outputList = file.createVendingMachineList(inputFile); 
		VendingMachine = new HashMap<String, Item>();
		
		for (int i = 0; i < outputList.size(); i++) { 
			
			String[] splitLine = outputList.get(i).split("\\|");
			if (splitLine[3].equals("Chip")) { 
				VendingMachine.put(splitLine[0], new Chip(splitLine[0]));
			} else if (splitLine[3].equals("Candy")) {
				VendingMachine.put(splitLine[0], new Candy(splitLine[0]));
			} else if (splitLine[3].equals("Drink")) {
				VendingMachine.put(splitLine[0], new Beverage(splitLine[0]));
			} else if (splitLine[3].equals("Gum")) {
				VendingMachine.put(splitLine[0], new Gum(splitLine[0]));
			}
		}
		return VendingMachine; 
	} 

	public Map<String, Item> getVendingMachine() {
		return VendingMachine; 
	}

	public void displayVendingMachine() {

		orderedSet = new TreeSet<String>();

		for (Map.Entry<String, Item> entry : VendingMachine.entrySet()) {
			orderedSet.add(entry.getKey() + " " + entry.getValue().getName() + " $"
					+ String.valueOf(entry.getValue().getPrice()) + " " + entry.getValue().getItemCount());
		}

		for (String item : orderedSet) {
			System.out.println(item);
		}
	}

}