package com.tiaa.coding;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

	
	private final InventoryDetails inventory;
	private final CountDownLatch latch;
	
	public Worker(InventoryDetails prod, CountDownLatch latch) {
		this.inventory = prod;
		this.latch = latch;
	}
	
	//lock object which make sure exclusion
	private static final Object lock = new Object();
	
	@Override
	public void run() {
		try 
		{
			while(this.inventory.getMachines() > 0 && this.inventory.getBolts() > 1) 
			{
				synchronized (lock)
				{
					inventory.setBolts(inventory.getBolts() - inventory.boltsNeededByAMachine());
					inventory.setMachines(inventory.getMachines() - 1);
					
					inventory.incrementTotalFinishedProducts();
				}
			}
			
			latch.countDown();
		} catch(Exception e)
        {
            e.printStackTrace();
        }
	}

}
