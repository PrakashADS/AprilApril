package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_SimplChk {
WebDriver driver;

    @FindBy(xpath="//*[@id='bs-example-navbar-collapse-1']/ul/li[7]/b/a")
    public WebElement LoginButton;

	public POM_SimplChk(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
