package Weekly_Assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//*Weekly Assignment: Employee Management System*
//
//Problem Statement:
//You are tasked with creating a simple Employee Management System. The system should be able to perform basic operations on a list of employees. Each employee has the following attributes:
//
//Employee ID (unique identifier)
//Name
//        Position
//Salary
//
//You need to implement the following functionalities:
//
//        1.Add Employee:
//        -Implement a method to add a new employee to the system.
//        2.Remove Employee:
//        -Implement a method to remove an employee from the system based on their Employee ID.
//3.Display Employee Information:
//        -Implement a method to display the information of a specific employee based on their Employee ID.
//
//        4.Display All Employees:
//        -Implement a method to display the information of all employees in the system.
//5.Calculate Total Salary:
//        -Implement a method to calculate and display the total salary of all employees.
//6.Sort Employees by Salary:
//        -Implement a sorting algorithm to sort the employees based on their salary in ascending order.
//
//        Constraints:
//The Employee ID should be unique.
//The system should handle at least 100 employees.
//Use an appropriate data structure for efficient retrieval and modification of employee information.
//
//7.Search Employees:
//        -Implement a method to search for employees based on their name, position, or salary range.
//8.Update Employee Information:
//        -Implement a method to update the information of an existing employee.
//9.Performance Improvement:
//        -Optimize the data structure and algorithms for better performance, especially for searching and updating operations.
//        10.Serialization:
//        -Implement serialization and deserialization to save and load employee data from a file.
//
//11.Use Interfaces and Inheritance:
//        -Create an interface for the Employee and different classes for different types of employees (e.g., FullTimeEmployee,
//        PartTimeEmployee) that implement the interface.
//        12.Exception Handling:
//        -Implement proper exception handling for scenarios like invalid inputs, duplicate Employee IDs, etc.
abstract class Employee_Information
{
    private int Emp_id;
    private String Emp_name;
    private String Emp_position;
    private double Emp_contact ;
    public Employee_Information(int Emp_id , String Emp_name, String Emp_position , double Emp_contact)
    {
        this.Emp_id = Emp_id;
        this.Emp_name = Emp_name;
        this.Emp_position = Emp_position;
        this.Emp_contact = Emp_contact;
    }
    // use getter to get the value
    public int getEmp_id()
    {
        return Emp_id;
    }
    public String getEmp_name()
    {

        return Emp_name;
    }
    public String getEmp_position()
    {

        return Emp_position;
    }
    public double getEmp_contact()
    {
        return Emp_contact;
    }

    // use setter to set or update the value


    public void setEmp_id(int emp_id)
    {
        this.Emp_id = emp_id;
    }
    public void setEmp_name(String emp_name)
    {
        this.Emp_name = emp_name;
    }
    public void setEmp_position(String emp_position)
    {
       this.Emp_position = emp_position;
    }
    public void setEmp_contact(double emp_contact)
    {
        this.Emp_contact = emp_contact;
    }
    public abstract double calcSalary();

    // to print the object we will override the function
    public String toString()
    {
        return ("Emp_id" + getEmp_id() + "Emp_name" + getEmp_name() + "Emp_position" + getEmp_position() + " Emp_contact" + getEmp_contact() );
    }
}
class fullTime extends Employee_Information
{
    private double Emp_sallary ;
    private int workingDays;
    public fullTime(int Emp_id , String Emp_name , String Emp_position ,int Emp_contact,double Emp_sallary , int workingDays)
    {
        super(Emp_id,Emp_name,Emp_position,Emp_contact);
        this.workingDays = workingDays;
        this.Emp_sallary = Emp_sallary;

    }

    public fullTime(int id, String name, int contact, double salary, String position, int workingDays) {
        super(id , name ,position,contact);
    }

    public double getEmp_sallary()
    {

        return Emp_sallary;
    }
    public int getWorkingDays()
    {

        return workingDays;
    }
    public void getEmp_sallary(double Emp_sallary)
    {

        this.Emp_sallary= Emp_sallary;
    }
    public void setWorkingDays(int workingDays)
    {

        this.workingDays=  workingDays;
    }
    public void setEmp_sallary(double Emp_sallary)
    {
        this.Emp_sallary= Emp_sallary;
    }

