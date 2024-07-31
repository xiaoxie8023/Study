


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * program: SeleniumAutoText
 * <p>
 * description: 第一个测试案例
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-11 21:31
 **/
public class FirstTest {
    //测试百度搜索关键词；迪丽热巴
    void test01() throws InterruptedException {
        //1. 打开浏览器 使用驱动来打开
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(3000);

        //2. 输入完整的网址：https://www.baidu.com
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);

        //3. 找到输入框，并输入关键词：迪丽热巴
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        Thread.sleep(3000);

        //4. 找到百度一下按钮，并点击
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);

        //5. 关闭浏览器
        driver.quit();
    }
}
