import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class Selenium {
    //Тест№1
   public static void test1() {
       //Устанавливаем путь к драйверу и инициализируем его
       System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {
            //Переход к необходимому ресурсу
            driver.get("https://testsheepnz.github.io/BasicCalculator.html");
            Thread.sleep(2000);

            //Ищем элементы по локаторам
            WebElement memo1 = driver.findElement(By.xpath("//input[@name='number1']"));
            WebElement memo2 = driver.findElement(By.xpath("//input[@name='number2']"));
            WebElement drop = driver.findElement(By.xpath("//select[@name='selectOperation']"));
            WebElement button = driver.findElement(By.xpath("//input[@type='button']"));
            WebElement answer = driver.findElement(By.xpath("//input[@name='numberAnswer']"));

            Actions actions = new Actions(driver);
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            Select select = new Select(drop);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//скрипт скроллинга

            actions
                    .click(memo1) //Нажатие на элемент
                    .pause(500)  //пауза между выполнениями действий
                    .sendKeys(memo1, "2") //ввод значений в поле ввода
                    .click(memo2)
                    .pause(500)
                    .sendKeys(memo2, "3")
                    .click(drop)
                    .build().perform();
            select.selectByVisibleText("Subtract"); //выбор необходимого значения
            actions
                    .click(drop)
                    .pause(1000)
                    .click(button)
                    .pause(3000)
                    .click(answer)
                    .pause(2000)
                    .build().perform();

            String ans;
            ans = answer.getAttribute("value");  //задаем переменную, в которую помещаем значение текстового поля


            Assert.assertEquals(ans, "-1"); //проверяем соответствует ли фактическое значение правильному
            System.out.println("Result is correct");




        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Тест№2
    public static void test2(){
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


            Thread.sleep(5000);
            memo1.clear();
            memo2.clear();
            actions
                    .click(memo1)
                    .pause(500)
                    .sendKeys(memo1, "gs")
                    .click(memo2)
                    .pause(500)
                    .sendKeys(memo2, "bu")
                    .click(drop)
                    .build().perform();
            select.selectByVisibleText("Concatenate");
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


            Assert.assertEquals(ans, "gsbu");
            System.out.println("Result is correct");
            Thread.sleep(2000);




        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    //Тест №3
    public static void test3(){
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


         try {
             driver.get("https://testsheepnz.github.io/random-number.html");
             Thread.sleep(2000);
             JavascriptExecutor js = ((JavascriptExecutor) driver);
             Actions actions = new Actions(driver);


             WebElement drop = driver.findElement(By.xpath("//select[@name='buildNumber']"));
             WebElement button = driver.findElement(By.xpath("//input[@type='button']"));

             js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
             Select select = new Select(drop);
             drop.click();
             select.selectByVisibleText("Demo");
             button.click();
             Thread.sleep(2000);
             js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

             driver.findElement(By.xpath("//input[@name='numberGuess']")).click();
             driver.findElement(By.xpath("//input[@name='numberGuess']")).sendKeys("string");
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@value='Submit']")).click();
             Thread.sleep(4000);

             String ans;
             ans = driver.findElement(By.xpath("//label[@class='description']/font/b/i")).getText();

             Assert.assertEquals(ans, "string: Not a number!");
             System.out.println("Result is correct");
             Thread.sleep(2000);




         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             driver.quit();
         }




    }
}
