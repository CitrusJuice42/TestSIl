import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Main {
    public static void  main(String[] args){
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        try {
            driver.get("https://testsheepnz.github.io/BasicCalculator.html");
            Thread.sleep(2000);

              WebElement memo1 = driver.findElement(By.xpath("//input[@name='number1']"));
              WebElement memo2 = driver.findElement(By.xpath("//input[@name='number2']"));
              WebElement drop = driver.findElement(By.xpath("//select[@name='selectOperation']"));
              WebElement button = driver.findElement(By.xpath("//input[@type='button']"));
              WebElement answer = driver.findElement(By.xpath("//input[@name='numberAnswer']"));

            Actions actions = new Actions(driver);
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            Select select = new Select(drop);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            actions
                    .click(memo1)
                    .pause(500)
                    .sendKeys(memo1,"2")
                    .click(memo2)
                    .pause(500)
                    .sendKeys(memo2,"3")
                    .click(drop)
                    .build().perform();
             select.selectByVisibleText("Subtract");
            actions
                    .click(drop)
                    .pause(1000)
                    .click(button)
                    .pause(3000)
                    .click(answer)
                    .pause(2000)
                    .build().perform();

            String ans;
            ans = answer.getAttribute("value");


            Assert.assertEquals(ans,"-1");
            System.out.println("Result is correct");







        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();

        }


    }
}