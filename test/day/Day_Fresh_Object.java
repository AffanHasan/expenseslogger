/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logitem.LogItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class Day_Fresh_Object {
    
    private Day _day;
    
    public Day_Fresh_Object() {
        _day = new DefaultDay();
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

    @Test
    public void getLogEntries_should_return_empty_list(){
        assertTrue(_day.getLogEntries().isEmpty());
    }

    @Test
    public void getDate_should_return_Date(){
        assertTrue(_day.getDate() instanceof Date);
    }

    @Test
    public void create_by_date(){
        Date date = new Date(System.currentTimeMillis());
        Day day = new DefaultDay(date);
        assertEquals(date, day.getDate());
    }
}