package methods;
public class MethodOverloading
{
    public int add(int a, int b)
    {
        return a + b;
    }

  
    public int add(int a, int b, int c)
    {
        return a + b + c;
    }


    public double add(double a, double b)
    {
        return a + b;
    }


    public String format(String value)
    {
        return "[" + value + "]";
    }


    public String format(int value)
    {
        return String.format("%05d", value);
    }


    public String format(String label, int value)
    {
        return label + ": " + value;
    }


  
    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {
        MethodOverloading obj = new MethodOverloading();
        System.out.println("add(2, 3): " + obj.add(2, 3));
        System.out.println("add(1, 2, 3): " + obj.add(1, 2, 3));
        System.out.println("add(1.5, 2.5): " + obj.add(1.5, 2.5));

        System.out.println("format(\"hello\"): " + obj.format("hello"));
        System.out.println("format(42): " + obj.format(42));
        System.out.println("format(\"Score\", 95): " + obj.format("Score", 95));
    }


}
/*
      -------------------- Output --------------------
            add(2, 3): 5
            add(1, 2, 3): 6
            add(1.5, 2.5): 4.0
            format("hello"): [hello]
            format(42): 00042
            format("Score", 95): Score: 95

*/
