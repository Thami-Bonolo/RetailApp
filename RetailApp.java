import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 
class RetailApp {
 
    private static final String url = "jdbc:mysql://localhost/HQ";
 
    private static final String user = "root07";
 
    private static final String password = "root07";
    
 
    public static void main(String args[]) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");
            
            
            // the mysql insert statement
            String insert_query = " insert into Clothes (Style, Type, Dept)"
            + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt1 = con.prepareStatement(insert_query);
            preparedStmt1.setInt (1, 1001640);
            preparedStmt1.setString (2, "jeans");
            preparedStmt1.setString (3, "Boys");
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt2 = con.prepareStatement(insert_query);
            preparedStmt2.setInt (1, 1003793);
            preparedStmt2.setString (2, "T-shirt");
            preparedStmt2.setString (3, "Girls");
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt3 = con.prepareStatement(insert_query);
            preparedStmt3.setInt (1, 1004613);
            preparedStmt3.setString (2, "jersey");
            preparedStmt3.setString (3, "Ladies");

            // execute the preparedstatements
            preparedStmt1.execute();
            preparedStmt2.execute();
            preparedStmt3.execute();
            System.out.println("Records Inserted");

      
            String delete_query = "delete from Clothes where Style = ?";
            PreparedStatement delete = con.prepareStatement(delete_query);
            delete.setInt(1, 1004613);

            // execute the preparedstatement
            delete.execute();
            System.out.println("Record deleted");
            
            String query = "update Clothes set type = ? where Style = ?";
            PreparedStatement update = con.prepareStatement(query);
            update.setString (1, "jersey");
            update.setInt(2, 1003793);

            // execute the java preparedstatement
            update.executeUpdate();
            System.out.println("Record updated");

            
            
            
            // SQL SELECT query. 
            String select_query = "SELECT * FROM Clothes";

            // create the java statement
            Statement st = con.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(select_query);
      
            System.out.println("\n\nResulting ralation:");
            System.out.format("%s, %s, %s\n", "Style", "Type", "Dept");

            // iterate through the java resultset
            while (rs.next()){
                int style = rs.getInt("Style");
                String type = rs.getString("Type");
                String dept = rs.getString("Dept");
        
            // print the results
            System.out.format("%s, %s, %s\n", style, type, dept);
      }
      st.close();
      con.close();


            
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
