package simplCheck.simplCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import POM.POM_SimplChk;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Login {
public static WebDriver obj;
public static Properties prop;
public static Logger log=Logger.getLogger(Login.class.getName());

public Login()
{
	this.obj=obj;
}
public WebDriver getDriver()
{
	return this.obj;
}
@When("Signup the simplcheck app")
public void signup_Page()
{
	POM_SimplChk ps=new POM_SimplChk(obj);
	ps.LoginButton.click();
     WebDriverWait ww=new WebDriverWait(obj, 10);
	WebElement element=ww.until(ExpectedConditions.elementToBeClickable(By.id("")));
}
@BeforeMethod
@Given("Enter app url")
public void Before_Method() throws IOException
{
	PropertyConfigurator.configure("C:\\Users\\prakashd\\Prakash_Automation\\simplCheck\\src\\test\\java\\log4jj.properties");
	System.setProperty("webdriver.chrome.driver", "D:\\PRAKASH DOCS\\PRAKASH_Softwares\\chromedriver_win32\\chromedriver.exe");
	FileInputStream fis=new FileInputStream("C:\\Users\\prakashd\\Prakash_Automation\\simplCheck\\src\\test\\java\\simplCheck\\simplCheck\\simplcheck.properties");
	prop=new Properties();
	prop.load(fis);
	obj=new ChromeDriver();
	obj.get(prop.getProperty("url"));
	obj.manage().window().maximize();
}
@After
public void Screnshot(Scenario scenario) {  
    if (scenario.isFailed()) {  
        try {  
      	  scenario.write("Current Page URL is " + obj.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) obj).getScreenshotAs(OutputType.BYTES); 
            
            scenario.embed(screenshot, "image/png");  
        } catch (WebDriverException wde) {  
            System.err.println(wde.getMessage());  
        } catch (ClassCastException cce) {  
            cce.printStackTrace();  
        }  
    }}
}
