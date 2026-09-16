package eu.senla;

import entities.Job;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.ViewJobTitleListPage;

public class RemoveJobTitleTest extends BaseTest {

  @Test
  public void testSuccessRemoveJobTitle() {

    Job job =
        Job.builder()
            .jobTitleField(faker.name().title())
            .jobDescriptionField(faker.address().fullAddress())
            .jobAddNoteField(faker.company().suffix())
            .build();

    boolean success =
        new Dashboard(driver)
            .getSidepanel()
            .openAdmin()
            .openJobTitlesPage()
            .openAddJobTitlesPage()
            .fillForm(job)
            .isSuccessToasterVisible();

    Assert.assertTrue(success, "Job title doesn't created");

    ViewJobTitleListPage viewJobTitleListPage = new ViewJobTitleListPage(driver);

    boolean successRemoveJobTitle =
        viewJobTitleListPage
            .deleteJobTitle(job.getJobTitleField())
            .agreeWithDelitingJobTitle()
            .isSuccessToasterVisible();

    Assert.assertTrue(successRemoveJobTitle, "Job title doesn't remove");
  }
}
