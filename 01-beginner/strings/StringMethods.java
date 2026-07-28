package strings;
public class StringMethods
{
    /**
     * Checks if two strings are equal, first case-sensitive, then case-insensitive.
     * Returns a description of the comparison results.
     *
     * @param a first string
     * @param b second string
     * @return e.g., "equals: false, equalsIgnoreCase: true"
     */
    public static String compareEquality(String a, String b)
    {
        boolean isEqual = a.equals(b);
        boolean isEqualIgnoreCase = a.equalsIgnoreCase(b);

        return "Equals: " + isEqual + ", EqualsIgnoreCase: " + isEqualIgnoreCase;
    }


  

    /**
     * Compares two strings lexicographically using compareTo().
     * Returns "before", "equal", or "after" depending on the result.
     *
     * @param a first string
     * @param b second string
     * @return "before", "equal", or "after"
     */
    public static String compareLexicographic(String a, String b)
    {
        int result = a.compareTo(b);

        if(result < 0)
        {
            return "before";
        }
        else if (result > 0)
        {
            return "after";
        }
        else
        {
            return "equal";
        }
    }

  

  
    /**
     * Checks if the text contains a keyword and returns both the contains result
     * and the index of the first occurrence.
     *
     * @param text
     * @param keyword
     * @return
     */
    public static String searchString(String text, String keyword)
    {
        if(text == null || keyword == null)
        {
            return "contains: false, indexOf: -1";
        }
        else
        {
            return "contains: " + text.contains(keyword) +
                    ", index: " + text.indexOf(keyword);
        }
    }



  
    /**
     * Replaces all occurrences of oldWord with newWord,
     * then replaces all digits with "#" using replaceAll with a regex.
     *
     * @param text    the original text
     * @param oldWord the word to replace
     * @param newWord the replacement word
     * @return the modified text with both replacements applied
     */
    public static String replaceDemo(String text, String oldWord, String newWord)
    {
        return text.replace(oldWord, newWord).replaceAll("\\d", "#");
    }




  
    /**
     * Splits the text using the given delimiter and returns the parts
     * as a formatted string showing each part on a new line with its index.
     *
     * @param text      the text to split
     * @param delimiter the delimiter to split on
     * @return formatted string showing parts
     */
    public static String splitDemo(String text, String delimiter)
    {
        String[] parts = text.split(delimiter);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<parts.length; i++)
        {
            sb.append("[").append(i).append("]").append(parts[i]);
            if(i < parts.length -1)
            {
                sb.append("\n");
            }
        }
        return sb.toString();
    }


  

    /**
     * Checks if the filename starts with a given prefix and ends with a given extension.
     *
     * @param filename  the filename to check
     * @param prefix    the expected prefix
     * @param extension the expected extension (e.g., ".java")
     * @return e.g., "startsWith 'Test': true, endsWith '.java': true"
     */
    public static String checkStartEnd(String filename, String prefix, String extension)
    {
        boolean starts = filename.startsWith(prefix);
        boolean ends   = filename.endsWith(extension);

        return "startsWith'" + prefix + "': " + starts + ", endsWith '" + extension + "': " + ends;
    }



  
    /**
     * Extracts a substring from the given text.
     *
     * @param text       the source text
     * @param beginIndex the start index (inclusive)
     * @param endIndex   the end index (exclusive)
     * @return the extracted substring
     */
    public static String substringDemo(String text, int beginIndex, int endIndex)
    {
        return text.substring(beginIndex, endIndex);
    }



  
    /**
     * Formats a receipt line with item name, quantity, and price.
     * Example: "  Apple       x3      $2.50"
     *
     * @param item     the item name
     * @param quantity the quantity
     * @param price    the price per item
     * @return a formatted receipt line
     */
    public static String formatReceipt(String item, int quantity, double price)
    {
        return String.format("%-15s x%-5d $%.2f", item, quantity, price);
    }



  

    ///  ------------------Main Method----------------
    public static void main(String[] args)
    {
        System.out.println("=== Equality ===");
        System.out.println(compareEquality("Hello", "hello"));

        System.out.println("\n=== Lexicographic ===");
        System.out.println("apple vs banana: " + compareLexicographic("apple", "banana"));


        System.out.println("\n=== Search ===");
        System.out.println(searchString("Hello World", "World"));
        System.out.println(searchString("Hello World", "xyz"));
        System.out.println(searchString(null, "test"));


        System.out.println("\n=== Replace ===");
        System.out.println(replaceDemo("Hello World", "World", "Room101"));
        System.out.println(replaceDemo("I have 3 cats and 2 dogs", "cats", "birds"));
        System.out.println(replaceDemo("I have 2 cats and 3 dogs", "cats", "birds"));


        System.out.println("\n=== Split ===");
        System.out.println(splitDemo("apple,banana,cherry,date", ","));


        System.out.println("\n=== StartsWith / EndsWith ===");
        System.out.println(checkStartEnd("TestRunner.java", "Test", ".java"));


        System.out.println("\n=== Substring ===");
        System.out.println(substringDemo("Hello World", 0, 5));


        System.out.println("\n=== Formatted Receipt ===");
        System.out.println(formatReceipt("Apple", 3, 2.50));
        System.out.println(formatReceipt("Banana", 12, 1.25));
    }

}

/*
        -------------------- Output --------------------

        
        === Equality ===
        Equals: false, EqualsIgnoreCase: true
        
        === Lexicographic ===
        apple vs banana: before
        
        === Search ===
        contains: true, index: 6
        contains: false, index: -1
        contains: false, indexOf: -1
        
        === Replace ===
        Hello Room###
        I have # birds and # dogs
        I have # birds and # dogs
        
        === Split ===
        [0]apple
        [1]banana
        [2]cherry
        [3]date
        
        === StartsWith / EndsWith ===
        startsWith'Test': true, endsWith '.java': true
        
        === Substring ===
        Hello
        
        === Formatted Receipt ===
        Apple           x3     $2.50
        Banana          x12    $1.25
 */
