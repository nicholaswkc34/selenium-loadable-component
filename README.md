Selenium LoadableComponent comparison with Selenide
========================

Current example shows how much Selenide code is shorter and simpler than LoadableComponent/PageFactory

### What's going on

Hi!
You are observing a sample github project that should demonstrate you power of Selenide.
Please find 2 different implementations of the same test.

1. With Selenium [LoadableComponent](https://code.google.com/p/selenium/wiki/LoadableComponent) - see package `src/test/java/selenium_loadable_component`
2. With [Selenide](http://selenide.org/) - see package `src/test/java/selenide`

### Results

Number of lines:

* With Selenium webdriver and LoadableComponent: **191 lines**
* With Selenide: **47 lines**

As you see, tests with Selenide are much, much shorter and simpler. With Selenide you don't need to bother with
loadings, ajax, timings, browser issues etc. You can **concentrate on business logic**! 

### How to run

To run tests, just type from command line:

```
mvn test -Dusername=your_email@gmail.com -Dpassword=your_gmail_password
```

### How to setup IDEA project

To prepare an IDEA project, just run `mvn dependency:copy-dependencies` and import *.iml file into IDEA.

_Feel free to share your feedback!_

