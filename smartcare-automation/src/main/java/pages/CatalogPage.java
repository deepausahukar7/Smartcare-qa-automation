package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage {

    WebDriver driver;

    // Search
    By searchInput = By.xpath("//input[@placeholder='Search']");

    // Status filter dropdown
    By statusDropdown = By.xpath("//div[contains(@class,'select-text')]");

    By activeOption = By.xpath("//span[text()='Active']");
    By inactiveOption = By.xpath("//span[text()='Inactive']");

    // Table rows
    By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");

    // Pagination
    By nextPageBtn = By.xpath("//button[@aria-label='Next Page']");
    By prevPageBtn = By.xpath("//button[@aria-label='Previous Page']");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔍 Search
    public void search(String text) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(text);
    }

    // 🧰 Filter
    public void filterActive() {
        driver.findElement(statusDropdown).click();
        driver.findElement(activeOption).click();
    }

    // 📄 Pagination
    public boolean hasMultipleRows() {
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.size() > 0;
    }

    public void goToNextPage() {
        driver.findElement(nextPageBtn).click();
    }
}
