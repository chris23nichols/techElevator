package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Before;

import com.techelevator.FileReader;

import org.junit.*;

public class FileReaderTest {

	private static final String VENDING_MACHINE_FILE = "vendingmachine.csv";
	private FileReader fileReader;

	@Before
	public void setup() throws FileNotFoundException {
		fileReader = new FileReader();

	} 

	@Test
	public void inputFileIsFile() {
		Assert.assertTrue(fileReader.setInputFile().isFile());
	} 

	@Test
	public void outputListPopulated() {
		File file = fileReader.setInputFile();
		List<String> ourList = fileReader.createVendingMachineList(file);
		Assert.assertTrue("A1|Potato Crisps|3.05|Chip".equals(ourList.get(0)));
	}

	@Test
	public void inputFileExists() {
		Assert.assertTrue(fileReader.setInputFile().exists());
	}
}
