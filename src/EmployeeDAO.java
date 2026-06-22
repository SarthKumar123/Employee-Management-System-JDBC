import java.sql.*;

public class EmployeeDAO {

    Connection con;

    public EmployeeDAO() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/employee";
            String u = "root";
            String pwd = "your_password";

            con = DriverManager.getConnection(url, u, pwd);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    public void addEmployee(Employee emp) {

        try {

            String q = "INSERT INTO emp VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());

            int row = ps.executeUpdate();

            System.out.println(row + " row inserted");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void viewEmployees() {

        try {

            String q = "SELECT * FROM emp";

            PreparedStatement ps = con.prepareStatement(q);

            ResultSet rs = ps.executeQuery();

            System.out.println("--------------------------------");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getDouble("salary")
                );
            }

            System.out.println("--------------------------------");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void updateEmployee(int id, double salary) {

        try {

            String q = "UPDATE emp SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " row updated");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        
        }
    
    public void deleteEmployee(int id) {

        try {

            String q = "DELETE FROM emp WHERE id=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Employee Deleted Successfully");
            }
            else {
                System.out.println("Employee Not Found");
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    }
