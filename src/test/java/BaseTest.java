import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by nabil on 2016-11-17
 */
public class BaseTest {
	private WebDriver webdriver;
	NameGuesserImplentation nameGuessObject;

	@BeforeClass
	public void setup(){
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		webdriver = new ChromeDriver(options);
		webdriver.get("http://first-name-guesser.herokuapp.com/");
		nameGuessObject = new NameGuesserImplentation(webdriver);
	}

	@AfterClass
	public void teardown(){
		webdriver.quit();
	}
}
