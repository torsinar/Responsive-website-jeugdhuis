import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDelete {
    // verander de url naar jouw url naam
    private static final String url = "http://cyclone3.uclllabs.be:8081/hermans-emile_war/LedenServlet?command=deleteConfirmation&email=r0839357@student.ucll.be";
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

    @Test
    public void test_DeleteConfirmation_Cancel() {
        WebElement addButton = driver.findElement(By.id("Cancel"));
        addButton.click();
        assertEquals("Jeugdhuis Heidestip - Leden", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsLid(lis, "r0839357@student.ucll.be"));
    }


    @Test
    public void test_DeleteConfirmation_Confirm() {
        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();
        assertEquals("Jeugdhuis Heidestip - Leden", driver.getTitle());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertFalse(containsLid(lis, "r0839357@student.ucll.be"));
    }



    private boolean containsLid(ArrayList<WebElement> lis, String s) {
        for (WebElement l : lis)
            if(l.getText().equals(s))
                return true;

        return false;
    }

}
