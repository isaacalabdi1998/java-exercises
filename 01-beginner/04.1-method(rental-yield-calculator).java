package methods;

public class Methods
{
    ///  Rental Yield Calculator Exercise
    private static double calculatePropertyYield(double rent, double propertyPrice)
    {
        double yearlyRent = rent * 12;
        return (yearlyRent / propertyPrice) * 100;
    }



  
    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {

        double yield = calculatePropertyYield(1300, 250_000);
        System.out.println(yield);
    }
}

/*
      -------------------- Output --------------------
        6.239999999999999
*/
