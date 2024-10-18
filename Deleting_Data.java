/*Write a Java program that deletes a record from a table named "employees" using a prepared statement*/
import java.sql.*;

public class DeleteEmployee {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        try {
            // Establish a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to the database!");

                // SQL Delete query using a PreparedStatement
                String query = "DELETE FROM employees WHERE employee_id = ?";

                // Create a PreparedStatement object
                PreparedStatement pstmt = conn.prepareStatement(query);

                // Set the value for the placeholder (?)
                pstmt.setInt(1, 123); // Replace with the employee ID to delete

                // Execute the delete statement
                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Employee record deleted successfully!");
                }

                // Close the PreparedStatement
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Error while deleting the employee record.");
            e.printStackTrace();
        }
    }
}
