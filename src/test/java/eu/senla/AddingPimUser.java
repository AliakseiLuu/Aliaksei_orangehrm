package eu.senla;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddingPimUser extends BaseTest {

  @Test
  public void testSuccessAddPIM_Employee() {
    successLogin("Admin", "admin123");
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/ul[@class='oxd-main-menu']")));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='PIM']")));

    driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")));

    driver.findElement(By.xpath("//button[text()=' Add ']")).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[@class='oxd-input-group']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name='firstName']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name='lastName']")));

    driver.findElement(By.xpath("//div/input[@name='firstName']")).sendKeys("FirstNameTestUser");
    driver.findElement(By.xpath("//div/input[@name='lastName']")).sendKeys("LastNameTestUser");

    driver.findElement(By.xpath("//button[text()=' Save ']")).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/div[contains(@class,'oxd-toast')]")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[text()='Success']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/h6[text()='Personal Details']")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div/h6[normalize-space(.)!='']")));
  }
}
