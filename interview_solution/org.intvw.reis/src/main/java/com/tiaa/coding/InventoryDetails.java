package com.tiaa.coding;

/**
 * Configuration holding class which holds property required by problem.
 * @author hmurumka
 *
 */
public class InventoryDetails  {

	private long machines;
	private long bolts;
	private long timeTakenToFinishAProduct;
	private long boltsNeededByAMachine = 2;
	private long totalFinishedProducts;
	private long overAllTimeToFinishCompleteProduction;
	

	public long getOverAllTimeToFinishCompleteProduction(int totalWorker) {
		if(this.getTotalFinishedProducts() > 0)
		{
			long remainingProductQuotion =  this.totalFinishedProducts % totalWorker;
			this.overAllTimeToFinishCompleteProduction = (this.totalFinishedProducts/totalWorker) * this.timeTakenToFinishAProduct + (remainingProductQuotion > 0 ? timeTakenToFinishAProduct : 0);
		}
		
		return this.overAllTimeToFinishCompleteProduction;
	}

	public long getTimeTakenToFinishAProduct() {
		return timeTakenToFinishAProduct;
	}

	public void setTimeTakenToFinishAProduct(int timeTakenToFinishAProduct) {
		this.timeTakenToFinishAProduct = timeTakenToFinishAProduct;
	}

	public long getMachines() {
		return machines;
	}

	public long getBolts() {
		return bolts;
	}

	public void setMachines(long machines) {
		this.machines = machines;
	}

	public void setBolts(long bolts) {
		this.bolts = bolts;
	}
	
	public long boltsNeededByAMachine()
	{
		return this.boltsNeededByAMachine;
	}
	
	public void setTotalFinishedProducts(long value) {
		this.totalFinishedProducts = value;
	}
	
	public void incrementTotalFinishedProducts() {
		this.totalFinishedProducts++;
	}
	
	public long getTotalFinishedProducts()
	{
		return this.totalFinishedProducts;
	}
}
