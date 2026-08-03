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


##  8. Throwable Exceptions Class
### 8.1 Exception Hierarchy in Java
<img width="1619" height="972" alt="checkedVsUnchecked" src="https://github.com/user-attachments/assets/6eb19f65-6bb9-41c8-b228-d8696a3e71e1" />

<br>

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

<br>

### 8.2 Checked Exceptions Example
```java
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;

public static void main(String[] args)
{
	try
	{
			// Open the file  
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

			// Read the file content
			String line;  
			while ((line = reader.readLine()) != null)  
			{  
				System.out.println(line);  
			}  

			// Close file  
			reader.close();
	}
	catch (IOException e)
	{
			System.out.println("An error occurred while reading the file.");  
			System.out.println("The reason: " + e.getMessage());
	}
	finally
	{
			System.out.println("The program has finished.");
	}

}
```
>This program reads a text file and displays its contents. It uses a try-catch block to handle **checked exception** such as **`IOException`**.

<br>

### 8.3 Unchecked Exceptions Example

```java
public static void main(String[] args)
{
	try
	{
			// Divide by zero
            int x = 10 / 05;

			// Invalid array index
            int[] arr = new int[5];
            arr[10] = 50;

			// Invalid string-to-number conversion
            int number = Integer.parseInt("7x");
            System.out.println(number);
	}
	catch (ArithmeticException | ArrayIndexOutOfBoundsException | ClassCastException e)
	{
			System.out.println("The reason: " + e.getMessage());
	}


}
```


