package simplCheck.simplCheck;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

features="C:\\Users\\prakashd\\Prakash_Automation\\simplCheck\\src\\test\\java\\simplCheck.feature",
    		 	      		
			   plugin = {"pretty", "html:target/cucumber-html-report/ScreenshotSimplCheck","json:cucumber.json"},
	   tags={
	//  	"~@Signup",
	
		  
  
    

})
public class Runner {

}