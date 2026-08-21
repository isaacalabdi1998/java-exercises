/**
 * Exercise: Inheritance - ElectricCar Subclass
 *
 * Create an ElectricCar that extends Vehicle. Practice constructor
 * chaining with super(), overriding methods, and adding behavior
 * unique to electric vehicles.
 *
 * Key concepts:
 * - Extending a parent class and calling super()
 * - Overriding methods to change behavior
 * - Adding subclass-specific fields and methods
 */
public class ElectricCar extends Vehicle
{
  
    private int batteryLevel;

  
    public ElectricCar(String make, String model, int year, int batteryLevel)
    {
        super(make, model, year);
        this.batteryLevel = batteryLevel;
    }

  
    public void charge(int percent)
    {
        batteryLevel = Math.min(batteryLevel + percent, 100);
        System.out.println("Charging... Battery now at " + batteryLevel + "%");
    }

  
    public String getBatteryStatus()
    {
        return "Battery: " + batteryLevel + "%";
    }

  
    @Override
    public void start()
    {
        System.out.println(make + " " + model + " electric motor starting silently...");
    }

  
    @Override
    public String toString()
    {
        return "ElectricCar{make='" + make
                + "', model='" + model
                + "', year=" + year
                + ", batteryLevel=" + batteryLevel + "%}";
    }





  
    // --------------- Main Method ---------------
    public static void main(String[] args)
    {
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 85);


        System.out.println(tesla);
        tesla.start();

        System.out.println(tesla.getInfo());
        System.out.println(tesla.getBatteryStatus());

        // Polymorphism
        Vehicle vehicle = new  ElectricCar("Rivian","R1T",2025,60);
        vehicle.start();

    }

}



/*

    --------------- Output ---------------
    ElectricCar{make='Tesla', model='Model 3', year=2024, batteryLevel=85%}
    Tesla Model 3 electric motor starting silently...
    2024 Tesla Model 3
    Battery: 85%
    
    Rivian R1T electric motor starting silently...
*/