    @Override
    public double calcSalary() {
        return calcSalary();
    }
}
class partTime extends Employee_Information
{
  private double p_sallary;
  private double workingHours;
  public partTime(int Emp_id , String Emp_name , String Emp_position ,int Emp_contact , double p_sallary , double workingHours)
  {
     super(Emp_id,Emp_name,Emp_position,Emp_contact);
     this.p_sallary= p_sallary;
     this.workingHours = workingHours;
  }


    public double getp_sallary()
    {

        return p_sallary;
    }
    public double getworkingHours()
    {

        return workingHours;
    }
    public void setp_sallary(double p_sallary)
    {

        this.p_sallary= p_sallary;
    }
    public void setworkingHours(double workingHours)
    {
       this.workingHours=  workingHours;
    }
    public double calcSalary()
    {

      return p_sallary*workingHours;
    }
}
class ManageEmployee
{
    Scanner sc = new Scanner(System.in);
    // here we create private list of employee information
    private List<Employee_Information>employeeList;
    public ManageEmployee()
    {
        employeeList= new ArrayList<>();
    }
    // Add Employee
    public  void addEmployee(Employee_Information employee)
    {
        employeeList.add(employee);
        System.out.println("Employee Added");
    }
    // Remove Employee
    public void removeEmployee(int id)
    {
        Employee_Information employeeRemove = null;
        for(Employee_Information employee :employeeList)
        {
            if(employee.getEmp_id()==id)
            {
                employeeRemove = employee;
                break;
            }
        }
        employeeList.remove(employeeRemove);
        System.out.println("employee Removed ");
    }
    // display employee Information
    public  void displayEmpInfo(int id)
    {
        Employee_Information employeeDisplay = null;
        for(Employee_Information employee : employeeList)
        {
            if(employee.getEmp_id() == id)
            {
                employeeDisplay = employee;
                break;
            }
        }
        System.out.println("id =" + employeeDisplay);
    }
    // Display all employee information
    public void displayAllEmployees()
    {
        System.out.println("All employees ");
        for(Employee_Information employee : employeeList)
        {
            System.out.println(employee);
        }
    }
    // update information
    public void updateInformation(int id)
    {
        Employee_Information employeeUpdate  = null;
        fullTime full = null;
        partTime pt = null;
        for(Employee_Information employee : employeeList)
        {
            if(employee.getEmp_id()==id)
            {
                employeeUpdate = employee;
                full = (fullTime) employee;
                pt = (partTime)  employee;
                break;
            }
        }
        while(true)
        {
            System.out.println("Update");
            System.out.println("0. Exit");
            System.out.println("1. Name");
            System.out.println("2. Contact");
            System.out.println("3.Position");
            int n=sc.nextInt();
            if(n==0)
            {
                System.out.println("Updation Done");
                break;
            }
            switch (n)
            {
                case 1:
                {
                    System.out.println("Enter new Name");
                    sc.nextLine();
                    String name=sc.nextLine();
                    employeeUpdate.setEmp_name(name);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter new Contact");
                    int contact = sc.nextInt();
                    employeeUpdate.setEmp_contact(contact);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter new position ");
                    String position = sc.next();
                    employeeUpdate.setEmp_position(position);
                }

                default:
                    System.out.println("You have entered invalid Option");
            }
        }
    }
    // Update Sallary
    public void updateSallary(int id)
    {
        System.out.println("enter the type of employee ");
        System.out.println("1.full time");
        System.out.println("2.part time");
        int s1 = sc.nextInt();
        if(s1==1)
        {
            System.out.println("Enter new salary");
            double salary= sc.nextDouble();
            fullTime full=null;
            for(Employee_Information employee : employeeList)
            {
                if(employee.getEmp_id()==id)
                {
                    full=(fullTime) employee;
                    full.setEmp_sallary(salary);
                }
                else
                {
                    System.out.println("The employee is not present");
                }
            }
            System.out.println("Salary after updation");
        }
        else if(s1==2)
        {
            partTime pt = null;
            System.out.println("Enter new salary");
            double salary = sc.nextDouble();
            System.out.println("Enter the no. of hours work done");
            double workhours= sc.nextDouble();
            for(Employee_Information employee : employeeList)
            {
                if(employee.getEmp_id()==id)
                {
                    pt=(partTime)employee;
                    break;
                }
                else
                {  System.out.println("The employee is not present");
                }
            }
            if(pt!=null)
            {
                pt.setp_sallary(salary);
                pt.setworkingHours(workhours);
            }
            else if(pt==null)
            {
                System.out.println("This id employee is Full Time Employee");
            }
            System.out.println("Salary after updation");
        }
        else
        {
            System.out.println("You have Entered a wrong Input");
        }
    }

