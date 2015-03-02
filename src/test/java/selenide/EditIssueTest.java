package selenide;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class EditIssueTest {
  @Test
  public void userCanEditIssueDetails() {
    LoginPage loginPage = page(LoginPage.class);
    loginPage.login(System.getProperty("username"), System.getProperty("password"));
    
    EditIssuePage editIssuePage = open("http://code.google.com/p/selenium/issues/entry", EditIssuePage.class);
    editIssuePage.setSummary("Summary");
    editIssuePage.enterDescription("This is an example");
  }
}
