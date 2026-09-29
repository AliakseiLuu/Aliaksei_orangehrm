package eu.senla;

import entities.Job;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;

public class AddJobTitleTest extends BaseTest {

  @Test
  @Epic("Admin")
  @Feature("Job management")
  @Story("Add job title")
  @Severity(SeverityLevel.NORMAL)
  @Owner("AliakseiL")
  @Description("Создание нового Job Title")
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

    Allure.step(
        "Job title successfully created, success toaster appears",
        () -> Assert.assertTrue(success, "Job title doesn't created"));
  }
}
