package com.tiaa.coding;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.tiaa.coding.impl.Inventory;

public class InventoryTest {
	
    @Test public void testConsumeInput() {
    	
    	String input = "X = 10" + "\n"
    				+ "Y = 30" + "\n"
    				+ "N = 40" + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        InventoryIfc inv = new Inventory();
        
        InventoryDetails invDetails = inv.consumeInput();
        
        assertEquals(10, invDetails.getMachines());
        assertEquals(30, invDetails.getBolts());
        assertEquals(40, invDetails.getTimeTakenToFinishAProduct());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConsumeInputIllegalArgumentException() {
    	
    	
    	String input = "X = *" + "\n"
				+ "Y = 30" + "\n"
				+ "N = 40" + "\n";
    	
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
	    InventoryIfc inv = new Inventory();
	    inv.consumeInput();
    }
}
