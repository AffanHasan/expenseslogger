/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logitem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import commonprops.CommonPropsFactory;
import java.util.Currency;
import java.util.Locale;
import logitem.DefaultLogItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import logitem.LogItem;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class LogItem_Test {
    
    private LogItem logItem;
    
    private Gson gson;
    
    public LogItem_Test() {
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
    public void getJson_for_valid_json_string() {
        try{
           JsonObject jo = gson.fromJson(logItem.toJson(), JsonObject.class);
        }catch(JsonSyntaxException e){
            fail("Invalid json string");
        }
    }
    
    @Test
    public void toString_for_valid_json_string() {
        try{
           JsonObject jo = gson.fromJson(logItem.toString(), JsonObject.class);
        }catch(JsonSyntaxException e){
            fail("Invalid json string");
        }
    }
    
    @Test
    public void getJsonObject_should_return_valid_JsonObject() {
        JsonObject object;
        try{
            object = this.logItem.getJsonObject();
            object = gson.fromJson(object.toString(), JsonObject.class);
            Assert.assertEquals(object, this.logItem.getJsonObject());
        }catch(JsonSyntaxException e){
            fail("Invalid JsonObject Returned");
        }catch(Exception e){
            fail("Invalid JsonObject Returned");
        }
    }
    
    @Test
    public void currency_locale_should_match_systems_default_currency_locale_for_a_newly_created_object() {
        assertEquals(this.logItem.getJsonObject().getAsJsonObject("expense_amount").get("currency_code").getAsString(),
                    CommonPropsFactory.getInstance().getSystemCurrencyCode());
    }
    
    @Test
    public void by_default_amount_should_be_zero_point_zero(){
        LogItem logItem = new DefaultLogItem();
        assertEquals(0.0, 
        logItem.getJsonObject()
                .getAsJsonObject("expense_amount").get("amount").getAsFloat(),
                0.0
        );
    }
}