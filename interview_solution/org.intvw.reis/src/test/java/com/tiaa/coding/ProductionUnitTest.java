package com.tiaa.coding;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.tiaa.coding.impl.Inventory;

public class ProductionUnitTest {
	
    @Test 
    public void testVanillaCase() 
    {
    	
    	String input = "X = 10" + "\n"
				+ "Y = 30" + "\n"
				+ "N = 40" + "\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    InventoryIfc inv = new Inventory();
	    
	    InventoryDetails invDetails = inv.consumeInput();
	    ProductionUnit unit = new ProductionUnit(3);
	    unit.completeProductionCycle(invDetails);
	    assertEquals(10, invDetails.getTotalFinishedProducts());
        assertEquals(160, invDetails.getOverAllTimeToFinishCompleteProduction(3));
    
    }
    
    @Test 
    public void testInvalidDataWithSingleBolt() 
    {
    	
    	String input = "X = 10" + "\n"
				+ "Y = 1" + "\n"
				+ "N = 40" + "\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    InventoryIfc inv = new Inventory();
	    
	    InventoryDetails invDetails = inv.consumeInput();
	    ProductionUnit unit = new ProductionUnit(3);
	    unit.completeProductionCycle(invDetails);
	    assertEquals(0, invDetails.getTotalFinishedProducts());
        assertEquals(0, invDetails.getOverAllTimeToFinishCompleteProduction(3));
    
    }
    
    @Test 
    public void testProductionWithZeroWorker() 
    {
    	
    	String input = "X = 10" + "\n"
				+ "Y = 10" + "\n"
				+ "N = 40" + "\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    InventoryIfc inv = new Inventory();
	    
	    InventoryDetails invDetails = inv.consumeInput();
	    
	    //noworker in production unit.
	    ProductionUnit unit = new ProductionUnit(0);
	    unit.completeProductionCycle(invDetails);
	    assertEquals(0, invDetails.getTotalFinishedProducts());
        assertEquals(0, invDetails.getOverAllTimeToFinishCompleteProduction(0));
    
    }
    
    @Test 
    public void testMoreWorkerLessProduct() 
    {
    	
    	String input = "X = 5" + "\n"
				+ "Y = 12" + "\n"
				+ "N = 60" + "\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    InventoryIfc inv = new Inventory();
	    
	    InventoryDetails invDetails = inv.consumeInput();
	    
	    //noworker in production unit.
	    ProductionUnit unit = new ProductionUnit(10);
	    unit.completeProductionCycle(invDetails);
	    assertEquals(5, invDetails.getTotalFinishedProducts());
	    assertEquals(2, invDetails.getBolts());
        assertEquals(60, invDetails.getOverAllTimeToFinishCompleteProduction(10));
    
    }
}
