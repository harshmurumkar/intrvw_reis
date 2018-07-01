package com.tiaa.coding;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hmurumka
 *
 */
public class ProductionUnit implements ProductionUnitIfc{
	
	private final ExecutorService executor;
	private final int worker;
	private CountDownLatch latch;
	
	public ProductionUnit(int worker) {
		this.worker = worker;
		this.executor = Executors.newFixedThreadPool(this.worker);
		this.latch = new CountDownLatch(worker);
	}

	@Override
	public void completeProductionCycle(InventoryDetails inventory) {
		try
		{
			for(long i = 0; i < this.worker; i++)
			{
				executor.submit(new Worker(inventory, latch));
			}
			
			latch.await();
			executor.shutdown();
		}catch(Exception e)
		{
			
		}
		
		System.out.println("Total Products = " + inventory.getTotalFinishedProducts());
		System.out.println("Total Time Taken = " + inventory.getOverAllTimeToFinishCompleteProduction(this.worker));
	}
}
