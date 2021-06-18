
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ValidHtmlTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // vul hier JOUW pad naar chromedriver in
        // Voor Windows (vergeet "\" niet te escapen met een tweede "\")
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\Users\\...\\chromedriver.exe");
        // Voor mac:
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emile\\Documents\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        // driver.quit();
    }
    //Alle html pagina's worden hier getest
    @Test // Voer deze test uit als je je project opgeladen hebt
    public void isValidHtml_home() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=home");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());

    }

    @Test
    public void isValidHtml_deletConfirmation() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=deleteConfirmation&email=e.h@gmail.com");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());

    }

    @Test
    public void isValidHtml_GevondenLid() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?email=e.h%40gmail.com&command=gevonden");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());

    }

    @Test
    public void isValidHtml_Leden() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=leden");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());

    }

    @Test
    public void isValidHtml_LidNietGevonden() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?email=&command=gevonden");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void isValidHtml_Log() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=logboek");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void isValidHtml_Update() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=update&vnaam=Emile&anaam=Hermans&email=e.h@gmail.com&leeftijd=19&straat=Blauwenhoek&huisnummer=106&bus=0&stad=Londerzeel");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void isValidHtml_WordLid() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=wordLid");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }

    @Test
    public void isValidHtml_Zoek() {
        driver.get("https://validator.w3.org/#validate_by_uri+with_options");
        WebElement invulveld = driver.findElement(By.id("uri"));
        // verander naamVanJeEigenSite naar de juiste naam
        invulveld.sendKeys("http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=zoek");

        Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
        dropdown.selectByValue("HTML5");

        WebElement button = driver.findElement(By.cssSelector(".submit_button"));
        button.click();

        WebElement pass = driver.findElement(By.cssSelector("p.success"));
        assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());
    }









}
