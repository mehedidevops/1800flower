package com.shiftedtech.qa.scripts.data;

import com.shiftedtech.qa.framework.ScriptBase;
import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 * Created by Mehedi on 5/31/2017.
 */
public class SearchDataProvider{


    @DataProvider
    public static Object[][] dataProviderAsArray() {

        Object[][] data;

        data = new Object[][]{
                {"rose", "Send Roses: Rose Delivery & Rose Bouquets | 1800Flowers.com"},
                {"cactus", "Cacti, Terrariums & Succulents | Low Maintenance Plants | 1800flowers"},
                {"sunflower", "Send Sunflowers | Sunflower Bouquet Delivery | 1-800-FLOWERS.COM-10258"}
        };
        return data;
    }
}
