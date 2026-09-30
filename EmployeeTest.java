package demo;
import java.util.Scanner;

public class EmployeeTest {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		Attendence attendence=new Attendence();
		Salary salary=new Salary();
		int choice;
		do {
			System.out.println("\n================================================");
			System.out.println(" EMPLOYEE ATTENDANCE & PAYROLL SYSTEM");
			System.out.println("\n================================================");
			System.out.println("1. Enter Employee Details");
			System.out.println("2. Calculate Attendance");
			System.out.println("3. Calculate Salary");
			System.out.println("4. Display Employee Details");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\n---- ENTER EMPLOYEE DETAILS ----");
				System.out.println("Enter Employee ID: ");
				employee.employeeId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name: ");
				employee.employeeName=sc.nextLine();
				System.out.println("\nSelect Department:");
				System.out.println("1. IT");
				System.out.println("2. HR");
				System.out.println("3. Finance");
				System.out.println("4. Marketing");
				System.out.println("Enter Department Choice: ");
				employee.departmentChoice=sc.nextInt();
				switch (employee.departmentChoice) {
				case 1:
					employee.department = "IT";
					break;
				case 2:
					employee.department = "HR";
					break;
				case 3:
					employee.department = "Finance";
					break;
				case 4:
					employee.department = "Marketing";
					break;
				default:
					employee.department = "Unknow";
					System.out.println("Invalid department choice.");
				}
				System.out.print("Enter Basic Salary: ");
				employee.basicSalary = sc.nextDouble();
				if (employee.basicSalary > 0) {
					System.out.println("Employee details entered successfully.");
				}
				else {
					System.out.println("Invalid salary. Salary must be greater than zero.");
				}
				break;
			case 2:
				System.out.println("\n--- ATTENDANCE CALCULATION ---");
				System.out.print("Enter Total Working Days: ");
				attendence.totalWorkingDays = sc.nextInt();
				if (attendence.totalWorkingDays > 0) {
					attendence.presentDays = 0;
					attendence.absentDays = 0;
					for(int day = 1; day <= attendence.totalWorkingDays; day++) {
						System.out.println("Day "+ day + " - Enter 1 for present, 0 for Absent: ");
						attendence.attendence = sc.nextInt();
						if(attendence.attendence == 1) {
							attendence.presentDays++;
						}
						else if (attendence.attendence == 0) {
							attendence.absentDays++;
						}
						else {
							System.out.println("Invalid input. Enter only 1 or 0.");
						}
					}
					attendence.attendancePercentage = ((double) attendence.presentDays / attendence.totalWorkingDays)* 100;
					System.out.println("\npresent Days : " + attendence.presentDays);
					System.out.println("Absent Days : " + attendence.absentDays);
					System.out.println("Attendence % : " + attendence.attendancePercentage + "%");
					if (attendence.attendancePercentage >= 75) {
						System.out.println("Attendence Status: Eligible");
					}
					else {
						System.out.println("Attendence Status: Not Eligible");
					}
				}
				else {
					System.out.println("Working days must be greater than zero.");
				}
				break;
			case 3:
				System.out.println("\n--- SALARY CALCULATION ---");
				if (employee.basicSalary > 0) {
					if(attendence.totalWorkingDays > 0) {
						if (attendence.attendancePercentage >= 90) {
							salary.incentive = employee.basicSalary * 0.10;
							salary.finalSalary = employee.basicSalary + salary.incentive;
							System.out.println("Attendance Category: Excellent");
							System.out.println("Attendance Incentive: 10%");
						}
						else if (attendence.attendancePercentage >= 75) {
							salary.incentive = 0;
							salary.deduction = 0;
							salary.finalSalary = employee.basicSalary;
							System.out.println("Attendence Category: Good");
							System.out.println("Attendence Incentive: 0%");
						}
						else {
							salary.deduction = employee.basicSalary * 0.10;
							salary.finalSalary = employee.basicSalary - salary.deduction;
							System.out.println("Attendance Category: Low");
							System.out.println("Attendance Incentive: 10%");
							
						}
						System.out.println("Basic Salary : RS." + employee.basicSalary);
						System.out.println("Final Salary : RS." + salary.finalSalary);
					}
					else {
						System.out.println("Please calculate attendance first.");
					}
					}
				else {
					System.out.println("Please enter valid employee details first.");
				}
				break;
			case 4:
				System.out.println("\n--- EMPLOYEE DETAILS ---");
				if (employee.employeeId != 0) {
					System.out.println("Employee ID : " + employee.employeeId);
					System.out.println("Employee Name : " + employee.employeeName);
					System.out.println("Department : " + employee.department);
					System.out.println("Basic Salary : RS. " + employee.basicSalary);
					System.out.println("Present Days : " + attendence.presentDays);
					System.out.println("Absent Days : " + attendence.absentDays);
					System.out.println("Attendance % : " + attendence.attendancePercentage + "%");
					System.out.println("Final Salary : RS." + salary.finalSalary);
				}
				else {
					System.out.println("No employee details avaliable");
				}
				break;
			case 5:
				System.out.println("\nThank you for using the system.");
				break;
				default:
					System.out.println("Invalid menu choice.Please enter 1 to 5.");
				
			}
		}
			while (choice != 5);
			sc.close();
	}
}
