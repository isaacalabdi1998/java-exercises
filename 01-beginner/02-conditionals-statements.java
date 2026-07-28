package ifStatements;
public class IfStatements
{

    /* Returns "Even" if the number is even, "Odd" otherwise. Must use the ternary operator (not if/else). */
    public static String evenOrOdd(int number)
    {
        return number % 2 == 0 ? "Even" : "Odd";
    }


    /* Determines if a person is eligible for a loan. Eligible if: (age >= 18 AND income >= 30000) OR (has a guarantor AND age >= 16) */
    public static boolean isEligibleForLoan(int age, double income, boolean hasGuarantor)
    {
        return (age >= 18 && income >= 30000) || (hasGuarantor && age >= 16);
    }


    /* Returns a letter grade using nested ternary operators.  90-100 -> "A",  80-89 -> "B",  70-79 -> "C",  60-69 -> "D",  below 60 -> "F" */
    public static String getGrade(int score)
    {
        return score >= 90 ? "A"
                : score >= 80 ? "B"
                : score >= 70 ? "C"
                : score >= 60 ? "D"
                : "F";
    }



    /* Returns the length of the given string, or -1 if the string is null.Must perform a null check before calling any method on the string. */
    public static int safeLength(String text)
    {
        return text == null ? -1 : text.length();
    }

  

    /* Checks if two strings are equal, handling nulls safely. Must use .equals() instead of == for string comparison. */
    public static boolean safeEquals(String a, String b)
    {
        if (a == null && b == null)
        {
            return true;
        }

        if (a == null || b == null)
        {
            return false;
        }

        return a.equals(b);
    }

  

    /*
        Returns the name of the day of the week for numbers 1 (Monday) through 7 (Sunday).
         - Uses a switch expression with arrow syntax (Java 14+).
         -  Returns "Invalid" for any other number.
    */
    public static String getDayName(int day)
    {
        return switch (day)
        {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };
    }





    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {
        System.out.println("=== Ternary Operator ===");
        System.out.println("4 is " + IfStatements.evenOrOdd(4));
        System.out.println("7 is " + IfStatements.evenOrOdd(7));

        System.out.println("\n=== Complex Conditions ===");
        System.out.println("Age 25, Income 40000, No guarantor: " + IfStatements.isEligibleForLoan(25, 40000, false));
        System.out.println("Age 17, Income 10000, Has guarantor: " + IfStatements.isEligibleForLoan(17, 10000, true));
        System.out.println("Age 15, Income 10000, Has guarantor: " + IfStatements.isEligibleForLoan(15, 10000, true));

        System.out.println("\n=== Nested Ternary (Grades) ===");
        System.out.println("Score 95: " + IfStatements.getGrade(95));
        System.out.println("Score 72: " + IfStatements.getGrade(72));
        System.out.println("Score 55: " + IfStatements.getGrade(55));

        System.out.println("\n=== Null Check ===");
        System.out.println("Length of 'hello': " + IfStatements.safeLength("hello"));
        System.out.println("Length of null: " + IfStatements.safeLength(null));

        System.out.println("\n=== String Equality ===");
        System.out.println("'abc' equals 'abc': " + IfStatements.safeEquals("abc", "abc"));
        System.out.println("'abc' equals null: " + IfStatements.safeEquals("abc", null));
        System.out.println("null equals null: " + IfStatements.safeEquals(null, null));

        System.out.println("\n=== Switch Expression ===");
        System.out.println("Day 1: " + IfStatements.getDayName(1));
        System.out.println("Day 5: " + IfStatements.getDayName(5));
        System.out.println("Day 9: " + IfStatements.getDayName(9));
    }



}
/*

    
       -------------------- Output --------------------    
            === Ternary Operator ===
            4 is Even
            7 is Odd


            === Complex Conditions ===
            Age 25, Income 40000, No guarantor: true
            Age 17, Income 10000, Has guarantor: true
            Age 15, Income 10000, Has guarantor: false


            === Nested Ternary (Grades) ===
            Score 95: A
            Score 72: C
            Score 55: F

            
            === Null Check ===
            Length of 'hello': 5
            Length of null: -1


            === String Equality ===
            'abc' equals 'abc': true
            'abc' equals null: false
            null equals null: true

            
            === Switch Expression ===
            Day 1: Monday
            Day 5: Friday
            Day 9: Invalid

*/
