import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class NotepadTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("appium:automationName", "Windows");
        caps.setCapability("appium:app","C:\\Windows\\System32\\notepad.exe");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725"), caps);
    }

    @Test
    public void typeInNotepad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Notepad edit alanı
        WebElement edit = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//Document"))); // veya: AppiumBy.xpath("//*[@ClassName='Edit']")

        edit.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        edit.sendKeys(Keys.DELETE);
        edit.sendKeys("Merhaba Appium!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
