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
//      Adding "expense_amount"
        JsonObject expenseAmount = new JsonObject();
        expenseAmount.addProperty("currency_code", commonprops.
                CommonPropsFactory.getInstance().getSystemCurrencyCode());
        expenseAmount.addProperty("amount", 0.0);
        data.add("expense_amount",  expenseAmount);
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
}