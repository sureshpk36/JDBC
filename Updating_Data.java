/*Write a Java program that updates an existing record in a table named "orders" using a prepared
statement*/
import java.sql.*;

public class UpdateOrder {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        try {
            // Establish a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to the database!");

                // SQL Update query using a PreparedStatement
                String query = "UPDATE orders SET status = ? WHERE order_id = ?";

                // Create a PreparedStatement object
                PreparedStatement pstmt = conn.prepareStatement(query);

                // Set the values for the placeholders (?)
                pstmt.setString(1, "Shipped"); // Replace with the new status
                pstmt.setInt(2, 101); // Replace with the order ID to update

                // Execute the update statement
                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Order status updated successfully!");
                }

                // Close the PreparedStatement
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Error while updating the order.");
            e.printStackTrace();
        }
    }
}
