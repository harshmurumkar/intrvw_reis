package com.tiaa.coding;

public interface InventoryIfc {
	
	/**
	 * consumeInput is useful to read inventory related data and convert it in relational object.
	 * Based on provided input, implementation can be varied.
	 * @return
	 * @throws IllegalArgumentException
	 */
	public InventoryDetails consumeInput() throws IllegalArgumentException;
}
