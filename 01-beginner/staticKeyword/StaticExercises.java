public class StaticExercises
{
  
    private static int count = 0;
    private String instanceName;


    public StaticExercises(String name)
    {
        this.instanceName = name;
        count++;
    }

  
    public static int getCount()
    {
        return count;
    }

  
    public static double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }

  
    public String getInfo()
    {
        return "Instance: " + instanceName + ", Total instances: " + count;
    }

  
    public static StaticExercises createDefault()
    {
        return new StaticExercises("Default");
    }



  /// --------------- Main Method --------------- 
    public static void main(String[] args)
    {

        System.out.println("=== Static Counter ===");
        System.out.println("Count before creating instances: " + getCount());

        StaticExercises obj1 = new StaticExercises("First");
        StaticExercises obj2 = new StaticExercises("Second");
        StaticExercises obj3 = new StaticExercises("Third");


        System.out.println("Count after creating 3 instances: " + getCount());
        System.out.println("\n=== Static Utility Method ===");
        System.out.println("0°C   = " + celsiusToFahrenheit(0)   + "°F");
        System.out.println("100°C = " + celsiusToFahrenheit(100) + "°F");
        System.out.println("37°C  = " + celsiusToFahrenheit(37)  + "°F");


        System.out.println("\n=== Static vs Instance ===");
        System.out.println(obj1.getInfo());
        System.out.println(obj2.getInfo());


        System.out.println("StaticExercises.getCount(): " + StaticExercises.getCount());
        System.out.println("\n=== Static Factory Method ===");
        StaticExercises defaultObj = StaticExercises.createDefault();
        System.out.println(defaultObj.getInfo());
    }

  
}
