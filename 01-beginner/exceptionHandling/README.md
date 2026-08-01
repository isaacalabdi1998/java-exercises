# Java Exceptions - Try...Catch

- The  **`try`**  block: contains code that may throw an exception..
- The  **`catch`**  block: catches and handles a specific exception type.
- The  **`try`**  and  **`catch`**  keywords come in pairs:
- The  **`finally`**  statement lets you execute code, after  **`try...catch`**, regardless of the result:


## 1. try
**`try` block**: contains code that may throw an exception.
```java
try 
{
		// Divide by zero
		int x = 10 / 0; 
	   
	   
		// Invalid array index
		int[] arr = new int[5];  
		arr[10] = 50;  
		
		
		// Invalid string-to-number conversion
		int number = Integer.parseInt("7x");   
		System.out.println(number);
		
} 
```

## 2. catch
 **`catch` block**: catches and handles a specific exception type.```java
```java
try
{
		// Contains code that may throw an exception.
}

catch (ArithmeticException e) 
{
		System.out.println("Cannot divide by zero." + e.getMessage());
}
catch (ArrayIndexOutOfBoundsException e)  
{  
		System.out.println("Invalid index." + e.getMessage());  
}
catch (Exception e)  
{  
		System.out.println("General Error" + e.getMessage());  
}
```


## 3. finally
Always executes whether an exception occurs or not.

```java
try 
{
   // code...
}
catch (Exception e)
{
	// code...
}
finally 
{ 
	System.out.println("Done."); 
}
```
Used to:
-   Close files
-   Close database connections
-   Release resources
<br>

## 4. throw
Used to **manually create** an exception.

```java
throw new IllegalArgumentException("Invalid age");
```

<br>

## 5. throws
Used in a **method declaration** to say that the method may throw an exception.
```java
public void readFile() throws IOException 
{
}
```
<br>

## 6. Common Built-in Exceptions
| Exception | Cause |
|---|---|
| `ArithmeticException` | Division by zero |
| `NullPointerException` | Accessing a null object |
| `ArrayIndexOutOfBoundsException` | Invalid array index |
| `NumberFormatException` | Invalid string-to-number conversion |
| `ClassCastException` | Invalid type casting |
| `IOException` | File/Input-Output error |
 
---
<br>

## 7.1. Multiple catch Blocks

```java
try  {  
	  // code  
	  int x = 10 / 0;  
}  
catch (ArithmeticException e)  {  
	  System.out.println("Math Error" + e.getMessage());  
}  
catch (ArrayIndexOutOfBoundsException e)  {  
	  System.out.println("Invalid index." + e.getMessage());  
}  
catch (Exception e)  {  
	  System.out.println("General Error" + e.getMessage());  
}  
finally  {  
	  System.out.println("Program finished.");  
}

```
> [!NOTE]
> Always catch specific exceptions first, then the general  **Exception**.

## 7.2. Multi-Catch (Java 7+)
Combine multiple exception types in one catch block using `|`:
```java
try
{

}
catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException | ClassCastException e) 
{
    System.out.println("Error occurred: " + e.getMessage());
}
```
<br>


##  Checked vs Unchecked Exceptions
### A. Checked Exceptions

- Checked by the compiler.
- Must be handled using **try-catch** or **throws**.
- Examples
	- `IOException`
	- `SQLException`
	- `ClassNotFoundException`

### B. Unchecked Exceptions /RuntimeException
- Occur during runtime.
- Handling them is optional.
- Examples
	- `NullPointerException`
	- `ArithmeticException`
	- `ArrayIndexOutOfBoundsException`

###  C. Golden Rule
Both fall under the Throwable -> Exception category. The main difference is that Unchecked inherits directly from RuntimeException, while Checked inherits directly from Exception (and does not support RuntimeException).
>  - **Checked Exceptions** →  You **must** use `try-catch` or `throws`.
>  - **Unchecked Exceptions** → Handling is **optional**, but highly recommended.







