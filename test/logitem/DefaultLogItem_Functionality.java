/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logitem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import commonprops.CommonPropsFactory;
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
    
    private float _amount = 10.0f;
    
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
    
    @Test
    public void setExpense(){
        setExpenseAmount(_amount);
        assertEquals(_amount, this.logItem.getExpenseAmount(), 0.0);
    }
    
    @Test
    public void setExpense_currency_symbol_correctness(){
        setExpenseAmount(_amount);
        assertEquals(CommonPropsFactory.getInstance().getSystemCurrencySymbol(), 
                        this.logItem.getCurrencySymbol());
    }
    
    @Test
    public void setExpense_currency_code_correctness(){
        setExpenseAmount(_amount);
        assertEquals(CommonPropsFactory.getInstance().getSystemCurrencyCode(),
                        this.logItem.getCurrencyCode());
    }
    
    private void setExpenseAmount(float amount){
        this.logItem.setExpenseAmount(amount);
    }
}