import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class A {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/my_database";
        String user = "root";
        String passward = "123456";
        Connection conn = DriverManager.getConnection(url, user, passward);
        String sql = "insert into my_table (name,gender) values ('小王','n')";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
        List<B> list = new ArrayList<>();
    }
}

class B {
    private int age;
}