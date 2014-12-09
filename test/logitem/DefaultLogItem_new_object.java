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
public class DefaultLogItem_new_object {
    
    private LogItem logItem;
    
    private Gson gson;
    
    public DefaultLogItem_new_object() {
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
    public void currency_code_should_match_default_currency_code() {
        assertEquals(this.logItem.getCurrencyCode(),
                    CommonPropsFactory.getInstance().getSystemCurrencyCode());
    }
    
    @Test
    public void currency_symbol_should_match_default_currency_symbol() {
        assertEquals(this.logItem.getCurrencySymbol(),
                    CommonPropsFactory.getInstance().getSystemCurrencySymbol());
    }
    
    @Test
    public void by_default_amount_should_be_zero_point_zero(){
        assertEquals(0.0, this.logItem.getExpenseAmount(), 0.0);
    }
    
    @Test
    public void new_logItem_must_contain_empty_text_for_category(){
        assertEquals("", this.logItem.getCategory());
    }
    
    @Test
    public void logItem_must_return_empty_text_for_description(){
        assertEquals("", this.logItem.getDescription());
    }
    
    @Test
    public void getJsonObject_test_for_basic_json_document_structure(){
        JsonObject object = this.logItem.getJsonObject();
        validateDocumentStructure(object);
    }
    
    /**
     * This test checks that the JSON string returned by toString() method is following the correct document structure
     */
    @Test
    public void toString_test_for_basic_json_document_structure(){
        JsonObject object = gson.fromJson(this.logItem.toString(), JsonObject.class);
        validateDocumentStructure(object);
    }
    
    /**
     * This test checks that the JSON string returned by toJson() method is following the correct document structure
     */
    @Test
    public void toJson_test_for_basic_json_document_structure(){
        JsonObject object = gson.fromJson(this.logItem.toJson(), JsonObject.class);
        validateDocumentStructure(object);
    }
    
    private void validateDocumentStructure(JsonObject object){
        try{
            assertTrue(object.has("description"));
            object.get("description").getAsString();
            assertTrue(object.has("category"));
            object.get("category").getAsString();
            assertTrue(object.has("expense"));
            object.get("expense").getAsJsonObject();
            assertTrue(object.getAsJsonObject("expense").has("amount"));
            object.getAsJsonObject("expense").get("amount").getAsFloat();
            assertTrue(object.getAsJsonObject("expense").has("currency_code"));
            object.getAsJsonObject("expense").get("currency_code").getAsString();
            assertTrue(object.getAsJsonObject("expense").has("currency_symbol"));
            object.getAsJsonObject("expense").get("currency_symbol").getAsString();
        }catch( IllegalStateException | ClassCastException e ){
            fail(e.getMessage());
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
}