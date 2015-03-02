package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditIssuePage {
  public void setSummary(String issueSummary) {
    $(By.name("summary")).val(issueSummary);
  }

  public void enterDescription(String description) {
    $(By.name("comment")).val(description);
  }
}
