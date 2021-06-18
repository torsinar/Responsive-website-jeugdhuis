import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestWordLid {

	// verander de url naar jouw url naam
	private static final String url = "http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=wordLid";
	private WebDriver driver;


	// Valid values
	private final String validFirstName = "Voornaam";
	private final String validLastName = "Achternaam";
	private final String validEmail = "voornaam.achternaam@gmail.com";
	private final String validStreetName = "Straatnaam";
	private final String validCity = "Stad";
	private final int validHouseNumber = 1;
	private final int validBusNumber = 1;
	private final int validAge = 23;

	// Invalid values
	private final String invalidFirstName = "      ";
	private final String invalidLastName = "        ";
	private final String invalidEmail = "fake";
	private final String invalidStreetName = "     ";
	private final String invalidCity = "             ";
	private final int invalidHouseNumber = 5555;
	private final int invalidBusNumber = 160;
	private final int invalidAge = -12;


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emile\\Documents\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.get(this.url);
	}

	@After
	public void clean() {
		driver.quit();
	}

	@Test
	public void test_WordLid_Met_Invalid_Vnaam() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.invalidFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));
		

		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige voornaam"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Anaam() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.invalidLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige naam"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Email() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.invalidEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige email"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Leeftijd() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.invalidAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige leeftijd"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Straat() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.invalidStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige straat"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Stad() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.invalidCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige stad"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Huisnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.invalidHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.validBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige huisnummer"));
	}

	@Test
	public void test_WordLid_Met_Invalid_Busnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.validFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.validLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.validEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.validAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.validStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.validCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.validHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.invalidBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige busnummer"));
	}

	@Test
	public void test_WordLid_Met_Alle_Waardes_Invalid() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys(this.invalidFirstName);

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys(this.invalidLastName);

		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(this.invalidEmail);

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(this.invalidAge));

		// straatnaam
		WebElement straatnaam = driver.findElement(By.id("straat"));
		straatnaam.clear();
		straatnaam.sendKeys(this.invalidStreetName);

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys(this.invalidCity);

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(this.invalidHouseNumber));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(this.invalidBusNumber));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();


		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige voornaam"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige naam"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige email"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige leeftijd"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige straat"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige huisnummer"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige busnummer"));
		assertTrue(containsWebElementsWithText(lis, "Geen geldige stad"));
	}

	@Test
	public void test_WordLid_Met_BestaandeGegevensMetBusnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys("Emile");

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys("Hermans");

		// email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("r0839357@student.ucll.be");

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(19));

		// straat
		WebElement straat = driver.findElement(By.id("straat"));
		straat.clear();
		straat.sendKeys("Ergens");

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys("Anders");

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(1));

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(26));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Dit lid bestaat al"));
	}

	@Test
	public void test_WordLid_Met_BestaandeGegevensZonderBusnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys("Emile");

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys("Hermans");

		// email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("r0839357@student.ucll.be");

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(19));

		// straat
		WebElement straat = driver.findElement(By.id("straat"));
		straat.clear();
		straat.sendKeys("Ergens");

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys("Anders");

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(26));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
		assertTrue(containsWebElementsWithText(lis, "Dit lid bestaat al"));
	}






	@Test
	public void test_WordLid_LidToevoegenMetBusnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys("Kim");

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys("De Griet");

		// email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("k.dg@student.ucll.be");

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(23));

		// straat
		WebElement straat = driver.findElement(By.id("straat"));
		straat.clear();
		straat.sendKeys("Snelweg");

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys("Leuven");

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(15));

		// busnummer
		WebElement busnummer = driver.findElement(By.id("bus"));
		busnummer.clear();
		busnummer.sendKeys(String.valueOf(3));



		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();
		assertEquals("Jeugdhuis Heidestip - Leden", driver.getTitle());

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
		assertTrue(containsLid(lis, "k.dg@student.ucll.be"));

	}

	@Test
	public void test_WordLid_LidToevoegenZonderBusnummer() {
		// vnaam
		WebElement vnaam = driver.findElement(By.id("vnaam"));
		vnaam.clear();
		vnaam.sendKeys("Tim");

		// anaam
		WebElement anaam = driver.findElement(By.id("anaam"));
		anaam.clear();
		anaam.sendKeys("Bogaerts");

		// email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("t.b@student.ucll.be");

		// leeftijd
		WebElement leeftijd = driver.findElement(By.id("leeftijd"));
		leeftijd.clear();
		leeftijd.sendKeys(String.valueOf(26));

		// straat
		WebElement straat = driver.findElement(By.id("straat"));
		straat.clear();
		straat.sendKeys("VerWeg");

		// stad
		WebElement stad = driver.findElement(By.id("stad"));
		stad.clear();
		stad.sendKeys("Hiervandaan");

		// huisnummer
		WebElement huisnummer = driver.findElement(By.id("huisnummer"));
		huisnummer.clear();
		huisnummer.sendKeys(String.valueOf(36));


		WebElement addButton = driver.findElement(By.id("addButton"));
		addButton.click();
		assertEquals("Jeugdhuis Heidestip - Leden", driver.getTitle());

		ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
		assertTrue(containsLid(lis, "t.b@student.ucll.be"));

	}


	private boolean containsLid(ArrayList<WebElement> lis, String s) {
		for (WebElement l : lis)
			if(l.getText().equals(s))
				return true;

		return false;
	}



	private boolean containsWebElementsWithText(ArrayList<WebElement> lis, String s) {
		for (WebElement l : lis)
			if(l.getText().equals(s))
				return true;

		return false;
	}
}
