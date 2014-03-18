package go.mail.ru.ResultPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by julia on 17.03.14.
 */
public class ResultPage {


    private WebDriver driver;
    public String[] resultData = {"", ""};

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getAnswer(String sum) {

        driver.findElement(By.id("ival")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("ival")).sendKeys(sum);
        resultData[0] = driver.findElement(By.id("oval")).getText();
        resultData[1] = driver.findElement(By.id("ival")).getCssValue("color");
        return resultData;
    }
}
