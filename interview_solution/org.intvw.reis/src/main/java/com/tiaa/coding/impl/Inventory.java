package com.tiaa.coding.impl;

import java.util.Scanner;

import com.tiaa.coding.InventoryDetails;
import com.tiaa.coding.InventoryIfc;

/**
 * Implementation for InputParserIfc, based on requirement, parser can be customized and changed.
 * @author hmurumka
 *
 */
public class Inventory implements InventoryIfc{

	/**
	 * consumeInput - is the customization for input reading and constructing an configuration object.
	 */
	@Override
	public InventoryDetails consumeInput() throws IllegalArgumentException {
		
		// Scanner's scope is defined inside the method, just required to capture the input
		// why should waste memory chunks!!!!!
		Scanner scanner = new Scanner(System.in);
		try 
		{
			InventoryDetails config = new InventoryDetails(); 
			String value =  scanner.nextLine().split("=")[1].trim();
			config.setMachines(Integer.parseInt(value));
			
			value = scanner.nextLine().split("=")[1].trim();
			config.setBolts(Integer.parseInt(value));
			
			value = scanner.nextLine().split("=")[1].trim();
			config.setTimeTakenToFinishAProduct(Integer.parseInt(value));
			
			scanner.close();
			return config;
			
		} catch (NumberFormatException  | ArrayIndexOutOfBoundsException e) {
			scanner.close();
			throw new IllegalArgumentException("Check the given input : " + e.getMessage());
		}
	}

}
