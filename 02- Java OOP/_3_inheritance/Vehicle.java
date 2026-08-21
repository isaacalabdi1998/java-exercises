/**
 * Exercise: Inheritance - Vehicle Base Class
 *
 * Create a Vehicle base class representing any type of vehicle.
 * This will be extended by ElectricCar to demonstrate how
 * inheritance lets you build specialized types on top of
 * general ones.
 *
 * Key concepts:
 * - Defining reusable base class fields and behavior
 * - Methods designed to be overridden by subclasses
 */
public class Vehicle
{
    protected String make;   //  e.g., "Toyota"
    protected String model;  //  e.g., "Camry"
    protected int year;      //  e.g., 2024

  
    public Vehicle(String make, String model, int year)
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }

  
    public void start()
    {
        System.out.println(make +" "+model + " engine is starting... Vroom!");
    }

  
    public String getInfo()
    {
        return """
                %d %s %s
                """.formatted(year, make, model);
    }

  
    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

  
    // --------------- Main Method ---------------
    public static void main(String[] args)
    {
        Vehicle vehicle = new Vehicle("Toyota", "Camry", 2027);

        System.out.println(vehicle);
        vehicle.start();
        System.out.println(vehicle.getInfo());


        /*
          ---------- Output ----------
            Vehicle{make='Toyota', model='Camry', year=2027}
            Toyota Camry engine is starting... Vroom!
            2027 Toyota Camry
        
        */
      
    }

}
