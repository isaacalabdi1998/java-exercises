/**
 * Exercise: Immutability
 *
 * Learn how to create an immutable class — an object whose state cannot
 * be changed after creation. Immutable objects are thread-safe and
 * easier to reason about.
 *
 * Key concepts:
 * - Private final fields
 * - No setters
 * - "with" methods that return new instances instead of modifying state
 * - Defensive copying (when applicable)
 */

public final class ImmutablePerson
{
    // 1 - Private final fields
    private final String name;
    private final int age;
    private final String email;

  
    // 2 - Constructor
    public ImmutablePerson(String name, int age, String email)
    {
        this.name = name;
        this.age = age;
        this.email = email;
    }

  
    // 3 - Getter methods
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }

  
    // 4 - withName method
    public ImmutablePerson withName(String newName)
    {
        return new ImmutablePerson(newName, age, email);
    }

    // 5 - withAge method
    public ImmutablePerson withAge(int newAge)
    {
        return new ImmutablePerson(name, newAge, email);
    }

  
    // 6 - toString method
    @Override
    public String toString()
    {
        return "ImmutablePerson{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }






  
    ///  -------------- Main Method --------------
    public static void main(String[] args)
    {

        ImmutablePerson person = new ImmutablePerson("Alice", 30, "alice@example.com");
        System.out.println(person);

        // withName returns a NEW object — original is unchanged
        ImmutablePerson renamed = person.withName("Bob");
        
        System.out.println("Original: " + person);
        System.out.println("Renamed:  " + renamed);

        // withAge returns a NEW object — original is unchanged
        ImmutablePerson aged = person.withAge(31);

        System.out.println("Original: " + person);
        System.out.println("Aged:     " + aged);
    }
}

/*

              -------------- Output --------------
    ImmutablePerson{name='Alice', age=30, email='alice@example.com'}
    
    Original: ImmutablePerson{name='Alice', age=30, email='alice@example.com'}
    Renamed:  ImmutablePerson{name='Bob', age=30, email='alice@example.com'}
    Original: ImmutablePerson{name='Alice', age=30, email='alice@example.com'}
    Aged:     ImmutablePerson{name='Alice', age=31, email='alice@example.com'}

*/
