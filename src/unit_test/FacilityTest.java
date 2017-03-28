/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import cell.Facility;
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
public class FacilityTest {
    
    public FacilityTest() {
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
     * Test of GetType method, of class Facility.
     */
    @Test
    public void testGetType() {
        System.out.println("GetType Facility");
        Facility instance = new FacilityImpl();
        String expResult = "";
        String result = instance.GetType();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetName method, of class Facility.
     */
    @Test
    public void testGetName() {
        System.out.println("GetName Facility");
        Facility instance = new FacilityImpl();
        String expResult = "Facility";
        String result = instance.GetName();
        assertEquals(expResult, result);
    }

    public class FacilityImpl extends Facility {

        public String GetType() {
            return "";
        }

        @Override
        public void Render() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
