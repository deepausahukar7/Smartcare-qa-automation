package tests;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return ExcelUtils.getTestData("Sheet1");
    }
}
