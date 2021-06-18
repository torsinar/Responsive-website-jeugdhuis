import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestZoek {
    // verander de url naar jouw url naam
    private static final String url = "http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=zoek";
    private WebDriver driver;

    @After
    public void clean() {
        driver.quit();
    }


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emile\\Documents\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(this.url);
    }

    // verander de url naar jouw url naam
    // Valid values
    private final String validEmail = "r0839357@student.ucll.be";


    // Invalid values
    private final String invalidEmail = "fake";


    @Test
    public void test_ZoekLid_Met_WithoutEmaill() {
        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();
        assertEquals("Jeugdhuis Heidestip - LidNietGevonden", driver.getTitle());
    }

    @Test
    public void test_ZoekLid_Met_InvalidEmail() {
        WebElement input = driver.findElement(By.id("email"));
        input.clear();
        input.sendKeys(invalidEmail);
        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        assertEquals("Jeugdhuis Heidestip - LidNietGevonden", driver.getTitle());
    }


    @Test
    public void test_ZoekLid_Met_ValidEmail() {
        WebElement input = driver.findElement(By.id("email"));
        input.clear();
        input.sendKeys(validEmail);
        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        assertEquals("Jeugdhuis Heidestip - Gevonden Lid", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.id("gegevens"));
        assertTrue(containsEmail(lis, "Voornaam: Emile, Naam: Hermans, E-mail: r0839357@student.ucll.be, Leeftijd: 19, Straat: Ergens, Huisnummer: 26, Busnummer: 0, Stad: Anders"));
    }

    private boolean containsEmail(ArrayList<WebElement> lis, String s) {
        for (WebElement l : lis)
            if(l.getText().equals(s))
                return true;

        return false;
    }

}


