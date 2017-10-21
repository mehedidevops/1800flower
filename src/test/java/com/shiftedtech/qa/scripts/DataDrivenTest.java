package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.ScriptBase;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mehedi on 5/31/2017.
 */

@RunWith(DataProviderRunner.class)
public class DataDrivenTest extends ScriptBase {

    @Test
    public void test1() {
        homePage.search("rose");
        searchResultPage.verifyTitle("Send Roses: Rose Delivery & Rose Bouquets | 1800Flowers.com");
    }


    @Test
    public void test2() {
        homePage.search("cactus");
        searchResultPage.verifyTitle("Cacti, Terrariums & Succulents | Low Maintenance Plants | 1800flowers");
    }


    @Test
    @UseDataProvider("dataProviderAsArray")
    public void dataDrivenTest(String searchItem, String pageTitle) {

        homePage.search(searchItem);
        searchResultPage.verifyTitle(pageTitle);
    }

    /**@Test
    @UseDataProvider("dataProviderFromExcel")
    public void dataDrivenTest2(String searchItem, String pageTitle) {

        homePage.search(searchItem);
        searchResultPage.verifyTitle(pageTitle);
    }*/

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

   /**@DataProvider
    public static Object[][] dataProviderFromExcel() {

        Object[][] data = null;

        String dataFile = System.getProperty("user.dir") + "/src/test/resources/1800flowers/location.xls";
        File file = new File(dataFile);
        if (file.exists()) {

            try {
                Workbook workbook = Workbook.getWorkbook(file);
                Sheet sheet = workbook.getSheet(0);

                data = new Object[sheet.getRows() - 1][sheet.getColumns()];

                String cellData = null;
                for (int j = 0; j < sheet.getColumns(); j++) {
                    for (int i = 1; i < sheet.getRows(); i++) {
                        Cell cell = sheet.getCell(j, i);
                        CellType type = cell.getType();
                        if (type == CellType.LABEL) {
                            cellData = cell.getContents();
                        } else if (type == CellType.NUMBER) {
                            cellData = cell.getContents().toString();
                        } else {
                            System.out.println("Unknown cell type");
                        }
                        data[i - 1][j] = cellData;
                    }

                }

            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return data;

    }
}*/
