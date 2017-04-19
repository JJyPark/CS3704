/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfclasses;

import com.mycompany.entityclasses.JobApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author j.park
 */
public class JobAppControllerTest {
    public JobAppController controller;
    public JobAppControllerTest() {
    }
    
    @Before
    public void setUp() {
        controller = new JobAppController();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSelected method, of class JobAppController.
     */
    @Test
    public void testGetSelected() {
        JobApp expResult = null;
        JobApp result = controller.getSelected();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSelected method, of class JobAppController.
     */
    @Test
    public void testSetSelected() {
        JobApp selected = new JobApp(5);
        controller.setSelected(selected);
        JobApp result = controller.getSelected();
        assertEquals(selected, result);
    }
    
}
