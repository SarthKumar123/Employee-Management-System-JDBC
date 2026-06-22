import java.sql.*;
import java.util.Scanner;
public class Employeee {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url="jdbc:mysql://localhost:3306/employee";
				String u="root";
				String pwd="your_password";
				Connection con= DriverManager.getConnection(url,u,pwd);
				
				Scanner sc = new Scanner(System.in);
				
				EmployeeDAO dao = new EmployeeDAO();
				
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
				    	System.out.println("Enter Employee Id:");
				    	int id = sc.nextInt();

				    	System.out.println("Enter Employee Name:");
				    	String name = sc.next();

				    	System.out.println("Enter Employee Salary:");
				    	double salary = sc.nextDouble();

				    	Employee emp = new Employee(id, name, salary);

				    	dao.addEmployee(emp);

				    	break;

				    case 2:// Show all the Employee details for the table
				    	dao.viewEmployees();
				    	break;
				    	

				    case 3:// Update the rows inside the table.
				    	System.out.println("Enter Employee Id:");
				        int updateId = sc.nextInt();

				        System.out.println("Enter New Salary:");
				        double updateSalary = sc.nextDouble();

				        dao.updateEmployee(updateId, updateSalary);

				        break;

				    case 4:

				        System.out.println("Enter Employee Id:");
				        int DeleteId = sc.nextInt();

				        dao.deleteEmployee(DeleteId);

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
