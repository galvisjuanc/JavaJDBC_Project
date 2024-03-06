import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Connection myConnection = null;

        PreparedStatement preparedStatement = null;

        Statement statement = null;

        ResultSet resultSet = null;

        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "BrokenYouth_1711*");
            System.out.println("Conexion Efectiva");

            statement = myConnection.createStatement();
            statement.executeUpdate("UPDATE employees " + "SET email= 'cossette.sierra@gmail.com'" + "WHERE first_name = 'Natalie'");
            resultSet = statement.executeQuery("SELECT * FROM employees ORDER BY pa_surname");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + ", " + resultSet.getString("email"));
            }

            // String sqlInsert = ("INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)");
            // preparedStatement = myConnection.prepareStatement(sqlInsert);
            // preparedStatement.setString(1, "Juan");
            // preparedStatement.setString(2, "Galvis");

            // int rowsAffected = preparedStatement.executeUpdate();

            // if (rowsAffected > 0) {
               // System.out.println("Se ha creado un nuevo usuario");
            // }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conexion falló");

        }
    }
}