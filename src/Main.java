import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "BrokenYouth_1711*");
            System.out.println("Conexion Efectiva");

            myStatement = myConnection.createStatement();
            myResultSet = myStatement.executeQuery("SELECT * FROM employees");

            while(myResultSet.next()) {
                System.out.println(myResultSet.getString("first_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conexion falló");

        }
    }
}