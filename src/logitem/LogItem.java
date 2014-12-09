/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logitem;

import com.google.gson.JsonObject;

/**
 *
 * @author root
 */
public interface LogItem{
    
    /**
     * Should return the jsonic string representation
     * @return 
     */
    String toJson();
    
    /**
     * Returns the JsonObject representation
     * @return 
     */
    JsonObject getJsonObject();
    
    String getCategory();
    
    String getDescription();
    
    String getCurrencyCode();
    
    String getCurrencySymbol();
    
    /**
     * Returns a float amount value
     * @return 
     */
    float getExpenseAmount();
    
    void setDescription(String description);
    
    void setCategory(String category);
    
    void setExpenseAmount(float amount);
}