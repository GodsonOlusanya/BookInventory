/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
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
public class ButtonConnectionIT {
    
    /**
     *
     */
    public ButtonConnectionIT() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of btnSaveActionPerformed method, of class ButtonConnection.
     */
    @Test
    public void testBtnSaveActionPerformed() {
        System.out.println("btnSaveActionPerformed");
        ActionEvent evt = null;
        ButtonConnection instance = new ButtonConnection();
        instance.btnSaveActionPerformed(evt);
        }

    /**
     * Test of btnUpdateActionPerformed method, of class ButtonConnection.
     */
    @Test
    public void testBtnUpdateActionPerformed() {
        System.out.println("btnUpdateActionPerformed");
        ActionEvent evt = null;
        ButtonConnection instance = new ButtonConnection();
        instance.btnUpdateActionPerformed(evt);
         }

    /**
     * Test of btnDeleteActionPerformed method, of class ButtonConnection.
     */
    @Test
    public void testBtnDeleteActionPerformed() {
        System.out.println("btnDeleteActionPerformed");
        ActionEvent evt = null;
        ButtonConnection instance = new ButtonConnection();
        instance.btnDeleteActionPerformed(evt);
        }

    /**
     * Test of initComponents method, of class ButtonConnection.
     */
    @Test
    public void testInitComponents() {
        System.out.println("initComponents");
        ButtonConnection instance = new ButtonConnection();
        instance.initComponents();
        
    }

    /**
     * Test of btnRefreshActionPerformed method, of class ButtonConnection.
     */
    @Test
    public void testBtnRefreshActionPerformed() {
        System.out.println("btnRefreshActionPerformed");
        ActionEvent evt = null;
        ButtonConnection instance = new ButtonConnection();
        instance.btnRefreshActionPerformed(evt);
        
    }
    
}
