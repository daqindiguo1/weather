import java.sql.*;

/**
 * Created by ql on 2017/7/19.
 */
public class Testinsertsql {
    public static void testinsert(String address,String temperature,String weather,String date){



                         //声明Connection对象
                         Connection con;
                         //驱动程序名
                         String driver = "com.mysql.jdbc.Driver";
                         //URL指向要访问的数据库名mydata
                         String url = "jdbc:mysql://192.168.1.101:3306/shixi?useUnicode=true&characterEncoding=UTF-8";
//                         String url = "jdbc:mysql://192.168.1.101:3306/shixi";
                        //MySQL配置时的用户名
                         String user = "root";
                         //MySQL配置时的密码
                         String password = "rootroot";
                         //遍历查询结果集
                         try {
                                 //加载驱动程序
                                Class.forName(driver);
                                 //1.getConnection()方法，连接MySQL数据库！！
                                 con = DriverManager.getConnection(url,user,password);
                                 if(!con.isClosed())
                                         System.out.println("Succeeded connecting to the Database!");
                                 //2.创建statement类对象，用来执行SQL语句！！
                                 Statement statement = con.createStatement();
                                 //要执行的SQL语句
//                                 String sql = "insert into demo(id,name,pos,salary) values(001,'水电费方','业务','1600') ";
                             //String sql = "insert into demo(id,name,pos,salary) values(?,?,?,?) ";
                             String sql = "insert into weather(address,temperature,weatherstatus,date) values(?,?,?,?) ";
                             PreparedStatement ps=null;
                             ps=con.prepareStatement(sql);
                             ps.setString(1,address);
                             ps.setString(2,temperature);
                             ps.setString(3,weather);
                             ps.setString(4,date);
                             ps.executeUpdate();
//                             ps.setInt(1,201);
//                             ps.setString(2,"你好");
//                             ps.setString(3,"hello");
//                             ps.setInt(4,10086);
//                             ps.executeUpdate();

                                 //3.ResultSet类，用来存放获取的结果集！！
//                                 statement.executeUpdate(sql);
                                 System.out.println("-----------------");
                                 System.out.println("执行结果如下所示:");
                                 System.out.println("-----------------");
//                                 System.out.println("姓名" + "\t" + "职称");
//                                 System.out.println("-----------------");

//                                 String job = null;
                                 String id = null;
                                 String web=null;
//                                 while(rs.next()){
//                                         //获取stuname这列数据
//                                         web = rs.getString("website");
//                                         //获取stuid这列数据
////                                         id = rs.getString("ename");
//
//                                         //输出结果
////                                        System.out.println(id + "\t" + job);
//                                     System.out.println(web);
//                                     }
                                 con.close();
                                 con.close();
                            } catch(ClassNotFoundException e) {
                                 //数据库驱动类异常处理
                                 System.out.println("Sorry,can`t find the Driver!");
                                e.printStackTrace();
                                } catch(SQLException e) {
                                 //数据库连接失败异常处理
                                 e.printStackTrace();
                                 }catch (Exception e) {
                                 // TODO: handle exception
                                 e.printStackTrace();
                            }finally{
                                System.out.println("数据库数据成功获取！！");
                             }
                     }
public static void main(String[] args){
//        testinsert("青岛","20");

}
         }


