/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import cell.Road;
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
public class RoadTest {
    
    public RoadTest() {
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
     * Test of GetType method, of class Road.
     */
    @Test
    public void testGetType() {
        System.out.println("GetType Road");
        Road instance = new Road();
        String expResult = "Road";
        String result = instance.GetType();
        assertEquals(expResult, result);
    }

    /**
     * Test of Render method, of class Road.
     */
    @Test
    public void testRender() {
        System.out.println("Render Road");
        Road instance = new Road();
        System.out.println("expected :  n");
        System.out.print("result : ");
        instance.Render();
        System.out.println('n');
    }
    
}
