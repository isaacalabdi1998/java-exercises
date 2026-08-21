/**
 * Exercise: Inheritance - Subclass
 *
 * Create a Dog class that extends Animal. Practice using super()
 * to call the parent constructor, overriding methods, and adding
 * behavior specific to the subclass.
 *
 * Key concepts:
 * - Extending a parent class
 * - Calling super() in the constructor
 * - Overriding methods with @Override
 * - Adding subclass-specific fields and methods
 */
public class Dog extends Animal
{
  
    private String breed;

    public Dog(String name, int age, String breed)
    {
        super(name, age);
        this.breed = breed;
    }

  
    @Override
    public void makeSound()
    {
        System.out.println(name + " says: Woof! Woof!");
    }

  
    public void fetch(String item)
    {
        System.out.println(name + " fetches the " + item + "!");
    }

  
    @Override
    public String toString()
    {
        return  """
                ----- Dog -----
                Name  : %s
                Age   : %d
                Breed : %s
                """.formatted(name, age, breed);
    }



  

    //---------- Main Method ----------
    public static void main(String[] args)
    {
        Dog dog = new Dog("Buddy", 20, "Golden Retriever");

        System.out.println(dog);
        dog.makeSound();
        dog.eat("kibble");
        dog.fetch("tennis ball");

      
        // Polymorphism
        Animal animal = new Dog("Rex", 5, "German Shepherd");
        animal.makeSound();

    }

}

/*
---------- Output ----------
      ----- Dog -----
      Name  : Buddy
      Age   : 20
      Breed : Golden Retriever
      
      Buddy says: Woof! Woof!
      Buddy is eating kibble
      Buddy fetches the tennis ball!
      
      Rex says: Woof! Woof!
*/
