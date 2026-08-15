import java.util.Optional;

public class OptionalExercises
{


    /**
     * Creates an Optional containing the given value.
     * The value MUST NOT be null (Optional.of throws NullPointerException for null).
     * @param value a non-null string
     * @return an Optional containing the value
     *
     */

    public static Optional<String> createOptional(String value)
    {
        return Optional.of(value);
    }




    /**
     * Creates an Optional that may or may not contain a value.
     * If the input is null, returns an empty Optional.
     * @param value a string that might be null
     * @return an Optional that is empty if value is null, otherwise contains value
     */
    public static Optional<String> createNullableOptional(String value)
    {
        return Optional.ofNullable(value);
    }




    /**
     * Demonstrates isPresent() and get().
     * Returns the value if present, or "EMPTY" if not.
     *
     * @param optional the Optional to inspect
     */
    public static String checkAndGet(Optional<String> optional)
    {
        if (optional.isPresent())
        {
            return optional.get();
        }
        return "EMPTY";
    }




    /**
     * Returns the value from the Optional, or a default value if empty.
     * @param optional     the Optional to get the value from
     * @param defaultValue the default to use if Optional is empty
     * @return the contained value or the default
     */
    public static String getOrDefault(Optional<String> optional, String defaultValue)
    {
        return optional.orElse(defaultValue);
    }



    /**
     * Returns the value from the Optional, or throws an exception if empty.
     * @param optional the Optional to get the value from
     * @return the contained value
     * @throws NoSuchElementException if the Optional is empty
     */
    public static String getOrThrow(Optional<String> optional)
    {
        return optional.orElseThrow();
    }




    /**
     * Transforms the value inside the Optional using map().
     * Converts the string to uppercase if present.
     * @param optional the Optional containing a string
     * @return an Optional containing the uppercase string, or empty Optional
     */
    public static Optional<String> transformValue(Optional<String> optional)
    {
        return optional.map(String::toUpperCase);
    }




    /**
     * Demonstrates flatMap() with a method that itself returns an Optional.
     * Extracts the domain from an email address if present.
     * @param emailOptional an Optional that may contain an email address
     * @return an Optional containing the domain (part after @), or empty
     */
    public static Optional<String> extractDomain(Optional<String> emailOptional)
    {
        return emailOptional.flatMap(OptionalExercises::getDomain);
    }


    /**
     * Helper method: extracts the domain from an email address.
     * Returns empty Optional if the email doesn't contain '@'.
     */
    private static Optional<String> getDomain(String email)
    {
        int atIndex = email.indexOf('@');
        if (atIndex < 0)
        {
            return Optional.empty();
        }
        return Optional.of(email.substring(atIndex + 1));
    }







    ///  --------------- Main Method --------------
    public static void main(String[] args)
    {
        System.out.println("=== Optional.of() ===");
        Optional<String> opt1 = createOptional("Hello");
        System.out.println("Created: " + opt1);


        System.out.println("\n=== Optional.ofNullable() ===");
        Optional<String> opt2 = createNullableOptional(null);
        Optional<String> opt3 = createNullableOptional("World");
        System.out.println("From null: " + opt2);
        System.out.println("From 'World': " + opt3);


        System.out.println("\n=== isPresent() and get() ===");
        System.out.println("Check non-empty: " + checkAndGet(opt1));
        System.out.println("Check empty: " + checkAndGet(opt2));


        System.out.println("\n=== orElse() ===");
        System.out.println("Non-empty orElse: " + getOrDefault(opt1, "default"));
        System.out.println("Empty orElse: " + getOrDefault(opt2, "default"));


        System.out.println("\n=== orElseThrow() ===");
        System.out.println("Non-empty orElseThrow: " + getOrThrow(opt1));
        try
        {
            getOrThrow(opt2);
        } catch (Exception e)
        {
            System.out.println("Empty orElseThrow threw: " + e.getClass().getSimpleName());
        }


        System.out.println("\n=== map() ===");
        System.out.println("Map 'Hello' to uppercase: " + transformValue(opt1));
        System.out.println("Map empty to uppercase: " + transformValue(opt2));


        System.out.println("\n=== flatMap() ===");
        Optional<String> email = Optional.of("alice@example.com");
        Optional<String> noEmail = Optional.empty();
        Optional<String> badEmail = Optional.of("no-at-sign");
        System.out.println("Domain of alice@example.com: " + extractDomain(email));
        System.out.println("Domain of empty: " + extractDomain(noEmail));
        System.out.println("Domain of 'no-at-sign': " + extractDomain(badEmail));
    }
}


/*

---------- Output ----------
        === Optional.of() ===
        Created: Optional[Hello]
        
        === Optional.ofNullable() ===
        From null: Optional.empty
        From 'World': Optional[World]
        
        === isPresent() and get() ===
        Check non-empty: Hello
        Check empty: EMPTY
        
        === orElse() ===
        Non-empty orElse: Hello
        Empty orElse: default
        
        === orElseThrow() ===
        Non-empty orElseThrow: Hello
        Empty orElseThrow threw: NoSuchElementException
        
        === map() ===
        Map 'Hello' to uppercase: Optional[HELLO]
        Map empty to uppercase: Optional.empty
        
        === flatMap() ===
        Domain of alice@example.com: Optional[example.com]
        Domain of empty: Optional.empty
        Domain of 'no-at-sign': Optional.empty
*/

