import java.sql.*;
public class first {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/aryan";
        String username="root";
        String password="D@sh3306";
        String query1=   "Select * from employee;";
        String query2="insert into employee values(0,'rashi','bench',-87000),(4,'a','b',34),(7,'c','d',737),(99,'de','fg',234);";
        String query3="delete from employee where id  between 2 and 8 or id=99;";
        String query4="update  employee set job_title='BOSS'where id=0; ";
        // NO NEED TO LOAD THE DRIVER HOWEVER ITS IS A GOOD PRACTICE
//        try {//loading drivers
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("drivers loaded succesfully");
//        } catch(ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//            System.out.println("drivers was not loaded succesfully");
//        }

        try  {//making connections
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }

            Statement stmt=con.createStatement();

            //code to fetch data
//           ResultSet rs= stmt.executeQuery(query1);
//           while(rs.next())
//           {
//               int id=rs.getInt("id");
//               String name=rs.getString("name");
//               String job=rs.getString("job_title");
//               double salary=rs.getDouble("salary");
//               System.out.println(id+" "+name+" "+job+" "+salary);
//           }

            //code for insertion

//            int rowsAffected =stmt.executeUpdate(query2);
//            if(rowsAffected>0)
//            {
//                System.out.println("insert successful"+ rowsAffected+"rows afected");
//            }
//            else
//            {
//                System.out.println("insertion failed");
//            }

            //deletion code:similar to insertion

//            int rowsAffected =stmt.executeUpdate(query3);
//            if(rowsAffected>0)
//            {
//                System.out.println("deletion successful "+ rowsAffected+"rows afected");
//            }
//            else
//            {
//                System.out.println("deletion failed");
//            }

            //updation code;

            int rowsAffected =stmt.executeUpdate(query4);
            if(rowsAffected>0)
            {
                System.out.println("updation successful: "+ rowsAffected+" rows afected");
            }
            else
            {
                System.out.println("updation failed");
            }
           //rs.close();
           stmt.close();
           con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
