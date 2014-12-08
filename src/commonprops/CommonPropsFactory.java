/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonprops;

/**
 *
 * @author root
 */
public class CommonPropsFactory {
    
    private static String _currencyCode = "USD";
    private static CommonProps _instance = new DefaultCommonProps();
    
    public static CommonProps getInstance(){
        _instance.setSystemCurrency(_currencyCode);
        return _instance;
    }
}
