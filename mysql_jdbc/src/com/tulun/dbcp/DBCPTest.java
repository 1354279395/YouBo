package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.junit.Test;

public class DBCPTest {


    //测试,使用连接池,每写一条数据前,从连接池中获取一个连接
    @Test
    public void testWriteDBByDBCP() throws Exception{
        Long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            writeDBByDBCP(i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("数据插入完毕");
        System.out.println("时间"+(endTime-startTime)+"ms");
    }


    //通过DBCP连接池写数据库
    public void writeDBByDBCP(int data){
        String sql="insert into user(name,age,sex,score) values(?,?,?,?)";
        try {
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

            Connection conn = dbcp.KCYDBCPUtil.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,down+down+down+down+down);
            pstm.setInt(2,a);
            pstm.setString(3,sex1);
            pstm.setInt(4,b);
            pstm.addBatch();
            pstm.executeBatch();

            pstm.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}