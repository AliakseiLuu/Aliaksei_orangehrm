package eu.senla;

import entities.Job;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.ViewJobTitleListPage;

public class RemoveJobTitleTest extends BaseTest {

  @Test
  @Epic("Admin")
  @Feature("Job management")
  @Story("Remove Job title")
  @Severity(SeverityLevel.NORMAL)
  @Owner("AliakseiL")
  @Description("Создание и дальнейшее удаление нового Job Title")
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

    Allure.step(
        "Job title successfully created, success toaster appears",
        () -> Assert.assertTrue(success, "Job title doesn't created"));

    ViewJobTitleListPage viewJobTitleListPage = new ViewJobTitleListPage(driver);

    boolean successRemoveJobTitle =
        viewJobTitleListPage
            .deleteJobTitle(job.getJobTitleField())
            .agreeWithDelitingJobTitle()
            .isSuccessToasterVisible();

    Allure.step(
        "Job title successfully deleted, success toaster appears",
        () -> Assert.assertTrue(successRemoveJobTitle, "Job title doesn't remove"));
  }
}
