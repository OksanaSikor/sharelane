import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest {

    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py;
    //2. Нажать на кнопку "Продолжить";
    //3. Проверить сообщение.
    @Test
    public void verifyNotRegistrationPageTest() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage,"Oops, error on page. ZIP code should have 5 digits", "Сообщение неккоректное");
    }


    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py;
    //2. Ввести ZipCode;
    //3. Нажать на кнопку "Продолжить";
    //4. Нажать на кнопку "Регистрация";
    //5. Проверить сообщение.
    @Test
    public void verifyRegistrationPageTest() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage,"Oops, error on page. Some of your fields have invalid data or email was previously used", "Сообщение неккоректное");
    }


    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py;
    //2. Ввести ZipCode;
    //3. Нажать на кнопку "Продолжить";
    //4. Заполнить поле "First Name";
    //5. Заполнить поле "Email";
    //6. Заполнить поле "Password";
    //7. Заполнить поле "Confirm Password";
    //8. Нажать на кнопку "Регистрация";
    //9. Проверить сообщение.
    @Test
    public void verifySuccessfulRegistrationPageTest() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Oksana");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("oksanas@gmail.com");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("111ov111");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("111ov111");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String message = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
        Assert.assertEquals(message,"Account is created!", "Сообщение неккоректное");
    }
}
