
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AsistentMen {
    protected WebDriver driver;
    private String baseUrl;


    @BeforeMethod
    @Parameters("browser")
//change Optional to change Browser
    public void setup(@Optional("chrome") String browser) {

        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "C:/Users/USER-PC/Documents/Natalia/driver/chromedriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "C:/Users/USER-PC/Documents/Natalia/driver/chromedriver.exe");
            //create chrome instance
            driver = new ChromeDriver();
        } else {
            //If no browser passed throw exception
            System.out.println("Browser is not corr   ect");
        }
        baseUrl = "https://csssr.github.io/qa-engineer/";
        driver.manage().window().maximize();



        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void testDown() {
        driver.quit();

    }

    @Test
    public void Iskl_1() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'НАХОДИТЬ НЕСОВЕРШЕНСТВА')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Софт для быстрого создания скриншотов')]")).click();
        Thread.sleep(1000);
        System.out.println("Переходим на сайт https://app.prntscr.com/ru/");
}}
