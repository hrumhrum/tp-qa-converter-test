package go.mail.ru.HomePage;

import go.mail.ru.ResultPage.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by julia on 17.03.14.
 */
public class HomePage {


    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage search(String text) {

        driver.findElement(By.id("q")).sendKeys(text);
        driver.findElement(By.className("go-form__submit")).click();
        return new ResultPage(driver);
    }
}
