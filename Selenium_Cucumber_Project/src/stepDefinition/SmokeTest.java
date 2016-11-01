package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BrowserFactory;
import utils.BrowserName;
import utils.Chrome;
import utils.ThreadUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	public static final String URL= "http://www.rijksmuseum.nl";
	public static final String EMAIL = "test39862@gmail.com";
	public static final String PASSWORD = "P@ssw0rd";
	
	By email = By.name("email");
	By wachtwoord = By.cssSelector("#wachtwoord");
	By loginLink= By.cssSelector("body > header > div > nav > div > nav > button");
	By loginButton = By.xpath("/html/body/div[5]/section/section[2]/div[1]/div/form/fieldset/ol/li[4]/input");
		
	WebDriver webDriver;
	
//	@Before
//	 public void SetUp() {
//		Chrome chrome = (Chrome)BrowserFactory.getBrowser(BrowserName.CHROME);
//		wd = chrome.getChromeDriver();
//	}
	
	@Given("^Open Chrome browser and start application$")
	public void open_Chrome_browser_and_start_application() throws Throwable {
		Chrome chrome = (Chrome)BrowserFactory.getBrowser(BrowserName.CHROME);
		webDriver = chrome.getChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(URL);
		webDriver.findElement(loginLink).click();
		ThreadUtils.waitForDocumentReady(webDriver);
	}

	@When("^I enter valid username$")
	public void i_enter_valid_username() throws Throwable {
		webDriver.findElement(email).sendKeys(EMAIL);
	}

	@When("^I enter valid password$")
	public void i_enter_valid_password() throws Throwable {
		webDriver.findElement(wachtwoord).sendKeys(PASSWORD);
	}

	@Then("^User should be able to login succefully$")
	public void user_should_be_login() throws Throwable {
		webDriver.findElement(loginButton).click();
	}

}