    //7. Calculate Total Annual Salary
    public double totalSalary(int id)
    {
        Employee_Information emptofindtotalsal=null;
        for(Employee_Information employee: employeeList)
        {
            if(employee.getEmp_id()==id)
            {
                emptofindtotalsal=employee;
            }
        }
        double yearly_sal=emptofindtotalsal.calcSalary();
        double total= yearly_sal*12;
        return total;
    }
}
public class Employee_Management_System
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        ManageEmployee manage =new ManageEmployee() ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");

        while(true)
        {
            int n= enter();
            if(n==0)
            {
                System.out.println("Exit");
                break;
            }
            switch(n)
            {
                case 1:
                {
                    Employee_Information employee=adde();
                    manage.addEmployee(employee);
//
                    break;
                }
                case 2:
                {
                    System.out.println("Enter id of employee whom you want to remove");
                    int id= sc.nextInt();
                    manage.removeEmployee(id);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter id of Emoloyee whome Information you want to display");
                    int id=sc.nextInt();
                    manage.displayEmpInfo(id);
//
                    break;
                }
                case 4:
                {
                    manage.displayAllEmployees();
//
                    break;
                }
                case 5:
                {
                    System.out.println("Enter id of employee whome information you want to change");
                    int id=sc.nextInt();
                    manage.updateInformation(id);
                    System.out.println("New Information is: ");
                    manage.displayEmpInfo(id);
                    break;
                }
                case 6:
                {
                    System.out.println("Enter the id whose salary you want to edit");
                    int id=sc.nextInt();
                    manage.updateSallary(id);
                    manage.displayEmpInfo(id);
                    break;
                }
                case 7:
                {
                    System.out.println("Enter the id of employee whose total Annual Salary you want to calculate");
                    int id=sc.nextInt();
                    System.out.println("Annually Salary of Employee is");
                    System.out.println(manage.totalSalary(id));
                }
                default:
                    System.out.println("You have Entered an Invalid Option");
                    break;
            }
        }

    }

    public static Employee_Information adde()
    {
        System.out.println("Choose one option");
        System.out.println("1. Add Full Time Employee");
        System.out.println("2. Add Part Time Employee");
        int n=sc.nextInt();
        Employee_Information employee = null;
        if(n==1)
        {
            System.out.println("Enter an id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name of Employee");
            String name=sc.nextLine();
            System.out.println("Enter the phone no.");
            int contact=sc.nextInt();
            System.out.println("Enter the  position of employee");
            String position = sc.next();
            System.out.println("Enter salary per month");
            double salary=sc.nextDouble();
            System.out.println("Enter working days");
            int workingDays = sc.nextInt();
            employee= new fullTime(id,name,contact,salary ,position, workingDays ) ;
        }
        else if(n==2)
        {
            System.out.println("Enter an id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name of Employee");
            String name=sc.nextLine();
            System.out.println("Enter the phone no.");
            String contact=sc.next();
            System.out.println("Enter salary per month");
            int salary=sc.nextInt();
            System.out.println("Enter the no. of hours when worked");
            int workhour=sc.nextInt();
            System.out.println("enteer the position");
            int pos = sc.nextInt();


            employee= new partTime(id,name,contact,salary,workhour,pos) ;
        }
        return employee;
    }
    public static int enter()
    {
        System.out.println("Select one option");
        System.out.println("0. Exit");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Display Employee Information");
        System.out.println("4. Display All Employees Info");
        System.out.println("5. Update Employee Info");
        System.out.println("6. Change Salary of Employee");
        System.out.println("7. Calculate Total Salary ");
        int n=sc.nextInt();
        return n;
    }
}


