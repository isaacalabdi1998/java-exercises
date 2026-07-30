import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateExercises
{

    /**
    * Returns today's date.
    * @return today's date as a LocalDate
    * - Use LocalDate.now() to get and return today's date.
    */
    public static LocalDate getToday()
    {
        return LocalDate.now();
    }


  
    /**
    * Creates a specific date: July 4, 1776.
    * @return the date July 4, 1776
    * - Use LocalDate.of(year, month, day) to create and return July 4, 1776.
    */
    public static LocalDate getIndependenceDay()
    {
        return LocalDate.of(1776, Month.JULY,4);
    }


  
    /**
    * @return the current date and time as a LocalDateTime
    * - Use LocalDateTime.now() to get and return the current date and time.
    */
    public static LocalDateTime getCurrentDateTime()
    {
        return LocalDateTime.now();
    }


  
    /**
     * Takes a date and adds the specified days, months, and years to it.
     *
     * @param date   the starting date
     * @param days   number of days to add
     * @param months number of months to add
     * @param years  number of years to add
     * @return the new date after adding the specified amounts
     * - Use plusDays(), plusMonths(), and plusYears() on the date.
     * - Remember: LocalDate is immutable, so each method returns a NEW LocalDate.
     * - Chain the calls or apply them sequentially.
     */
    public static LocalDate addToDate(LocalDate date, int days, int months, int years)
    {

        /*
            date = date.plusDays(days);
            date = date.plusMonths(months);
            date = date.plusYears(years);
            return date;
        */

        return date.plusDays(days)
                   .plusMonths(months)
                   .plusYears(years);
    }


  
    /**
     * Checks the relationship between two dates.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return "before" if date1 is before date2, "after" if after, "equal" if same
     * - Use isBefore() and isAfter() methods on date1 to compare with date2.
     * - Return "before", "after", or "equal".
     */
    public static String compareDates(LocalDate date1, LocalDate date2)
    {
                //-------  Using if -------
        /*if(date1.isBefore(date2))
        {
            return "before";
        }
        else if (date1.isAfter(date2))
        {
            return "after";
        }
        else
        {
            return "equal";
        }
        */

                //-------  Using compareTo() -------
        /* int result = date1.compareTo(date2);
           return result < 0 ? "before" : result > 0 ? "after" : "equal"; */

        return date1.isBefore(date2) ? "before" :
               date1.isAfter(date2)  ? "after"  : "equal";
    }


  
    /**
     *  Formats a date using the given pattern.
     *  Example patterns: "dd/MM/yyyy", "MMMM d, yyyy", "yyyy-MM-dd"
     *
     *  @param date    the date to format
     *  @param pattern the format pattern
     *  @return the formatted date as a String
     *  - Create a DateTimeFormatter using DateTimeFormatter.ofPattern(pattern).
     *  - Use date.format(formatter) to format the date.
     *  - Return the formatted string.
     */
    public static String formatDate(LocalDate date, String pattern)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }


  
    /**
     * Parses a date string in the format "dd-MM-yyyy" and returns a LocalDate.
     * Example: "25-12-2025" -> LocalDate of December 25, 2025
     *
     * @param dateString the date string in "dd-MM-yyyy" format
     * @return the parsed LocalDate
     * - Create a DateTimeFormatter with the pattern "dd-MM-yyyy".
     * - Use LocalDate.parse(dateString, formatter) to parse the string.
     * - Return the resulting LocalDate.
     *
     */
    public static LocalDate parseDate(String dateString)
    {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         return LocalDate.parse(dateString, formatter);

    }




    ///-------------------- Main --------------------
    public static void main(String[] args)
    {

        System.out.println("=== Today's Date ===");
        System.out.println("Today: " + getToday());



        System.out.println("\n=== Specific Date ===");
        System.out.println("Independence Day: " + getIndependenceDay());

        System.out.println("\n=== Current Date and Time ===");
        System.out.println("Now: " + getCurrentDateTime());


        System.out.println("\n=== Date Arithmetic ===");
        LocalDate today = LocalDate.now();
        System.out.println("Today + 10 days, 2 months, 1 year: " + addToDate(today, 10, 2, 1));


        System.out.println("\n=== Compare Dates ===");
        LocalDate past   = LocalDate.of(2020, 1, 1);
        LocalDate future = LocalDate.of(2030, 12, 31);
        System.out.println("2020-01-01 vs 2030-12-31: " + compareDates(past, future));
        System.out.println("2030-12-31 vs 2020-01-01: " + compareDates(future, past));


        System.out.println("\n=== Format Date ===");
        System.out.println("dd/MM/yyyy   :   " + formatDate(today, "dd/MM/yyyy"));
        System.out.println("MMMM d, yyyy :   " + formatDate(today, "MMMM d, yyyy"));


        System.out.println("\n=== Parse Date ===");
        System.out.println("Parsed '25-12-2025': " + parseDate("25-12-2025"));

    }
}

/*
       -------------------- Output --------------------
    
        === Today's Date ===
        Today: 2026-07-30
        
        
        === Specific Date ===
        Independence Day: 1776-07-04
        
        
        === Current Date and Time ===
        Now: 2026-07-30T14:50:46.688409600
        
        
        === Date Arithmetic ===
        Today + 10 days, 2 months, 1 year: 2027-10-09
        
        
        === Compare Dates ===
        2020-01-01 vs 2030-12-31: before
        2030-12-31 vs 2020-01-01: after
        
        
        === Format Date ===
        dd/MM/yyyy   :   30/07/2026
        MMMM d, yyyy :   July 30, 2026
        
        
        === Parse Date ===
        Parsed '25-12-2025': 2025-12-25   
   */
