import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestUpdateLid {
    // verander de url naar jouw url naam
    private static final String url = "http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=update&vnaam=Emile&anaam=Hermans&email=r0839357@student.ucll.be&leeftijd=19&straat=Ergens&huisnummer=26&bus=0&stad=Anders";
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
    public void test_Update_InvalidVoornaam() {
        // vnaam
        WebElement vnaam = driver.findElement(By.id("vnaam"));
        vnaam.clear();
        vnaam.sendKeys(this.invalidFirstName);

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige voornaam"));
    }

    @Test
    public void test_Update_InvalidNaam() {
        // vnaam
        WebElement vnaam = driver.findElement(By.id("vnaam"));
        vnaam.clear();
        vnaam.sendKeys(this.validFirstName);

        // anaam
        WebElement anaam = driver.findElement(By.id("anaam"));
        anaam.clear();
        anaam.sendKeys(this.invalidLastName);

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige naam"));
    }

    @Test
    public void test_Update_Invalidleeftijd() {
        // leeftijd
        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys(String.valueOf(this.invalidAge));

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige leeftijd"));
    }

    @Test
    public void test_Update_Invalidstraat() {

        // straatnaam
        WebElement straatnaam = driver.findElement(By.id("straat"));
        straatnaam.clear();
        straatnaam.sendKeys(this.invalidStreetName);


        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige straat"));
    }

    @Test
    public void test_Update_InvalidStad() {
        // stad
        WebElement stad = driver.findElement(By.id("stad"));
        stad.clear();
        stad.sendKeys(this.invalidCity);

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige stad"));
    }

    @Test
    public void test_Update_InvalidHuisnummer() {
        // huisnummer
        WebElement huisnummer = driver.findElement(By.id("huisnummer"));
        huisnummer.clear();
        huisnummer.sendKeys(String.valueOf(this.invalidHouseNumber));

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige huisnummer"));
    }

    @Test
    public void test_Update_InvalidBusnummer() {
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
    public void test_Update_Met_Alle_Waardes_Invalid() {
        // vnaam
        WebElement vnaam = driver.findElement(By.id("vnaam"));
        vnaam.clear();
        vnaam.sendKeys(this.invalidFirstName);

        // anaam
        WebElement anaam = driver.findElement(By.id("anaam"));
        anaam.clear();
        anaam.sendKeys(this.invalidLastName);

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
        assertTrue(containsWebElementsWithText(lis, "Geen geldige leeftijd"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige straat"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige huisnummer"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige busnummer"));
        assertTrue(containsWebElementsWithText(lis, "Geen geldige stad"));
    }


    @Test
    public void test_Update_Met_Alle_Waardes_gewijzigd() {
        // vnaam
        WebElement vnaam = driver.findElement(By.id("vnaam"));
        vnaam.clear();
        vnaam.sendKeys("Tim");

        // anaam
        WebElement anaam = driver.findElement(By.id("anaam"));
        anaam.clear();
        anaam.sendKeys("Bogaerts");

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

    }



    private boolean containsWebElementsWithText(ArrayList<WebElement> lis, String s) {
        for (WebElement l : lis)
            if(l.getText().equals(s))
                return true;

        return false;
    }
}
