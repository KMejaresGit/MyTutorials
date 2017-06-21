import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kimboy on 21/6/17.
 */
public class Logout {

    public void logOut(){

        System.setProperty("webdriver.chrome.driver", "//Users//Kimboy//Java//Pre-requisites//ChromeDriver");
        WebDriver driver = new ChromeDriver();

        driver.findElement(By.xpath("/html/body/header/div/div/div/div/div/div/div/div[2]/nav/div/div[2]/div/ul/li[8]/div/span/a")).click();
        driver.findElement(By.xpath("/html/body/header/div/div/div/div/div/div/div/div[2]/nav/div/div[2]/div/ul/li[8]/ul/li[3]/a")).click();
    }
}

