# Java Date and Time

### 1.	LocalDate     Represents a date (yyyy-MM-dd) )
### 2.	LocalTime     Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
### 3.	LocalDateTime Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
### 4.	DateTimeFormatter Formatter for displaying and parsing date-time objects


------
1. LocalDate Represents a **DATE** (yyyy-MM-dd) )

```java
import java.time.LocalDate;
public static void main(String[] args)
{

    LocalDate date = LocalDate.now();
        
    System.out.println(date);                 // 2026-07-28
    System.out.println(date.getDayOfWeek());  // TUESDAY
    System.out.println(date.getDayOfMonth()); // 28
    System.out.println(date.getDayOfYear());  // 209
    System.out.println(date.getMonth());      // JULY
    System.out.println(date.getYear());       // 2026
    
    System.out.println(date.minusDays(7));    // 2026-07-21
    System.out.println(date.minusWeeks(7));   // 2026-06-09
    System.out.println(date.minusMonths(7));  // 2025-12-28
    System.out.println(date.minusYears(7));   // 2019-07-28


}
```






------
2.	LocalTime     Represents a **TIME** (hour, minute, second and nanoseconds (HH-mm-ss-ns))

```java
import java.time.LocalTime;
public static void main(String[] args)
{

     LocalTime time = LocalTime.now();
                
     System.out.println(time);             // 21:34:15.195045600
     System.out.println(time.getNano());   // 195045600
     System.out.println(time.getSecond()); // 15
     System.out.println(time.getMinute()); // 34
     System.out.println(time.getHour());   // 21

}    
```
