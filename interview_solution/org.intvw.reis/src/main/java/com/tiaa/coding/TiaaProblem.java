package com.tiaa.coding;

import com.tiaa.coding.impl.Inventory;

public class TiaaProblem {

	public static void main(String[] args) {
		
		// parse given input
		InventoryDetails product = new Inventory().consumeInput();
		
		ProductionUnit pUnit = new ProductionUnit(3);
		pUnit.completeProductionCycle(product);
	}
}
