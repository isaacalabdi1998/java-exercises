package accessModifiers;
public class AccessModifiers
{
  
    // Private field
    private String secret;


    // Public method
    public String publicGreeting()
    {
        return "Hello from the public method!";
    }


    // Package-private method (no access modifier)
    String packageGreeting()
    {
        return "Hello from the package-private method!";
    }


    // Public getter
    public String getSecret()
    {
        return secret;
    }


    // Public setter
    public void setSecret(String secret) {
        this.secret = secret;
    }



      ///  ------------------Main Method----------------
    public static void main(String[] args)
    {
        // 1 - Create an instance of AccessModifiers.
        AccessModifiers instance = new AccessModifiers();


        System.out.println("=== Calling Public Method ===");


        // 2 - Call the publicGreeting() method.
        System.out.println(instance.publicGreeting());

        // 3 - Call the packageGreeting() method.
        System.out.println(instance.packageGreeting());


        System.out.println("\n=== Accessing Private Field Through Getter ===");


        // 4 - Set and get the private field using setter and getter.
        instance.setSecret("My Secret");
        System.out.println(instance.getSecret());

        System.out.println("\n=== Why Direct Private Access Won't Work ===");

        /*
            5 - The following line will NOT compile (instance.secret = "trying direct access")
            because the field 'secret' is private and can only be accessed from inside the
            AccessModifiers class.
            instance.secret = "trying direct access";
        */

    }


}

/*
      -------------------- Output -------------------- 
      
            === Calling Public Method ===
            Hello from the public method!
            Hello from the package-private method!


            === Accessing Private Field Through Getter ===
            My Secret
            
            === Why Direct Private Access Won't Work ===


*/
