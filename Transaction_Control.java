import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Transaction_Control {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("enter amount to be transferred");
            double value=sc.nextInt();
            System.out.println("enter employee 1 id ");
            int id1=sc.nextInt();
            System.out.println("enter employee 2 id");
            int id2=sc.nextInt();
            // JDBC URL, username, and password for MySQL
            String url = "jdbc:mysql://localhost:3306/aryan"; // Replace with your database name
            String user = "root"; // Replace with your MySQL username
            String password = "D@sh3306"; // Replace with your MySQL password
            String withdraw="update employee set salary= salary- ? where id= ?;";
            String deposit=" update employee set salary= salary+ ? where id= ? ;";
            // Establish the connection
            try (Connection con = DriverManager.getConnection(url, user, password))
            {
                    System.out.println("Connected to the database successfully!");
                    con.setAutoCommit(false);
                    try {
                        PreparedStatement withdrawStatement = con.prepareStatement(withdraw);
                        PreparedStatement depositStatement = con.prepareStatement((deposit));
                        withdrawStatement.setDouble(1, value);
                        withdrawStatement.setInt(2, id1);
                        depositStatement.setDouble(1, value);
                        depositStatement.setInt(2, id2);
                        withdrawStatement.executeUpdate();
                        depositStatement.executeUpdate();
                        con.commit();
                        System.out.println("Transaction successful");
                    } catch(SQLException e) {
                        con.rollback();
                        System.out.println("Transaction Failed");
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


