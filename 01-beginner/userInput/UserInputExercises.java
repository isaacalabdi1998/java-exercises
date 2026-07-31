import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInputExercises
{
  
    /**
     * -Reads a single line of text from the user and returns it.
     *  @param scanner the Scanner to read from
     *  @return the line entered by the user
     *  -Prompt the user with "Enter your name: " (use System.out.print).
     *  -Read a full line using scanner.nextLine() and return it.
     */
    public static String readString(Scanner scanner)
    {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }


  
    /**
     * -Reads an integer from the user with validation.
     * -If the user enters something that is not an integer, catches the exception and returns -1.
     *  @param scanner the Scanner to read from
     *  @return the integer entered, or -1 if input was invalid
     * -Use a try-catch block:
     * -try to read an int with scanner.nextInt()
     * -catch InputMismatchException, print "Invalid input!", and return -1.
     * -Don't forget to consume the leftover newline with scanner.nextLine()
     * -after reading the int (both in success and failure cases).
     *
     *
     */
    public static int readIntSafely(Scanner scanner)
    {
        System.out.print("Enter a number: ");
        try {
            int number = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer (consume leftover newline)
            return number;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input!");
            scanner.nextLine(); // Clear the buffer after failed input
            return -1;
        }
    }


  
    /**
     * -Reads strings from the user in a loop until they type "quit".
     * -Prints each entered string back to them.
     *  @param scanner the Scanner to read from.
     * -Use a while loop to keep reading input.
     * -Prompt with "Enter text (or 'quit' to stop): ".
     * -Read a line with scanner.nextLine().
     * -If the line equals "quit" (case-insensitive), break out of the loop.
     *  -Otherwise, print "You entered: " followed by the input.
     */
    public static void readUntilQuit(Scanner scanner)
    {
        while (true)
        {
            System.out.print("Enter text (or 'quit' to stop): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit"))
            {
                break;
            }
            System.out.println("You entered: " + input);
        }
    }


  
    /**
     * -Validates that an age is between 0 and 150 (inclusive).
     *  @param age the age to validate
     *  @return true if valid, false otherwise
     * -Return true if age is between 0 and 150 (inclusive), false otherwise.
     */
    public static boolean isValidAge(int age)
    {
        return age >= 0 && age <= 150;
    }


  
    /**
     * -Validates that an email address contains an "@" symbol.
     *  @param email the email to validate
     *  @return true if valid (contains @), false otherwise
     * -Return true if email is not null and contains "@", false otherwise.
     */
    public static boolean isValidEmail(String email)
    {
        return email != null && email.contains("@");
    }


  
    /**
     * -Runs a simple registration form that collects name, age, and email.
     * -Validates each input and keeps asking until valid data is provided.
     *  @param scanner the Scanner to read from
     *
     * -Build a registration form:
     *     1. Ask for name (any non-empty string is valid). Keep asking if empty.
     *     2. Ask for age. Keep asking until isValidAge() returns true.
     *        Handle InputMismatchException if they enter a non-number.
     *     3. Ask for email. Keep asking until isValidEmail() returns true.
     *     4. Print a summary: "Registration complete!"
     *        "Name: ...", "Age: ...", "Email: ..."
     *
     */
    public static void registrationForm(Scanner scanner)
    {
        // 1. Ask for name (keep asking if empty)
        String name = "";
        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();
        }while (name.isEmpty());


        // 2. Ask for age (keep asking until valid integer and isValidAge is true)
        int age = -1;
        while (true)
        {
            System.out.print("Enter your age: ");
            try
            {
                age = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                if(isValidAge(age))
                {
                    break; // Age is valid, exit loop
                }
                else
                {
                    System.out.println("Invalid age! Must be between 0 and 150.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear leftover input
            }
        }


        // 3. Ask for email (keep asking until isValidEmail is true)
        String email = "";
        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine().trim();
            if (!isValidEmail(email))
            {
                System.out.println("Invalid email! Must contain '@'.");
            }
        }while (!isValidEmail(email));


        // 4. Print summary
        System.out.println("\nRegistration complete!");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }






  
  // --------------- Main Method ---------------
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


      
        System.out.println("=== Read String ===");
        String name = readString(scanner);
        System.out.println("Hello, " + name + "!");

      
        System.out.println("\n=== Read Int Safely ===");
        int number = readIntSafely(scanner);
        System.out.println("You entered: " + number);

      
        System.out.println("\n=== Read Until Quit ===");
        readUntilQuit(scanner);

      
        System.out.println("\n=== Validation ===");
        System.out.println("Age 25 valid? " + isValidAge(25));
        System.out.println("Age -5 valid? " + isValidAge(-5));
        System.out.println("Email 'test@mail.com' valid? " + isValidEmail("test@mail.com"));
        System.out.println("Email 'testmail.com'  valid? " + isValidEmail("testmail.com"));

      
        System.out.println("\n=== Registration Form ===");
        registrationForm(scanner);
      
    }
}
