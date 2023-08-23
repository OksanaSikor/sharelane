import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/main.py;
    //2. Нажать на кнопку "Login";
    //3. Проверить сообщение.
    @Test
    public void verifyNotLoginPageTest() {
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage,"Oops, error. Email and/or password don't match our records", "Сообщение не отображается на странице");
    }


    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/main.py;
    //2. Заполнить поле "Email";
    //3. Заполнить поле "Password";
    //4. Нажать на кнопку "Login";
    //5. Проверить сообщение.
    @Test
    public void verifyNotCorrectLoginPageTest() {
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("oksanas@gmail.com");
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("111ov111");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage,"Oops, error. Email and/or password don't match our records", "Сообщение не отображается на странице");
    }
}
