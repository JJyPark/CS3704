/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entityclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author j.park
 */
public class JobAppTest {
    public JobApp jobApp;
    public JobAppTest() {
    }
    
    @Before
    public void setUp() {
        jobApp = new JobApp();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class JobApp.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expJobID = 5;
        JobApp instance = new JobApp(expJobID);
        Integer result = instance.getId();
        assertEquals(expJobID, result);
    }

    /**
     * Test of setId method, of class JobApp.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer expJobID = null;
        Integer result = jobApp.getId();
        assertEquals(expJobID, result);
        Integer newJobID = 2;
        jobApp.setId(newJobID);
        Integer result2 = jobApp.getId();
        assertEquals(newJobID, result2);
    }

    /**
     * Test of getTime method, of class JobApp.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        JobApp instance = new JobApp(5, 1, "company", "position", "location", "design");
        int expResult = 1;
        int result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTime method, of class JobApp.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int time = 12;
        jobApp.setTime(time);
        int result = jobApp.getTime();
        assertEquals(time, result);
    }

    /**
     * Test of getCompany method, of class JobApp.
     */
    @Test
    public void testGetCompany() {
        JobApp instance = new JobApp(5, 1, "company", "position", "location", "design");
        String expResult = "company";
        String result = instance.getCompany();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompany method, of class JobApp.
     */
    @Test
    public void testSetCompany() {
        String company = "Virginia Tech";
        jobApp.setCompany(company);
        String result = jobApp.getCompany();
        assertEquals(company, result);
    }

    /**
     * Test of getPosition method, of class JobApp.
     */
    @Test
    public void testGetPosition() {
        String position = "position";
        JobApp instance = new JobApp(5, 1, "company", position, "location", "design");
        String result = instance.getPosition();
        assertEquals(position, result);
    }

    /**
     * Test of setPosition method, of class JobApp.
     */
    @Test
    public void testSetPosition() {
        String position = "Intern";
        jobApp.setPosition(position);
        String result = jobApp.getPosition();
        assertEquals(position, result);
    }

    /**
     * Test of getLocation method, of class JobApp.
     */
    @Test
    public void testGetLocation() {
        String location = "Blacksburg";
        JobApp instance = new JobApp(5, 1, "company", "position", location, "design");
        String result = instance.getLocation();
        assertEquals(location, result);
    }

    /**
     * Test of setLocation method, of class JobApp.
     */
    @Test
    public void testSetLocation() {
        String location = "Blacksburg";
        jobApp.setLocation(location);
        String result = jobApp.getLocation();
        assertEquals(location, result);
    }

    /**
     * Test of getTypeOfWork method, of class JobApp.
     */
    @Test
    public void testGetTypeOfWork() {
        String typeOfWork = "Programming";
        JobApp instance = new JobApp(5, 1, "company", "position", "location", typeOfWork);
        String result = instance.getTypeOfWork();
        assertEquals(typeOfWork, result);
    }

    /**
     * Test of setTypeOfWork method, of class JobApp.
     */
    @Test
    public void testSetTypeOfWork() {
        String typeOfWork = "Programming";
        jobApp.setTypeOfWork(typeOfWork);
        String result = jobApp.getTypeOfWork();
        assertEquals(typeOfWork, result);
    }

    /**
     * Test of equals method, of class JobApp.
     */
    @Test
    public void testEquals() {
        int id = 19;
        jobApp.setId(id);
        JobApp sameJobApp = new JobApp(id);
        assertEquals(jobApp, sameJobApp);
        int diffID = 5;
        JobApp diffJobApp = new JobApp(diffID);
        assertNotEquals(jobApp, diffJobApp);
    }

    /**
     * Test of toString method, of class JobApp.
     */
    @Test
    public void testToString() {
        JobApp instance = new JobApp(5, 12, "Virginia Tech", "Intern", "Blacksburg", "Design");
        StringBuilder str = new StringBuilder();
        str.append("Job App : [ id=5 ]");
        str.append("\n[ time=12 ]");
        str.append("\n[ company=Virginia Tech ]");
        str.append("\n[ position=Intern ]");
        str.append("\n[ location=Blacksburg ]");
        str.append("\n[ type of work=Design ]");
        assertEquals(str.toString(), instance.toString());
    }
    
}
