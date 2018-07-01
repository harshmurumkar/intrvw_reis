package com.tiaa.coding;
import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import org.junit.Test;

import com.tiaa.coding.impl.Inventory;

public class InventoryTest {
	
    @Test public void testConsumeInput() {
    	
    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        InventoryIfc inv = new Inventory();
        
        System.out.println("X = " + 10);
        System.out.println("X = " + 20);
        System.out.println("N = " + 40);
        
        InventoryDetails invDetails = inv.consumeInput();
        
        assertEquals(10, invDetails.getMachines());
        assertEquals(10, invDetails.getMachines());
        assertEquals(10, invDetails.getMachines());
    }
    
    @Test public void testConsumeInputWithInCorrectData() {
    	
    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        InventoryIfc inv = new Inventory();
        System.out.println("X = " + "*");
        System.out.println("X = " + 20);
        System.out.println("N = " + 40);
        InventoryDetails invDetails = inv.consumeInput();
        
        assertEquals(10, invDetails.getMachines());
        assertEquals(10, invDetails.getMachines());
        assertEquals(10, invDetails.getMachines());
    }
}
