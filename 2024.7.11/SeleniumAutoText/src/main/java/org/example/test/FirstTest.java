package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * program: SeleniumAutoText
 * <p>
 * description: 自动化函数的复习
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-26 07:43
 **/
public class FirstTest {
    WebDriver driver = null;
    //把创建浏览器的驱动封装成一个函数
    void createDriver() {
       //1.使用驱动打开浏览器
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
    }
    void test01() {
        createDriver();
        //选择器
        driver.findElement(new By.ByCssSelector("#kw")).sendKeys("java自动化测试");
        driver.findElement(new By.ByCssSelector("#su")).click();
        
    }
}
