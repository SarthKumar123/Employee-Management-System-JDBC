import java.sql.*;
import java.util.Scanner;
public class Employeee {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url="jdbc:mysql://localhost:3306/employee";
				String u="root";
				String pwd="S@rth!2345";
				Connection con= DriverManager.getConnection(url,u,pwd);
				
				Scanner sc = new Scanner(System.in);
				
				while(true) {

				    System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
				    System.out.println("1. Add Employee");
				    System.out.println("2. View Employees");
				    System.out.println("3. Update Employee");
				    System.out.println("4. Delete Employee");
				    System.out.println("5. Exit");

				    System.out.println("Enter your choice:");

				    int choice = sc.nextInt();

				    switch(choice) {
				    
				    case 1:// Insert Employee Data
				    	String q = "Insert into emp values(?,?,?)";
						PreparedStatement ps = con.prepareStatement(q);
						
						System.out.println("Enter Employes Id");
						int id= sc.nextInt();
						
						System.out.println("Enter Employee Name:");
						String name = sc.next();

						System.out.println("Enter Employee Salary:");
						double salary = sc.nextDouble();
						
						ps.setInt(1,id);
						ps.setString(2,name);
						ps.setDouble(3,salary);
						
						int row= ps.executeUpdate();
						
						System.out.println(row +" row Updated ");
				        break;

				    case 2:// Show all the Employee details for the table
				    	String display = "SELECT * FROM emp";

						PreparedStatement ps2 = con.prepareStatement(display);

						ResultSet rs = ps2.executeQuery();

						while(rs.next()) {
						    System.out.println(rs.getInt("id"));
						    System.out.println(rs.getString("name"));
						    System.out.println(rs.getDouble("salary"));
						}
				        break;

				    case 3:// Update the rows inside the table.
				    	String update ="UPDATE emp SET salary=? WHERE id=?";
						PreparedStatement ps1 = con.prepareStatement(update);
						
						System.out.println("Enter Employee Id:");
						int updateid = sc.nextInt();

						System.out.println("Enter New Salary:");
						double updatesalary = sc.nextDouble();
						
						ps1.setDouble(1, updatesalary);
						ps1.setInt(2,updateid);
						
						int rowsUpdated = ps1.executeUpdate();
						System.out.println(rowsUpdated + " row updated");
				        break;

				    case 4: //Delete the information inside the table.
				    	String Delete = "Delete from emp where id=?";
						
						PreparedStatement ps3 = con.prepareStatement(Delete);
						
						System.out.println("Id to delete");
						int delete_id = sc.nextInt();
						
						ps3.setInt(1,delete_id);
						int rowsdeleted = ps3.executeUpdate();
						
						if(rowsdeleted > 0) {
						    System.out.println("Employee Deleted Successfully");
						}
						else {
						    System.out.println("Employee Not Found");
						}
						
						System.out.println(" Deleted!!!");
				        break;

				    case 5:
				        System.exit(0);

				    default:
				        System.out.println("Invalid Choice");

				    }
				}
								
			} 
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
}
