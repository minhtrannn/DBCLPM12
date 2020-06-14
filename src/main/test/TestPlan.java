import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Submit a WebForm")
    public static void submitForm(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.enterPasswordRepeat();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyAlertSuccess();
    }

    @Test(testName = "Submit a LoginForm")
    public static void submitLoginForm(){
        driver.get(Utils.LOG_IN);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailLogin();
        webForm.enterPasswordLogin();
        webForm.loginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(testName = "Submit a DeclareForm")
    public static void submitDeclareForm(){
        driver.get(Utils.LOG_IN);
        WebForm webForm = new WebForm(driver);
        webForm.enterEmailLogin();
        webForm.enterPasswordLogin();
        webForm.loginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Utils.DECLARE_INFO);
//        WebForm webForm = new WebForm(driver);
        webForm.enterName();
        webForm.enterHousehold();
        webForm.enterAddress();
        webForm.enterSalary();
        webForm.enterID();
        webForm.enterGender();
        webForm.enterPhone();
        webForm.enterEthnic();
        webForm.enterCityID();
        webForm.declareButton();
        webForm.enterDay();
        webForm.enterMonth();
        webForm.enterYear();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }


    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}