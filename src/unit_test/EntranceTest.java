/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import cell.Entrance;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harum Lokawati
 */
public class EntranceTest {
    
    public EntranceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetType method, of class Entrance.
     */
    @Test
    public void testGetType() {
        System.out.println("GetType Entrance");
        Entrance instance = new Entrance();
        String expResult = "Entrance";
        String result = instance.GetType();
        assertEquals(expResult, result);
    }

    /**
     * Test of Render method, of class Entrance.
     */
    @Test
    public void testRender() {
        System.out.println("Render Entrance");
        Entrance instance = new Entrance();        
        System.out.println("expected : Entrance");
        System.out.print("result : E");
        instance.Render();
        System.out.println();   
    }
    
}
