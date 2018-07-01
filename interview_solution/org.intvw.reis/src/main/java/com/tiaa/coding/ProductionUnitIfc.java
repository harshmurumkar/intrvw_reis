package com.tiaa.coding;

public interface ProductionUnitIfc {
	
	/**
	 * completeProductionCycle is responsible to process complete lifecycle of product and generate final data.
	 * @param inventory
	 */
	public void completeProductionCycle(InventoryDetails inventory);
}
