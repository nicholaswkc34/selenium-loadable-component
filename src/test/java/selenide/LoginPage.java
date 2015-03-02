package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
  public void login(String username, String password) {
    open("https://www.google.com/accounts/ServiceLogin?service=code");
    $(By.name("Email")).val(username);
    $(By.name("Passwd")).val(password).submit();
  }
}
