import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import redis.clients.jedis.Jedis;
/**
 * Created by zhanglele on 2017/7/20.
 */
public class Weatherss {
   static Map<String,String> result=new HashMap<String, String>();
    static List<String> temperature_list = new ArrayList<String>();
    static List<String> weatherstatus_list = new ArrayList<String>();
    static List<String> date_list = new ArrayList<String>();
   //static String[] address={"青岛","北京","上海"};
    static String[] address={"青岛","北京","上海","广州","深圳","西安","济南","杭州","郑州","石家庄","昆明","武汉","南京","大连","沈阳","天津","兰州","哈尔滨","成都","重庆","海口","南宁","乌鲁木齐","拉萨","太原","沈阳","南昌","合肥","西宁","银川","呼和浩特","福州","长春","贵阳"};
   //static JSONObject data = new JSONObject();
    static JSONObject data1 =new JSONObject();
    static JSONArray jsonArray = new JSONArray();
    static String strresult ="";
//    static JSONObject qingdaodata = new JSONObject();
//    static JSONObject beijingdata = new JSONObject();
//    static JSONObject shanghaidata = new JSONObject();


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
    private static Weatherss crawler()  throws Exception{
        Weatherss weatherss=new Weatherss();
        //        启动火狐浏览器
//        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//        WebDriver driver = new FirefoxDriver();
//        启动Chrome浏览器

//        List<String,String> fghj=new ArrayList<String,String>();
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "D:/development/chromedriver.exe");
        driver = new ChromeDriver();

//            driver.get("http://http://www.weather.com.cn/");


//            driver.findElement(By.id("kw")).sendKeys("15685411297");
//            driver.findElement(By.id("su")).click();
//            Actions action = new Actions(driver);


//        获取登录页面
        driver.get("http://www.weather.com.cn/");
//       获取用户名输入框
        FileWriter fileWritter = new FileWriter("E:/1/00.txt");
        StringBuffer s = new StringBuffer();
        for (int i=0;i<address.length;i++) {
            driver.findElement(By.id("txtZip")).clear();
            driver.findElement(By.id("txtZip")).sendKeys(weatherss.address[i]);
//        result[0] ="青岛";
//        休息500ms，否则，速度太快，会将密码内容填充到用户名输入框中
//        sleep(500);
//        获取密码输入框
//        driver.findElement(By.id("userPwd")).clear();
            driver.findElement(By.id("btnZip")).click();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Thread.sleep(3000);
            WebElement web = driver.findElement(By.xpath("//*[@id=\"today\"]/div[2]/ul/li[1]/p[2]/span"));
            WebElement web1 = driver.findElement(By.xpath("//*[@id=\"today\"]/div[2]/ul/li[1]/p[1]"));
            WebElement web2 = driver.findElement(By.xpath("//*[@id=\"today\"]/div[2]/ul/li[1]/h1"));
            Thread.sleep(2000);
            weatherss.temperature_list.add(web.getText());
            weatherss.weatherstatus_list.add(web1.getText());
            weatherss.date_list.add(web2.getText());
            s.append("{"+"\"城市\"" + ":" + "\"" +address[i] + "\""+",");
            s.append("\"天气情况\"" + ":" + "\"" +web1.getText() + "\""+",");
            s.append("\"日期\"" + ":" + "\"" +web2.getText() + "\""+",");
            s.append("\"温度\"" + ":" + "\"" + web.getText() + "\""+"},");
            System.out.println(weatherss.address[i]+":"+web.getText()+":"+web1.getText()+":"+web2.getText());
//        File file = new File("E:/1/00.txt");
            JSONObject data = new JSONObject();

            data.put("天气情况",web1.getText());
            data.put("温度",web.getText());
            data.put("日期",web2.getText());
            data.put("城市",address[i]);
            jsonArray.add(data);
//        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
//        bufferWritter.write(s);
//        bufferWritter.close();
//            fileWritter.write(s.toString());
//            fileWritter.close();
            System.out.println("当前URL 1 ：" + driver.getCurrentUrl());
//            System.out.println(web.getText());
            weatherss.result.put(weatherss.address[i],weatherss.temperature_list.get(i));
        }
        data1.put("data",jsonArray);
         strresult = data1.toString();

        System.out.println(strresult);
        fileWritter.write(s.toString());
            fileWritter.close();
        // 获取所有页面的句柄，并循环判断不是当前的句柄
//        driver.switch_to.window driver.window_handles.last
//        driver.switchTo().window(handle);
//        for (String handles : driver.getWindowHandles()) {
//            if (handles.equals(handle))
//                continue;
//            driver.switchTo().window(handles);
//        }
//        休息8秒等待用户输入验证码
//        sleep(8000);
//        当前URL 0 ：https://authsu18.alipay.com/login/certCheck.htm?goto=https%3A%2F%2Fwww.alipay.com%2F
//        System.out.println("当前URL 0 ：" + driver.getCurrentUrl());
//        driver.get("https://uac.10010.com/portal/homeLogin");
//        点击个人用户登录
//        driver.findElement(By.id("login1")).click();
//        当前URL 1 ：https://www.alipay.com/
//        System.out.println("当前URL 1 ：" + driver.getCurrentUrl());
//        System.out.println(web.getText());
        if(driver != null){

            driver.close();
        }
//        return result;
        return weatherss;

//        sleep(2000);*/
    }

    public static void main(String[] args) throws Exception{
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Weatherss weatherss1=new Weatherss();
        weatherss1 = crawler();
        jedis.set("data",weatherss1.strresult);
//              crawler();
//           Test.conmysql();
//           Testinsertsql.testinsert(result..,result[1]);
//          login();
//        for (Map.Entry<String, String> entry : result.entrySet()) {
//            Testinsertsql.testinsert(entry.getKey(),entry.getValue());
//        }
//        int length=
//                weatherss1.weatherstatus_list.
        //插入mysql数据库
        for(int i=0;i<weatherss1.temperature_list.size();i++){
            Testinsertsql.testinsert(weatherss1.address[i],weatherss1.temperature_list.get(i),weatherss1.weatherstatus_list.get(i),weatherss1.date_list.get(i));
        }

    }
}
