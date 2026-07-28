package strings;

public class StringBuilderExercises
{
    /**
     * Builds a greeting message by appending parts.
     *
     * @param name the person's name
     * @param age  the person's age
     * @param age  the person's age
     */
    public static String buildGreeting(String name, int age)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ")
                .append(name)
                .append("! You ar ")
                .append(age)
                .append(" years old");

        return sb.toString();
    }


  
    /**
     * Inserts a middle name into a full name at the correct position.
     * Given "John Smith" and middle name "Michael", returns "John Michael Smith"
     *
     * @param fullName   the full name with first and last name
     * @param middleName the middle name to insert
     * @return the full name with the middle name inserted after the first name
     */
    public static String insertMiddleName(String fullName, String middleName)
    {
        StringBuilder sb = new StringBuilder(fullName);

        // Find the location of the first empty space
        int spaceIndex = sb.indexOf(" ");

        // Insert the middle name followed by a space immediately after the first space.
        sb.insert(spaceIndex + 1, middleName + " ");

        return sb.toString();
    }

  

    /**
     *  Removes all vowels (a, e, i, o, u — both cases) from the text.
     *
     *  @param text the original text
     *  @return the text with vowels removed
     */
    public static String removeVowels(String text)
    {
        StringBuilder sb = new StringBuilder(text);

        // Reverse scrolling from last letter to first
        for (int i=sb.length()-1; i>=0; i--)
        {
            char ch = sb.charAt(i);

            // Check if the letter is a vowel
            if ("aeiouAEIOU".indexOf(ch) >= 0)
            {
                sb.deleteCharAt(i);
            }
        }

        return sb.toString();
    }


  
    /**
     * Reverses the given text using StringBuilder's reverse() method.
     *
     * @param text the original text
     * @return the reversed text
     */
    public static String reverseText(String text)
    {
        return new StringBuilder(text).reverse().toString();
    }



  
    /**
     * Demonstrates converting between StringBuilder and String.
     * Takes a string, converts to StringBuilder, modifies it, converts back.
     *
     * @param text the original text
     * @return the text converted to uppercase with "!!!" appended
     */
    public static String convertDemo(String text)
    {
        StringBuilder sb1 = new StringBuilder(text);
        String str = sb1.toString();
        String upperStr = str.toUpperCase();
        StringBuilder sb2 = new StringBuilder(upperStr);
        sb2.append("!!!");

        return sb2.toString();
    }


  
    /**
     * Converts an array of values into a CSV (comma-separated values) line.
     * Example: ["Alice", "30", "London"] -> "Alice,30,London"
     *
     * @param values the array of values
     * @return a CSV line with values separated by commas (no trailing comma)
     */

    public static String buildCsvLine(String[] values)
    {
        if(values == null || values.length == 0)
            return "";
        return String.join(" | ", values);
        /* ######## WE CAN ALSO USE THIS CODE ########
        StringBuilder sb = new StringBuilder();
        for (int i=0;  i < arr.length;  i++)
        {
            sb.append(arr[i]);
            if(i < arr.length -1)
            {
                sb.append(" | ");
            }
        }
        return sb.toString(); */
    }




    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {

        System.out.println("=== Build Greeting ===");
        System.out.println(buildGreeting("Alice", 25));

        System.out.println("\n=== Insert Middle Name ===");
        System.out.println(insertMiddleName("John Smith", "Michael"));

        System.out.println("\n=== Remove Vowels ===");
        System.out.println(removeVowels("Hello World"));

        System.out.println("\n=== Reverse ===");
        System.out.println(reverseText("Java"));

        System.out.println("\n=== Convert Demo ===");
        System.out.println(convertDemo("hello world"));

        System.out.println("\n=== Build CSV ===");
        System.out.println(buildCsvLine(new String[]{"Alice", "30", "London", "Engineer"}));

    }
}


/*
       -------------------- Output --------------------  

       
         === Build Greeting ===
      Hello, Alice! You ar 25 years old
      
      === Insert Middle Name ===
      John Michael Smith
      
      === Remove Vowels ===
      Hll Wrld
      
      === Reverse ===
      avaJ
      
      === Convert Demo ===
      HELLO WORLD!!!

      === Build CSV ===
      Alice | 30 | London | Engineer
*/












