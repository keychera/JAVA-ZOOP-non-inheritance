/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;

import cell.Cell;
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
public class CellTest {
    
    public CellTest() {
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
     * Test of GetName method, of class Cell.
     */
    @Test
    public void testGetName() {
        System.out.println("GetName of Cell");
        Cell instance = new CellImpl();
        String expResult = "";
        String result = instance.GetName();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetType method, of class Cell.
     */
    @Test
    public void testGetType() {
        System.out.println("GetType");
        Cell instance = new CellImpl();
        String expResult = "";
        String result = instance.GetType();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetX method, of class Cell.
     */
    @Test
    public void testGetX() {
        System.out.println("GetX of Cell");
        Cell instance = new CellImpl();
        instance.SetX(10);
        int expResult = 10;
        int result = instance.GetX();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetY method, of class Cell.
     */
    @Test
    public void testGetY() {
        System.out.println("GetY of Cell");
        Cell instance = new CellImpl();
        instance.SetY(10);
        int expResult = 10;
        int result = instance.GetY();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetX method, of class Cell.
     */
    @Test
    public void testSetX() {
        System.out.println("SetX of Cell");
        int _x = 10;
        int expResult = _x;
        Cell instance = new CellImpl();
        instance.SetX(_x);
        int result = instance.GetX();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetY method, of class Cell.
     */
    @Test
    public void testSetY() {
        System.out.println("SetY of Cell");
        int _y = 10;
        int expResult = _y;
        Cell instance = new CellImpl();
        instance.SetY(_y);
        int result = instance.GetY();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetXY method, of class Cell.
     */
    @Test
    public void testSetXY() {
        System.out.println("SetXY of Cell");
        int _x = 10;
        int _y = 10;
        Cell instance = new CellImpl();
        instance.SetXY(_x, _y);
        int resultX = instance.GetX();
        int resultY = instance.GetY();
        assertEquals(10, resultX);
        assertEquals(10, resultY);
    }

    public class CellImpl extends Cell {

        public String GetName() {
            return "";
        }

        public String GetType() {
            return "";
        }

        @Override
        public void Render() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
