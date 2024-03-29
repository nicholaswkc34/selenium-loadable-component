package selenium_loadable_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.assertTrue;

public class EditIssue extends LoadableComponent<EditIssue> {

  private final WebDriver driver;
  private SecuredPage securedPage;

  // By default the PageFactory will locate elements with the same name or id
  // as the field. Since the summary element has a name attribute of "summary"
  // we don't need any additional annotations.
  private WebElement summary;

  // Same with the submit element, which has the ID "submit"
  private WebElement submit;

  // But we'd prefer a different name in our code than "comment", so we use the
  // FindBy annotation to tell the PageFactory how to locate the element.
  @FindBy(name = "comment") private WebElement description;

  public EditIssue(WebDriver driver, SecuredPage securedPage) {
    this.driver = driver;
    this.securedPage = securedPage;

    // This call sets the WebElement fields.
    PageFactory.initElements(driver, this);
  }

  @Override
  protected void load() {
    securedPage.get();
    driver.get("http://code.google.com/p/selenium/issues/entry");
  }

  @Override
  protected void isLoaded() throws Error {
    String url = driver.getCurrentUrl();
    assertTrue("Not on the issue entry page: " + url, url.endsWith("/entry"));
  }

  public void setSummary(String issueSummary) {
    clearAndType(summary, issueSummary);
  }

  public void enterDescription(String issueDescription) {
    clearAndType(description, issueDescription);
  }

  public IssueList submit() {
    submit.click();
    return new IssueList(driver);
  }

  private void clearAndType(WebElement field, String text) {
    field.clear();
    field.sendKeys(text);
  }
}