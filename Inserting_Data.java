/*Write a Java program that inserts a new record into a table named "products" using a prepared
statement*/

import java.sql.*;

public class InsertProduct {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        try {
            // Establish a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to the database!");

                // SQL Insert query using a PreparedStatement
                String query = "INSERT INTO products (product_name, price, quantity) VALUES (?, ?, ?)";

                // Create a PreparedStatement object
                PreparedStatement pstmt = conn.prepareStatement(query);

                // Set the values for the placeholders (?)
                pstmt.setString(1, "Laptop"); // Replace with the product name
                pstmt.setDouble(2, 55000.00); // Replace with the product price
                pstmt.setInt(3, 10); // Replace with the product quantity

                // Execute the insert statement
                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("A new product was inserted successfully!");
                }

                // Close the PreparedStatement
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Error while inserting data.");
            e.printStackTrace();
        }
    }
}
