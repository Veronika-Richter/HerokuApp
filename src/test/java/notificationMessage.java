import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class notificationMessage {

    @Test
    public void testNotification() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement clickHere = webDriver.findElement(By.xpath("//*[@href='/notification_message']"));
        clickHere.click();
        WebElement checkHere = webDriver.findElement(By.xpath("//*[@class='flash notice']"));
        String value = checkHere.getAttribute("innerText");
        assertEquals(value, " Action successful\n" + "×", "Неверное сообщение!");

        webDriver.quit();

    }

}

