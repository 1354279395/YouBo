package com.tulun;


import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) throws Exception {
        tset1();
        //test2();
       //test3("zhanghuan","123");
    }
        // 基本的JDBC更新操作
        public static void test2 () throws Exception {
            // 1. 加载MySQL JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 创建连接字符串
            String url = "jdbc:mysql://localhost:3306/java";
            // 3. 获取一条和MySQL Server的连接
            Connection connection = DriverManager.getConnection(url,
                    "root", "");
            // 4. 创建一个SQL查询语句，查询数据库user表中所有的数据
            Statement st = connection.createStatement();
            int count = st.executeUpdate("delete from user where age=18");
            System.out.println("cout:" + count);
            // 6. 把资源进行关闭操作
            st.close();
            connection.close();
        }
        public static void tset1() throws Exception{
        //1.加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.常见连接字符串
            String url="jdbc:mysql://localhost:3306/java";
            //3.获取一条和MySQL Server的连接
            Connection connection=DriverManager.getConnection(url,"root","");
            //4.创建一个Sql的查询语句，查询数据库user表所有的数据
            Statement st=connection.createStatement();
            String sql="select * from user ";
            ResultSet rs=st.executeQuery(sql);
            //5.打印rs结果集的内容
            while (rs.next()){
                StringBuilder sb=new StringBuilder();
                sb.append(rs.getString("id")+" ");
                sb.append(rs.getString("name")+" ");
                sb.append(rs.getString("age")+" ");
                sb.append(rs.getString("score"));
                System.out.println(sb);
            }
            //6.把资源进行关闭操作
            rs.close();
            st.close();
            connection.close();
        }
        public static void test3(String name,String pwd) throws Exception{
        //1.加载MySQL jdbc驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.创建连接字符串；
            String url ="jdbc:mysql://localhost:3306/java";
            //获取一条和MySQL Server 的连接
            Connection connection=DriverManager.getConnection(url,"root","");
            //4.创建一个Sql查询语句，查询数据库user中的所有数据
            PreparedStatement st=connection.prepareStatement("select * from login where name=? and pwd=?");
            st.setString(1,name);
            st.setString(2,pwd);
            ResultSet rs=st.executeQuery();
            //5.迭代打印rs结果集的内容
            if(rs.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
            //6.把资源进行关闭操作
            rs.close();
            st.close();
            connection.close();
        }

}
