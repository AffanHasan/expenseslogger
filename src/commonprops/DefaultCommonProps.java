/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonprops;

import java.util.Currency;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
class DefaultCommonProps implements CommonProps {
    
    private Currency _defaultCurrency; 

    @Override
    public void setSystemCurrency(String currencyCode) {
        try{
            this._defaultCurrency = Currency.getInstance(currencyCode);
        }catch(NullPointerException | IllegalArgumentException e){
            Logger.getLogger(DefaultCommonProps.class.getName()).log(Level.SEVERE, 
                    "Illegal currency code passed", e);
        }
    }

    @Override
    public String getSystemCurrencyCode() {
        try{
            return this._defaultCurrency.getCurrencyCode();
        }catch(NullPointerException e){
            return null;
        }
    }

    @Override
    public Currency getSystemCurrency() {
        return this._defaultCurrency;
    }
    
}
