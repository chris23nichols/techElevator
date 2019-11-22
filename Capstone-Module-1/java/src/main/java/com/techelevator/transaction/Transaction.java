package com.techelevator.transaction;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class Transaction extends Menu { 

	private Double balance;  
	@SuppressWarnings("resource")
	public Transaction(InputStream input, OutputStream output) {
		super(input, output);
		this.balance = 0.0;
		new PrintWriter(output);
		new Scanner(input);

	}

	public Double getBalance() {  
		return balance;
	}
 
}