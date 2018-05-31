package java;

import org.openqa.selenium.chrome.ChromeDriver;

public class CatOverviewSmokeTest {

    public void meow() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.launchApp("Meow");
    }
}
