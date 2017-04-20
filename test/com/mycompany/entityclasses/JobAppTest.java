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
 * @author Justin Park
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
     * Test of getJobDate method, of class JobApp.
     */
    @Test
    public void testGetJobDate() {
        System.out.println("getJobDate");
        JobApp instance = new JobApp(5, "company", "position", "location", "design");
        java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
        java.sql.Date result = instance.getJobDate();
        assertEquals(today, result);
    }

    /**
     * Test of setDate method, of class JobApp.
     */
    @Test
    public void testSetJobDate() {
        System.out.println("setJobDate");
        java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
        jobApp.setJobDate(today);
        java.sql.Date result = jobApp.getJobDate();
        assertEquals(today, result);
    }

    /**
     * Test of getCompany method, of class JobApp.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        JobApp instance = new JobApp(5, "company", "position", "location", "design");
        String expResult = "company";
        String result = instance.getCompany();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompany method, of class JobApp.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
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
        System.out.println("getPosition");
        String position = "position";
        JobApp instance = new JobApp(5, "company", position, "location", "design");
        String result = instance.getPosition();
        assertEquals(position, result);
    }

    /**
     * Test of setPosition method, of class JobApp.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
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
        System.out.println("getLocation");
        String location = "Blacksburg";
        JobApp instance = new JobApp(5, "company", "position", location, "design");
        String result = instance.getLocation();
        assertEquals(location, result);
    }

    /**
     * Test of setLocation method, of class JobApp.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
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
        System.out.println("getTypeOfWork");
        String typeOfWork = "Programming";
        JobApp instance = new JobApp(5, "company", "position", "location", typeOfWork);
        String result = instance.getTypeOfWork();
        assertEquals(typeOfWork, result);
    }

    /**
     * Test of setTypeOfWork method, of class JobApp.
     */
    @Test
    public void testSetTypeOfWork() {
        System.out.println("setTypeOfWork");
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
        System.out.println("equals");
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
        System.out.println("toString");
        JobApp instance = new JobApp(5, "Virginia Tech", "Intern", "Blacksburg", "Design");
        java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
        String theDate = today.toString();
        StringBuilder str = new StringBuilder();
        str.append("Job App : [ id=5 ]");
        str.append("\n[ date=" + theDate + " ]");
        str.append("\n[ company=Virginia Tech ]");
        str.append("\n[ position=Intern ]");
        str.append("\n[ location=Blacksburg ]");
        str.append("\n[ type of work=Design ]");
        assertEquals(str.toString(), instance.toString());
    }
    
}
