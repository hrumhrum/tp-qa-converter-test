package go.mail.ru;

import go.mail.ru.HomePage.HomePage;
import go.mail.ru.ResultPage.ResultPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by julia on 17.03.14.
 */

public class ConverterTest {

    public FirefoxDriver driver;

    @DataProvider
    public String[][] testData() {
        return new String[][]
        {
                {"0", "0", "rgba(0, 0, 0, 1)", "rbkjuhfvv d aeyns"},
                {"avha", "0", "rgba(255, 0, 0, 1)", "кг в фунты"},
                {"100", "220,46226", "rgba(0, 0, 0, 1)", "кг в фунты"},
                {"0,000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001",
                       "0", "rgba(0, 0, 0, 1)", "кг в фунты"},
                {"100000000000000000000", "2,20462×1020", "rgba(0, 0, 0, 1)", "кг в фунты"},
                {" ", "0", "rgba(255, 0, 0, 1)", "кг в фунты" },
                {"", "0", "rgba(0, 0, 0, 1)", "ru d aeyns"}
        };
    }

    @BeforeMethod
    public  void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://go.mail.ru/");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test(dataProvider = "testData")
    public void testSearch(String first, String second, String third, String fourth) {
        HomePage homePage = new HomePage(driver);
        ResultPage result = homePage.search(fourth);
        assertTrue(result.getValue(first).equals(second));
        assertTrue(result.getColor(first).equals(third));

    }
}
