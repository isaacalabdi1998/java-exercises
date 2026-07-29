
# Java Date and Time

### 1.	LocalDate     Represents a date (yyyy-MM-dd) )
### 2.	LocalTime     Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
### 3.	LocalDateTime Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
### 4.	DateTimeFormatter Formatter for displaying and parsing date-time objects


------
## 1. LocalDate `Represents a DATE (yyyy-MM-dd) )`

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

**Note:**
>The **LocalDate** Class only displays the **date** without the hour and minutes....






------
## 2.	LocalTime `Represents a TIME (hour, minute, second and nanoseconds (HH-mm-ss-ns))`

*2.1 LocalTime In my time zone*
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

*2.1 LocalTime In different time zones*
```java
import java.time.LocalTime;
public static void main(String[] args)
{
	LocalTime nowInHelsinki  = LocalTime.now();  
	LocalTime nowInTokyo     = LocalTime.now(ZoneId.of("Asia/Tokyo"));  
	LocalTime nowInUsEastern = LocalTime.now(ZoneId.of("US/Eastern"));  
	LocalTime nowInOslo      = LocalTime.now(ZoneId.of("Europe/Oslo"));  
	LocalTime nowInRiyadh	 = LocalTime.now(ZoneId.of("Asia/Riyadh"));  
	LocalTime nowInSydney 	 = LocalTime.now(ZoneId.of("Australia/Sydney"));  
	  
	System.out.println("Time In Helsinki : " + nowInHelsinki);   // 18:03:32.902745300  
	System.out.println("Time In Tokyo    : " + nowInTokyo);      // 00:03:32.907750300  
	System.out.println("Time In Eastern  : " + nowInUsEastern);  // 11:03:32.908747500  
	System.out.println("Time In Oslo     : " + nowInOslo);       // 17:03:32.908747500  
	System.out.println("Time In Riyadh   : " + nowInRiyadh);     // 18:03:32.908747500  
	System.out.println("Time In Sydney   : " + nowInSydney);     // 01:03:32.909751200
}
```
*2.3 To see all available time zone IDs that can be used as a parameter in:*
```java
import java.time.ZoneId;
public static void main(String[] args)
{
	
	// -------Using forLoop-------
	for(String index : ZoneId.getAvailableZoneIds())  
	{  
		  System.out.println(index);  
	}
	
	
	// -------Using java stream -------
	ZoneId.getAvailableZoneIds()  
	  .stream()  
	  .sorted()  
	  .forEach(System.out::println);
	  
/*
	-------------------- Output --------------------
	Asia/Aden
	America/Cuiaba
	Etc/GMT+9
	Etc/GMT+8
	Africa/Nairobi
	America/Marigot
	Asia/Aqtau
	Pacific/Kwajalein
	America/El_Salvador
	Asia/Pontianak
	Africa/Cairo
	...
*/
	}
```

**Note:**
>The **LocalTime** Class only displays the **time** (HH-mm-ss-ns) without the date.
------



## 3.	LocalDateTime `Represents both a DATE & TIME (yyyy-MM-dd-HH-mm-ss-ns)`
```java
import java.time.Month;  
import java.time.LocalDateTime;
public static void main(String[] args)
{
	
	LocalDateTime date1 = LocalDateTime.now();  
	LocalDateTime date2 = LocalDateTime.of(2018, Month.DECEMBER, 22, 14, 55, 22);  
	  
	  
	System.out.println(date1);  // 2026-07-29T17:44:25.076024800  
	System.out.println(date2);  // 2018-12-22T14:55:22
}
```
**Note:**
>The **LocalDateTime** Class displays the **Date** && **time** together , but without formatting.
------



## 4.	DateTimeFormatter `for displaying date and time formatted`



*4.1 Formatting Date and Time*
```java
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
public static void main(String[] args)
{
	LocalDateTime noFormatted = LocalDateTime.now();  
	System.out.println("Before formatting: " + noFormatted);  
	// 2026-07-29T18:53:53.304190100  
	  
	  
	DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	String str = noFormatted.format(formatted);  
	System.out.println("After formatting: " + str);
	// 29/07/2026 18:53:01 
}
```

*4.2 Using ofPattern() method*


### `Using` ofPattern() `Method`

| Pattern          | Example            |
|------------------|--------------------|
| `yyyy-MM-dd`     | `1988-09-29` 	    |
| `dd/MM/yyyy`     | `29/09/1988` 		  |
| `dd-MMM-yyyy`    | `29-Sep-1988`  	  |
| `E, MMM dd yyyy` | `Thu, Sep 29 1988` |


```java
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

public static void main(String[] args)
{
	LocalDateTime noFormatting = LocalDateTime.now();  
	System.out.println("Before formatting: " + noFormatting); // 2026-07-29T19:16:48.724757800  
	  
	  
	DateTimeFormatter formated1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	DateTimeFormatter formated2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	DateTimeFormatter formated3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");  
	DateTimeFormatter formated4 = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
	  
	String str1 = formated1.format(noFormatting);  
	String str2 = formated2.format(noFormatting);  
	String str3 = formated3.format(noFormatting);  
	String str4 = formated4.format(noFormatting);  
	  
	System.out.println("After formatting: " + str1);   // 29-07-2026  19:16:48  
	System.out.println("After formatting: " + str2);   // 29/07/2026  19:16:48  
	System.out.println("After formatting: " + str3);   // 29-Jul-2026 19:16:48  
	System.out.println("After formatting: " + str4);   // Wed, Jul 29 2026 19:16:48
}
```
------
