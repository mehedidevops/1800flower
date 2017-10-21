package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.ScriptBase;
import com.shiftedtech.qa.scripts.data.SearchDataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Mehedi on 5/31/2017.
 */

@RunWith(DataProviderRunner.class)
public class DataDrivenTest2 extends ScriptBase {

    @Test
    @UseDataProvider(location = {SearchDataProvider.class},value="dataProviderAsArray")
    public void dataDrivenTest(String searchItem, String pageTitle) {

        homePage.search(searchItem);
        searchResultPage.verifyTitle(pageTitle);
    }
}
