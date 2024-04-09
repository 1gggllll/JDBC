import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * ClassName: jdbcTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/2 19:22
 * @Version 1.0
 */
public class jdbcTest {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/JAVA/idea/IntelliJ IDEA 2023.2/Javacode/JDBC/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        //定义sql
        String sql = "create table emptest2(" +
                "name varchar(10) not null comment '姓名'," +
                "gender varchar(10) comment '性别'," +
                "workid int primary key comment '工号'," +
                "address varchar(10) comment '家庭地址');";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        //关闭资源
        pstmt.close();
        conn.close();

    }
}
//D:\JAVA\idea\IntelliJ IDEA 2023.2\Javacode\JDBC\src\druid.properties