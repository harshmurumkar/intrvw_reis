package com.tiaa.coding;

import com.tiaa.coding.impl.Inventory;

public class TiaaProblem {

	public static void main(String[] args) {
		
		try 
		{
			// parse given input
			InventoryDetails product = new Inventory().consumeInput();
			
			ProductionUnit pUnit = new ProductionUnit(3);
			pUnit.completeProductionCycle(product);
		} catch (Exception e) 
		{
			System.out.println("Total Products = " + 0);
			System.out.println("Total Time Taken = " + 0);
		}
		
	}
}
