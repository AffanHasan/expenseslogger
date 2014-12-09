/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonprops;

import java.util.Currency;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.Ignore;

/**
 *
 * @author root
 */
public class CommonPropsTest {
    
    private final String _defaultCurrencyCode = "USD";
    
    private final CommonProps commonProps;
    
    public CommonPropsTest() {
        this.commonProps = CommonPropsFactory.getInstance();
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
    public void getSystemCurrency() {
       Currency currency = Currency.getInstance(_defaultCurrencyCode);
       assertEquals(currency, commonProps.getSystemCurrency());
    }
    
    @Test
    public void getSystemCurrencyCode() {
       assertEquals(_defaultCurrencyCode, commonProps.getSystemCurrencyCode());
    }
    
    @Test
    @Ignore
    public void setSystemCurrency_check_if_choice_saved_in_data_store() {
       fail();
    }
}