package eu.senla;

import entities.Job;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;

public class AddJobTitleTest extends BaseTest {

  @Test
  public void testAddJobTitle() {

    Job job =
        Job.builder()
            .jobTitleField(faker.name().title())
            .jobDescriptionField(faker.address().fullAddress())
            .jobAddNoteField(faker.company().suffix())
            .build();

    boolean success =
        new Dashboard(driver)
            .waitForDashboardHeader()
            .getSidepanel()
            .openAdmin()
            .openJobTitlesPage()
            .openAddJobTitlesPage()
            .fillForm(job)
            .isSuccessToasterVisible();

    Assert.assertTrue(success, "Job title doesn't created");
  }
}
