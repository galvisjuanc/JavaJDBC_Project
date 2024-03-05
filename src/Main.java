import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Connection myConnection = null;

        PreparedStatement preparedStatement = null;

        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "BrokenYouth_1711*");
            System.out.println("Conexion Efectiva");

            String sqlInsert = ("INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)");
            preparedStatement = myConnection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "Natalie");
            preparedStatement.setString(2, "Sierra");

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Se ha creado un nuevo usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conexion falló");

        }
    }
}