package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientCatalogPage {

    WebDriver driver;

    // Search box
    By searchInput = By.id("patient-search");

    // Patient rows (table)
    By patientRows = By.xpath("//table[@id='patientTable']//tbody//tr");

    public PatientCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchPatient(String patientName) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(patientName);
    }

    public boolean isPatientPresent(String patientName) {
        List<WebElement> rows = driver.findElements(patientRows);
        for (WebElement row : rows) {
            if (row.getText().contains(patientName)) {
                return true;
            }
        }
        return false;
    }
}
