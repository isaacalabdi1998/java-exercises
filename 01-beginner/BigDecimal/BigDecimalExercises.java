package bigDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class BigDecimalExercises
{


    /**
     *  -Creates a BigDecimal from a String representation.
     *  -IMPORTANT: Always use the String constructor, not the double constructor!
     *   @param value the decimal value as a string (e.g., "19.99")
     *   @return a BigDecimal representing the value
     *  -Create and return a BigDecimal using new BigDecimal(value).
     *  -The String constructor preserves the exact decimal value.
     *  -NEVER use new BigDecimal(0.1) — see TODO 6 for why.
     */
    public static BigDecimal createFromString(String value)
    {
        return new BigDecimal(value);
    }


  
    /**
     * -Adds two BigDecimal values.
     *   @param a first value
     *   @param b second value
     *   @return the sum
     *  -Use the add() method to add a and b. Return the result.
     *  -Remember: BigDecimal is immutable, so add() returns a NEW BigDecimal.
     */
    public static BigDecimal addValues(BigDecimal a, BigDecimal b)
    {
        return a.add(b);
    }


  
    /**
     *  -Multiplies two BigDecimal values.
     *   @param a first value
     *   @param b second value
     *   @return the product
     *  -Use the multiply() method to multiply a and b. Return the result.
     */
    public static BigDecimal multiplyValues(BigDecimal a, BigDecimal b)
    {
        return a.multiply(b);
    }


  
    /**
     *  -Divides a by b with the specified scale (decimal places) and HALF_UP rounding.
     *  @param a     the dividend
     *  @param b     the divisor
     *  @param scale the number of decimal places
     *  @return the quotient rounded to the specified scale
     *  -Use a.divide(b, scale, RoundingMode.HALF_UP) to divide.
     *  -You MUST specify a rounding mode for division, otherwise you may get an ArithmeticException for non-terminating decimals (like 1/3).
     *
     */
    public static BigDecimal divideValues(BigDecimal a, BigDecimal b, int scale)
    {
        return a.divide(b, scale, RoundingMode.HALF_UP);
    }


  
    /**
     *  -Compares two BigDecimal values.
     *  -IMPORTANT: Use compareTo(), not equals()!
     *  -BigDecimal.equals() considers scale, so new BigDecimal("2.0").equals(new BigDecimal("2.00"))
     *  -returns false! compareTo() compares numeric value only.
     *
     *   @param a first value
     *   @param b second value
     *   @return -1 if a < b, 0 if equal, 1 if a > b
     */
    public static int compareValues(BigDecimal a, BigDecimal b)
    {
        return a.compareTo(b);
    }


  
    /**
     *  -Convert Double Value To BigDecimal
     *  @param value the double value(0.79)
     */
    public static BigDecimal convertToBigDecimal(double value)
    {
        return BigDecimal.valueOf(value);
    }


  
    /**
     *  -Demonstrates why new BigDecimal(double) is problematic.
     *  -Prints the difference between BigDecimal created from double vs String.
     *  1- Create two BigDecimals for the value 0.1:
     *  2- BigDecimal fromDouble = new BigDecimal(0.1);
     *  3- BigDecimal fromString = new BigDecimal("0.1");
     *  4- Print both values. Notice that fromDouble is NOT exactly 0.1!
     *  -It will show something like 0.1000000000000000055511151231257827021181583404541015625
     *  - Print a message explaining why the String constructor should be preferred.
     */
    public static void demonstrateDoubleProblem()
    {
        BigDecimal fromDouble = new BigDecimal(0.1);
        BigDecimal fromString = new BigDecimal("0.1");

        System.out.println("BigDecimal from double : " + fromDouble);
        System.out.println("BigDecimal from String : " + fromString);
        /*
           The double value 0.1 cannot be represented exactly in binary.
           Therefore, new BigDecimal(0.1) stores the approximate binary value.
           Using new BigDecimal("0.1") preserves the exact decimal value.
        */
    }




  
  /* ------------------Main Method------------------ */

    public static void main(String[] args)
    {

        System.out.println("=== Create from String ===");
        BigDecimal price = createFromString("19.99");
        System.out.println("Price: " + price);


        System.out.println("\n=== Addition ===");
        BigDecimal a = new BigDecimal("10.50");
        BigDecimal b = new BigDecimal("3.75");
        System.out.println("10.50 + 3.75 = " + addValues(a, b));


        System.out.println("\n=== Multiplication ===");
        BigDecimal quantity = new BigDecimal("3");
        System.out.println("19.99 * 3 = " + multiplyValues(price, quantity));


        System.out.println("\n=== Division with Rounding ===");
        BigDecimal ten   = new BigDecimal("10");
        BigDecimal three = new BigDecimal("3");
        System.out.println("10 / 3 (2 decimals): " + divideValues(ten, three, 2));
        System.out.println("10 / 3 (5 decimals): " + divideValues(ten, three, 5));



        System.out.println("\n=== Comparison ===");
        BigDecimal val1 = new BigDecimal("2.0");
        BigDecimal val2 = new BigDecimal("2.00");
        System.out.println("2.0 compareTo 2.00: " + compareValues(val1, val2));
        System.out.println("2.0 equals 2.00: " + val1.equals(val2) + " (WRONG way to compare!)");



        System.out.println("\n=== Double To BigDecimal ===");
        double number = 0.79;
        System.out.println(convertToBigDecimal(number));


        System.out.println("\n=== Double Problem ===");
        demonstrateDoubleProblem();
    }
  
}
/*
       -------------------- Output --------------------
      
        === Create from String ===
        Price: 19.99

        === Addition ===
        10.50 + 3.75 = 14.25
        
        === Multiplication ===
        19.99 * 3 = 59.97
        
        === Division with Rounding ===
        10 / 3 (2 decimals): 3.33
        10 / 3 (5 decimals): 3.33333
        
        === Comparison ===
        2.0 compareTo 2.00: 0
        2.0 equals 2.00: false (WRONG way to compare!)
        
        === Double To BigDecimal ===
        0.79
        
        === Double Problem ===
        BigDecimal from double : 0.1000000000000000055511151231257827021181583404541015625
        BigDecimal from String : 0.1
        -The double value 0.1 cannot be represented exactly in binary.
        -Therefore, new BigDecimal(0.1) stores the approximate binary value.
        -Using new BigDecimal("0.1") preserves the exact decimal value.
   
   */
