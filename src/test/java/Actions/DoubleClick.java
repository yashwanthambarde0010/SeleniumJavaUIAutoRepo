package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(4000);

        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions rv = new Actions(driver);

        WebElement loginButton = driver.findElement(By.xpath("//span[text()='Login']"));
        Thread.sleep(2000);

        rv.moveToElement(loginButton).perform();
        driver.close();
    }

}
