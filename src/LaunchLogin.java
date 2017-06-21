import jxl.read.biff.BiffException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kimboy on 20/6/17.
 */
public class LaunchLogin {


    public static void main(String[] args) throws IOException, BiffException {

        // create object of getUrl
        GetUrl DT=new GetUrl();
        DT.readExcel();
        System.out.println("Url is : " + DT.url);


        System.setProperty("webdriver.chrome.driver", "//Users//Kimboy//Java//Pre-requisites//ChromeDriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DT.url);
        driver.manage().window().maximize();

        //Get Login Details
        GetUserAccount UserAcct = new GetUserAccount();
        UserAcct.readExcel();
        String Username = UserAcct.username;
        String Password = UserAcct.password;

        System.out.println("Username is : " + Username);
        System.out.println("Password is: " + Password);

        //login to System
        if (driver.findElement(By.xpath("//*[@id=\"menu-item-2724\"]/a")).isEnabled()) {
            System.out.println("Login button  Is enabled.");
            driver.findElement(By.xpath("//*[@id=\"menu-item-2724\"]/a")).click();

            driver.findElement(By.id("email")).sendKeys(Username);
            driver.findElement(By.id("password")).sendKeys(Password);

            driver.findElement(By.xpath("//form[@id='loginForm']/div[4]/button")).click();

            String Dashboard = driver.findElement(By.xpath("/html/body/div[1]/section/section/div/div[1]/span[3]")).getText();
            String WelcomeMsg="My Dashboard";
            if (Dashboard.equals(WelcomeMsg)){
                System.out.println("Successful Login to Crowdsprint->>" + Dashboard + " was displayed on screen");
            }else {
                System.out.println("Failed to Login to Crowdsprint");

            }

        }else {

            System.out.println("Login button Is Not enabled.");

        }


        driver.close();
        driver.quit();


    }
}
