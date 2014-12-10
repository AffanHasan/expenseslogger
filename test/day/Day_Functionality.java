/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

import logitem.DefaultLogItem;
import logitem.LogItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author root
 */
public class Day_Functionality {
    
    private Day _day;
    
    public Day_Functionality() {
    }
    
    @Rule
    public final ExpectedException iobException = ExpectedException.none();
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        _day = new DefaultDay();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addLogItem_should_add_LogItem() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        assertTrue(_day.getLogEntries().size() == 1);
    }

    @Test
    public void addLogItem_should_add_LogItem_objects_must_match() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        assertEquals(logItem, _day.getLogEntries().get(0));
    }

    @Test
    public void removeLogItem_should_delete_at_index() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        _day.removeLogItem(0);
        assertTrue(_day.getLogEntries().isEmpty());
    }

    @Test
    public void getLogItem_at_index() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        assertNotNull(_day.getLogItem(0));
    }
    
    @Test
    public void getLogItem_must_throw_IndexOutOfBound() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        iobException.expect(IndexOutOfBoundsException.class);
        _day.getLogItem(1);
    }

    @Test
    public void updateLogItem_should_replace_at_index_with_provided_LogItem() {
        String category = "Neu Category";
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        LogItem item = new DefaultLogItem();
        item.setCategory(category);
        _day.updateLogItem(0, item);
        assertEquals(category, _day.getLogEntries().get(0).getCategory());
    }
    
    @Test
    public void updateLogItem_must_throw_IndexOutOfBound() {
        LogItem logItem = new DefaultLogItem();
        _addLogItem(_day, logItem);
        LogItem item = null;
        iobException.expect(IndexOutOfBoundsException.class);
        _day.updateLogItem(2, item);
    }
    
    private void _addLogItem(Day day, LogItem logItem){
        day.addLogItem(logItem);
    }
}