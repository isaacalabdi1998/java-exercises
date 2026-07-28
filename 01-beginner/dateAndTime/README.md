# Java Date and Time

### 1.	LocalDate     Represents a date (yyyy-MM-dd) )
### 2.	LocalTime     Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
### 3.	LocalDateTime Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
### 4.	DateTimeFormatter Formatter for displaying and parsing date-time objects



```java
import java.time.LocalDate;
public static void main(String[] args)
{

    LocalDate date = LocalDate.now();
    System.out.println(date);
    System.out.println(date.getDayOfWeek());
    System.out.println(date.getDayOfMonth());
    System.out.println(date.getDayOfYear());
    System.out.println(date.getMonth());
    System.out.println(date.getYear());

    System.out.println(date.minusDays(7));
    System.out.println(date.minusWeeks(7));
    System.out.println(date.minusMonths(7));
    System.out.println(date.minusYears(7));


}
```
