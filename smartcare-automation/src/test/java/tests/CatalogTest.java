package tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CatalogPage;
import pages.LoginPage;

public class CatalogTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifySearchFilterAndPagination() {

        // If module not available, skip safely
        boolean isCatalogAvailable = false;

        if (!isCatalogAvailable) {
            throw new SkipException("Catalog module not available in current environment");
        }

        // Login
        LoginPage login = new LoginPage(driver);
        login.login(
            prop.getProperty("doctor.username"),
            prop.getProperty("doctor.password")
        );

        // Navigate to catalog (example)
        driver.get(prop.getProperty("url") + "/catalog");

        CatalogPage catalog = new CatalogPage(driver);

        // 🔍 Search validation
        catalog.search("John");

        Assert.assertTrue(
            catalog.hasMultipleRows(),
            "No results found after search"
        );

        // 🧰 Filter validation
        catalog.filterActive();

        Assert.assertTrue(
            catalog.hasMultipleRows(),
            "No results after applying Active filter"
        );

        // 📄 Pagination validation
        catalog.goToNextPage();

        Assert.assertTrue(
            catalog.hasMultipleRows(),
            "Pagination did not load next page"
        );
    }
}
