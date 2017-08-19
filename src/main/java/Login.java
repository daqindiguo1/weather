import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



/**
 * Created by zhanglele on 2017/7/19.
 */
public class Login {

   /* private static ChromeDriver driver;

    //    定义自己的休眠方法，精简代码量
    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }*/

        //    登录操作，负责将界面跳转到交易记录界面
        private static void login() {
            //        启动火狐浏览器
//        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//        WebDriver driver = new FirefoxDriver();
//        启动Chrome浏览器
            WebDriver driver = null;
            System.setProperty("webdriver.chrome.driver", "D:/development/chromedriver.exe");
            driver = new ChromeDriver();
//            driver.get("http://www.baidu.com");


//            driver.findElement(By.id("kw")).sendKeys("15685411297");
//            driver.findElement(By.id("su")).click();
//            Actions action = new Actions(driver);



//        获取登录页面
            driver.get("https://uac.10010.com/portal/homeLogin");
//       获取用户名输入框
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("15685411297");
//        休息500ms，否则，速度太快，会将密码内容填充到用户名输入框中
//        sleep(500);
//        获取密码输入框
        driver.findElement(By.id("userPwd")).clear();
        driver.findElement(By.id("userPwd")).sendKeys("135689");
//        休息8秒等待用户输入验证码
//        sleep(8000);
//        当前URL 0 ：https://authsu18.alipay.com/login/certCheck.htm?goto=https%3A%2F%2Fwww.alipay.com%2F
        System.out.println("当前URL 0 ：" + driver.getCurrentUrl());
//        driver.get("https://uac.10010.com/portal/homeLogin");
//        点击个人用户登录
        driver.findElement(By.id("login1")).click();
//        当前URL 1 ：https://www.alipay.com/
        System.out.println("当前URL 1 ：" + driver.getCurrentUrl());
//        sleep(2000);*/
        }
    public static void main(String[] args) {
        login();
//        WebDriver driver = null;
//        System.setProperty("webdriver.chrome.driver", "D:/development/chromedriver.exe");
//        driver = new ChromeDriver();
//
////        获取登录页面
//        driver.get("https://uac.10010.com/portal/homeLogin");

    }


    }

