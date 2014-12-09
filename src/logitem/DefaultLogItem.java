/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logitem;

import com.google.gson.JsonObject;
import commonprops.CommonPropsFactory;
import java.util.Currency;

/**
 *
 * @author root
 */
public class DefaultLogItem implements LogItem {
    
    private final JsonObject data;
    
    public DefaultLogItem(){
        data = new JsonObject();
//      Adding "expense" as JsonObject
        JsonObject expense = new JsonObject();
        expense.addProperty("currency_code", CommonPropsFactory.getInstance().getSystemCurrencyCode());
        expense.addProperty("amount", 0.0);        
        this.data.add("expense", expense);

        this.data.addProperty("category", "");
        this.data.addProperty("description", "");
    }

    @Override
    public String toJson() {
        return toString();
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    @Override
    public JsonObject getJsonObject() {
        return data;
    }

    @Override
    public String getCategoryAsText() {
        try{
            return this.data.get("category").getAsString();
        }catch(NullPointerException e){
            return null;
        }
    }

    @Override
    public String getDescriptionAsText() {
        try{
            return this.data.get("description").getAsString();
        }catch(NullPointerException e){
            return null;
        }
    }

    @Override
    public String getCurrencyCode() {
        try{
            return this.data.getAsJsonObject("expense").get("currency_code").getAsString();
        }catch(NullPointerException e){
            return null;
        }
    }

    @Override
    public float getExpenseAmount() {
        try{
            return this.data.getAsJsonObject("expense").get("amount").getAsNumber().floatValue();
        }catch(NullPointerException e){
            throw new NullPointerException();
        }
    }
}