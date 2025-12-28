package eu.senla;

import entities.Job;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddJobTitle extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void testSuccessLogin(
        @Optional("Admin") String username, @Optional("admin123") String password) {

        Job job = Job.builder()
                .jobTitleField(faker.name().title())
                .jobDescriptionField(faker.address().fullAddress())
                .jobAddNoteField(faker.company().suffix())
                .build();

        LoginPage loginPage = new LoginPage(driver);

        boolean success = loginPage
                .login(username, password)
                .waitForDashboardHeader()
                .getLeftSideMenu()
                .openAdmin()
                .openJobTitlesPage()
                .openAddJobTitlesPage()
                .fillForm(job)
                .isSuccessSavingToasterVisible();

        Assert.assertTrue(success, "Job title doesn't created");
    }
}
