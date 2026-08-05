import java.util.Scanner;
public class TryCatch
{


    // ---------------------- Safe Array Access--------------------
    /**
     *  Safely accesses an array element.
     *  @param arr the array
     *  @param index the element index
     *  @return the element, or -1 if the index is out of bounds
     */
    public static int safeArrayAccess(int[] arr, int index)
    {
          try
          {
              return arr[index];
          }
          catch (ArrayIndexOutOfBoundsException e)
          {
              System.out.println("Index out of bounds: " + index);
          }
          return -1;
    }



  
    // ---------------------- Safe ParseInt--------------------
    /**
     *  Safely parses a string into an integer.
     *  @param text the string to parse
     *  @return the parsed integer, or 0 if invalid
     */
    public static int safeParseInt(String text)
    {
          try
          {
              return Integer.parseInt(text);
          }
          catch (NumberFormatException e)
          {
              System.out.println("Cannot parse: " + text);
          }
  
          return 0;
    }



  
    // ---------------------- Divide With Finally --------------------
    /**
     *  Divides two numbers using try-catch-finally.
     *  - Returns the division result.
     *  - Returns 0 if division by zero occurs.
     *  - Always prints a completion message.
     *  @param a dividend
     *  @param b divisor
     *  @return the result of a/b, or 0 if b is zero
     */
    public static int divideWithFinally(int a, int b)
    {
          int result;
          try
          {
              result = a / b;
          }
          catch (ArithmeticException e)
          {
              System.out.println("Cannot divide by zero!");
              result = 0;
          }
          finally
          {
              System.out.println("Division operation completed.");
          }
  
          return result;
    }



  
    // ---------------------- Multi Catch Demo --------------------
    /**
     * Parses an array element safely.
     * @param data the string array
     * @param index the index to access
     * @return the parsed integer, or -1 if an error occurs
     */
    public static int multiCatchDemo(String[] data, int index)
    {
          try
          {
              return Integer.parseInt(data[index]);
          }
          catch (ArrayIndexOutOfBoundsException | NumberFormatException e)
          {
              System.out.println("Error: " + e.getMessage());
              return -1;
          }      
    }



  
    // ---------------------- Try With Resources --------------------
    /**
     * Reads an integer using try-with-resources.
     * @param input the input string
     * @return the parsed integer, or -1 on error
     */
    public static int tryWithResourcesDemo(String input)
    {

          try
          {
              Scanner scanner = new Scanner(input);
              return scanner.nextInt();
          }
          catch (Exception e)
          {
              return -1;
          }

    }



  
    // ---------------------- Validate Age --------------------
    /**
     * Validates an age value.
     * @param age the age to validate
     * @return the validated age
     * @throws IllegalArgumentException if age is negative
     */
    public static int validateAge(int age)
    {
          if(age < 0)
          {
              throw new IllegalArgumentException("Age cannot be negative: " + age);
          }
  
          return age;
    }



  
    // ---------------------- Process Value --------------------
    /**
     * Parses and validates a number.
     * @param value the input string
     * @return the validated number
     * @throws NumberFormatException if the input is not a number
     * @throws IllegalArgumentException if the number is negative
     */
    public static int processValue(String value)
    {
          return validateAge(Integer.parseInt(value));
    }







  
    ///  ============================== Main Class ==============================
  public static void main(String[] args)
  {
        int[] numbers = {10, 20, 30};
        System.out.println("=== Safe Array Access ===");
        System.out.println("Index 1: " + safeArrayAccess(numbers, 1));
        System.out.println("Index 5: " + safeArrayAccess(numbers, 5));

      
        System.out.println("\n=== Safe Parse Int ===");
        System.out.println("Parse '42': " + safeParseInt("42"));
        System.out.println("Parse 'abc': " + safeParseInt("abc"));

      
        System.out.println("\n=== Finally Block ===");
        System.out.println("10 / 2 = " + divideWithFinally(10, 2));
        System.out.println("10 / 0 = " + divideWithFinally(10, 0));

      
        System.out.println("\n=== Multi-Catch ===");
        String[] data = {"10", "abc", "30"};
        System.out.println("Index 0: " + multiCatchDemo(data, 0));
        System.out.println("Index 1: " + multiCatchDemo(data, 1));
        System.out.println("Index 9: " + multiCatchDemo(data, 9));

      
        System.out.println("\n=== Try-With-Resources ===");
        System.out.println("Parse '123': " + tryWithResourcesDemo("123"));
        System.out.println("Parse 'xyz': " + tryWithResourcesDemo("xyz"));


      
        System.out.println("\n=== Throw Exception ===");
        try
        {
            validateAge(25);
            System.out.println("Age 25 is valid");
            validateAge(-5);
        } catch (IllegalArgumentException e)
        {
            System.out.println("Caught: " + e.getMessage());
        }


      
        System.out.println("\n=== Exception Propagation ===");
        try
        {
            System.out.println("Process '42': " + processValue("42"));
            System.out.println("Process '-5': " + processValue("-5"));
        } catch (Exception e)
        {
            System.out.println("Propagated exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

  }

  

}
