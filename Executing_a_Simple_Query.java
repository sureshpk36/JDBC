import java.sql.*;

public class SelectCustomers {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your database name
        String username = "root"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        try {
            // Establish a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to the database!");

                // Prepare the SQL query
                String query = "SELECT * FROM customers";

                // Create a statement object
                Statement stmt = conn.createStatement();

                // Execute the query and get the result set
                ResultSet rs = stmt.executeQuery(query);

                // Process the result set
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");

                    System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
                }

                // Close the result set and statement
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Error executing query.");
            e.printStackTrace();
        }
    }
}
