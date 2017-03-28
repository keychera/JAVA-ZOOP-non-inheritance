/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import cell.AirHabitat;
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
public class AirHabitatTest {
    
    //public AirHabitatTest() {
    //}
    
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
     * Test of Render method, of class AirHabitat.
     */
    @Test
    public void testRender() {
        System.out.println("Render of AirHabitat");
        AirHabitat instance = new AirHabitat();
        System.out.println("expected : *");
        System.out.print("result : ");
        instance.Render();
        System.out.println();
    }

    /**
     * Test of GetType method, of class AirHabitat.
     */
    @Test
    public void testGetType() {
        System.out.println("GetType");
        AirHabitat instance = new AirHabitat();
        String expResult = "AirHabitat";
        String result = instance.GetType();
        assertEquals(expResult, result);
    }
    
}
