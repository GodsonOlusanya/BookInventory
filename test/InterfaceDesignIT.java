/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author it
 */
public class InterfaceDesignIT {
    
    public InterfaceDesignIT() {
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
     * Test of frame method, of class InterfaceDesign.
     */
    @Test
    public void testFrame() {
        System.out.println("frame");
        InterfaceDesign instance = new InterfaceDesign();
        instance.frame();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of initComponents method, of class InterfaceDesign.
     */
    @Test
    public void testInitComponents() {
        System.out.println("initComponents");
        InterfaceDesign instance = new InterfaceDesign();
        instance.initComponents();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
