package tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;

public class PatientCatalogTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyPatientSearch() {

        // Patient Catalog module is not available in current test environment
        throw new SkipException(
            "Patient Catalog module not available in current environment"
        );
    }
}
