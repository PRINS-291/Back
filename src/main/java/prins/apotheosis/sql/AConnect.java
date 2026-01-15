package prins.apotheosis.sql;

import java.sql.*;

public class AConnect {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/sc";
            String user = "root";
            String password = "plmm1206";
            Connection connection = DriverManager.getConnection(url,user,password);

            //创建一个Statement语句对象
            Statement stat = connection.createStatement();

            //执行SQL语句
            String sql = "select * from sc";

            //把查询的结果（表记录）存放到ResultSet对象中，结果集
            ResultSet resultSet = stat.executeQuery(sql);
            System.out.println(resultSet);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
