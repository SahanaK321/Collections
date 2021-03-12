package com.sah.empcoll.main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

	import com.sah.empcoll.db.EmployeeDB;
	import com.sah.empcoll.dto.Employee;
	import com.sah.empcoll.service.EmployeeServiceImpl;
	import com.sah.empcoll.service.IEmployeeService;


	public class EmployeeMain {
		
		IEmployeeService empService = new EmployeeServiceImpl();
		
		public static 
		List<Employee> list = new ArrayList<Employee>();
		
		public static void main(String[] args) {
			
			EmployeeMain app = new EmployeeMain();
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				System.out.println(" === MENU ==== ");
				System.out.println(" 1   Add employee ");
				System.out.println(" 2  Display All Employees ");
				System.out.println(" 3  Display Employees based on salary ");
				System.out.println(" 4  Display Employees based on salary Range ");
				System.out.println(" 5  Display Employees based on Experience ");
				System.out.println(" 6  Edit Salary by Employee ID ");
				System.out.println(" 7  Edit Experience by Employee ID ");
				System.out.println(" 0  EXIT");
				System.out.println("Enter Option");
				int option = Integer.parseInt(sc.nextLine());
				
				switch(option)
				{
				
				case 1:
					
					System.out.println("Enter Employee Id ");
					int empId = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter Employee Salary ");
					int empSalary = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter Employee Exp ");
					int empExp = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter Employee Name ");
					String name = sc.nextLine();
					
					Employee e = new Employee(empId, name, empExp, empSalary);
					
					try
					{
						boolean isInserted = app.empService.addEmployee(e);
						if(isInserted)
						{
							System.out.println(" Employee Added");
						}
						else
						{
							 throw new Exception("Cannot added Employee");
						}
					}
					catch(Exception ex)
					{
						System.out.println(" Contact to Customer Care "+ex); // raise the exception
					}
					
					break;
					
				case 2:
					
					ArrayList<Employee> arr = app.empService.getAllEmployees();
					
					for (Employee employee : arr) {
						System.out.println(employee);
						System.out.println(" ==========================================");
					}
					break;
					
				case 3:
					System.out.println("Enter Employee's Salary ");
					int empsal = Integer.parseInt(sc.nextLine());
					ArrayList<Employee> salary=app.empService.getEmployeeBySalary(empsal);
					
						for (Employee employee : salary) {
						
						System.out.println(employee);
						System.out.println(" ==========================================");
					
					}
					break;
				case 4:
					System.out.println("Enter Employee Salary min and max salary");
					int empminsal = Integer.parseInt(sc.nextLine());
					int empmaxsal = Integer.parseInt(sc.nextLine());
					ArrayList<Employee> sal01=app.empService.getEmployeesBySalaryRange(empminsal, empmaxsal);
					
					for (Employee employee : sal01) {
						
						System.out.println(employee);
						System.out.println(" ==========================================");
				
					}
					break;
					
				case 5:
					System.out.println("Enter Employee's experience");
					int empexp = Integer.parseInt(sc.nextLine());		
					ArrayList<Employee> exp=app.empService.getEmployeeByExperience(empexp);
		
					
					for (Employee employee : exp) {
						
						System.out.println(employee);
						System.out.println(" ==========================================");
					
					}
					break;
				case 6:
					System.out.println("Enter Employee Id to change salary of the employee");
					int empidsal = Integer.parseInt(sc.nextLine());
					System.out.println("enter new salary");
					int empnewsal = Integer.parseInt(sc.nextLine());
					try
					{
						boolean isChanged = app.empService.editSalaryByEmployeeId(empidsal,empnewsal);
						if(isChanged)
						{
							System.out.println(" Employee Details Updated");
						}
						else
						{
							 throw new Exception("Cannot Find Employee ID");
						}
					}
					catch(Exception ex)
					{
						System.out.println(" Contact to Customer Care  "+ex); // raise the exception
					}
					break;
					
				case 7:
					
					System.out.println("Enter Employee Id to change experience of the employee");
					int empidexp = Integer.parseInt(sc.nextLine());
					System.out.println("enter new experience");
					int empnewexp = Integer.parseInt(sc.nextLine());
					try
					{
						boolean isAltered = app.empService.editSalaryByEmployeeId(empidexp,empnewexp);
						if(isAltered)
						{
							System.out.println(" Employee Details Updated");
						}
						else
						{
							 throw new Exception("Cannot Find Employee ID");
						}
					}
					catch(Exception ex)
					{
						System.out.println(" Contact to Customer Care "+ex); // raise the exception
					}
				case 0:
					System.exit(0);
				break;
					
				}//end switch
				
			}// end while
			
		}//end main

	}
