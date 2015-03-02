package selenium_loadable_component;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The sample usage of LoadableComponent from https://code.google.com/p/selenium/wiki/LoadableComponent
 */
public class FooTest {
  private EditIssue editIssue;
  private WebDriver driver;

  @Before
  public void prepareComponents() {
    driver = new FirefoxDriver();

    ProjectPage project = new ProjectPage(driver, "selenium");
    SecuredPage securedPage = new SecuredPage(driver, project, System.getProperty("username"), System.getProperty("password"));
    editIssue = new EditIssue(driver, securedPage);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void demonstrateNestedLoadableComponents() {
    editIssue.get();

    editIssue.setSummary("Summary");
    editIssue.enterDescription("This is an example");
  }
}