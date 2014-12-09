/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logitem;

import com.google.gson.Gson;
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
public class DefaultLogItem_Functionality {
    
    private LogItem logItem;
    
    private Gson gson;
    
    private String text = null;
    
    public DefaultLogItem_Functionality() {
        logItem = new DefaultLogItem();
        gson = new Gson();
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
    public void setDescription(){
        this.text = "Some sample expense activity";
        logItem.setDescription(text);
        assertEquals(text, logItem.getDescription());
    }
    
    @Test
    public void setCategory(){
        this.text = "Sample Category";
        logItem.setCategory(text);
        assertEquals(text, logItem.getCategory());
    }
}