import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nabil on 2016-11-17
 */
class NameGuesserImplentation {
	private static final By textInput = By.name("name");
	private static final By submitButton = By.id("gobutton");
	private static final By firstName = By.id("firstname");
	final WebDriverWait wait;

	private WebDriver webdriver;
	NameGuesserImplentation(WebDriver driver){
		webdriver = driver;
		wait = new WebDriverWait(webdriver, 3);
	}


	private WebElement getVisibleElement(final By whichSelector) {

		WebElement el = null;
		try {
			el = wait.until(ExpectedConditions
					.presenceOfElementLocated(whichSelector));
		} catch (Exception ignored) {}
		return el;
	}

	 boolean setText(final String text){
		WebElement textField = getVisibleElement(textInput);
		textField.clear();
		textField.sendKeys(text);
		getVisibleElement(submitButton).click();
		 //Wait for page to load the changes
		 try {
			 Thread.sleep(500);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
		 return textField.getAttribute("value").equals(text);

	}

	String getFirstName(){
		return getVisibleElement(firstName).getText();
	}
}
