package accessModifiers;

public class AccessModifiers
{
    // Private field
    private String secret;


    // 2 - Public method
    public String publicGreeting()
    {
        return "Hello from a public method!";
    }


    // 3 - Protected method
    protected String protectedGreeting()
    {
        return "Hello from a protected method!";
    }

    // 4 - Package-private (default) method
    String packageGreeting()
    {
        return "Hello from a package-private(default) method!";
    }


    // 5 - Getter
    public String getSecret()
    {
        return secret;
    }

    // 5 - Setter
    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public String demonstrateInternalAccess()
    {
        // Direct access to the private field
        secret = "Internal access works!";

        // Calling all methods
        String publicMessage = publicGreeting();
        String protectedMessage = protectedGreeting();
        String packageMessage = packageGreeting();

        return "Secret: " + secret + "\n"
                + publicMessage + "\n"
                + protectedMessage + "\n"
                + packageMessage;
    }



  ///  ------------------Main Method----------------
  
    public static void main(String[] args)
    {
        AccessModifiers access = new AccessModifiers();
        System.out.println(access.demonstrateInternalAccess());

    }

}

/*
      -------------------- Output -------------------- 

        Secret: Internal access works!
        Hello from a public method!
        Hello from a protected method!
        Hello from a package-private(default) method! 
 
*/
