import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

/// --------------- (Parent)Employee Class----------
public abstract class Employee
{
  
    protected String name;
    protected double baseSalary;

  
    public Employee(String name, double baseSalary)
    {
        this.name = name;
        this.baseSalary = baseSalary;
    }

  
    // Each subclass must implement this method
    public abstract double calculatePay();

  
    // Concrete method shared by all employees
    public String getDetails()
    {
        return name + " - Pay: $" + String.format("%.2f", calculatePay());
    }


}




/// --------------- Full Time Employee Class---------------
class FullTimeEmployee  extends Employee
{
    public FullTimeEmployee(String name, double baseSalary)
    {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay()
    {
        return baseSalary;
    }

}




/// --------------- Contract Employee Class---------------
class ContractEmployee  extends Employee
{
    private double hourlyRate;
    private int hoursWorked;

  
    public ContractEmployee(String name, double hourlyRate, int hoursWorked)
    {
        super(name, 0.0);
        this.hourlyRate = hoursWorked;
        this.hoursWorked = hoursWorked;
    }

  
    @Override
    public double calculatePay()
    {
        return hourlyRate * hoursWorked;
    }

}






/// --------------- Main Class ---------------
class EmployeeDemo
{

  
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee("Ahmed", 5000));
        employees.add(new FullTimeEmployee("Sara", 6000));
        employees.add(new ContractEmployee("Omar", 40, 160));

        // Polymorphism
        for (Employee obj : employees)
        {
            System.out.println(obj.getDetails());
        }

        // Find highest paid employee
        Employee highestPaid = getHighestPaid(employees);
      
        System.out.println("\nHighest paid:");
        System.out.println(highestPaid.getDetails());
    
    }

  
    public static Employee getHighestPaid(List<Employee> employeess)
    {
        if (employeess == null || employeess.isEmpty())
        {
            return null;
        }
        Employee highestPaid = employeess.get(0);


        for (Employee obj : employeess)
        {
            if (obj.calculatePay() > highestPaid.calculatePay())
            {
                highestPaid = obj;
            }
        }

        return highestPaid;
    }
}
