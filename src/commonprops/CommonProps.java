/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonprops;

import java.util.Currency;

/**
 * Provides methods for accessing system wide common properties
 * @author root
 */
public interface CommonProps {
    
    void setSystemCurrency(String currencyCode);
    
    /**
     * Returns the systems default currency code
     * @return 
     */
    String getSystemCurrencyCode();
    
    String getSystemCurrencySymbol();
    
    /**
     * Returns the systems default currency object
     * @return 
     */
    Currency getSystemCurrency();
    
}
