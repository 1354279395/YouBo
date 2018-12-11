package com.tulun;

import java.sql.*;
import java.util.*;

public class user {
    public static void main(String[] args)throws Exception {
            test1();
    }


    public static void test1()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java";
        Long startTime = System.currentTimeMillis();
       for (int i = 1;i <=1000;i++){
            Random ran=new Random();
            int a=ran.nextInt(25);
            int b=ran.nextInt(100);
            int downCase = ran.nextInt(26)+97;//得到97-122的随机数
            String down = String .valueOf((char)downCase);//得到a-z
           String sex1="";
           int s = ran.nextInt(2);
           if(s==0){
               sex1="女";
           }else{
               sex1="男";
           }
            Connection connection=DriverManager.getConnection(url,
                    "root", "");
            String sql="insert into user(name,age,sex,score) values(?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,down+down+down+down+down);
            pstm.setInt(2,a);
            pstm.setString(3,sex1);
            pstm.setInt(4,b);
            pstm.addBatch();
            pstm.executeBatch();

            pstm.close();
            connection.close();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("数据插入完毕");
        System.out.println("时间"+(endTime-startTime)+"ms");
    }
}
