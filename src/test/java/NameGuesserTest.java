import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nabil on 2016-11-17
 */
public class NameGuesserTest extends BaseTest{
	@Test
	public void fullNameWithPrenominal(){
		Assert.assertTrue(nameGuessObject.setText("Mr John Doe"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("John"), "John was expected but found: "
				+ firstName);
	}

	@Test
	public void dotPrenominal(){
		Assert.assertTrue(nameGuessObject.setText("Mr. John Doe"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("John"), "John was expected but found: "
				+ firstName);
	}

	@Test
	public void singleNameWithPostNominal(){
		Assert.assertTrue(nameGuessObject.setText("Mr John PhD"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("John"), "John was expected but found: "
				+ firstName);
	}

	@Test
	public void lowerCaseNameAndPrenominal(){
		Assert.assertTrue(nameGuessObject.setText("mr john"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("john"), "John was expected but found: "
				+ firstName);
	}

	@Test
	public void emptyField(){
		Assert.assertTrue(nameGuessObject.setText(""));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals(""), "TextField is supposed to be empty but found "
				+ firstName);
	}

	@Test
	public void nameWithoutNominals(){
		Assert.assertTrue(nameGuessObject.setText("John Doe"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("John"), "John was expected but found: "
				+ firstName);
	}

	@Test
	public void nameWithComma(){
		Assert.assertTrue(nameGuessObject.setText("Doe, John"));
		String firstName = nameGuessObject.getFirstName();
		Assert.assertTrue(firstName.equals("John"), "John was expected but found: "
				+ firstName);
	}
}
