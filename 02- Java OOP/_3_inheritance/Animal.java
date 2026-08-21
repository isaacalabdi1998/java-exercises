/**
 * Exercise: Inheritance - Base Class
 *
 * Create a base Animal class that will serve as the parent for
 * specific animal types. This class defines common behavior
 * shared by all animals.
 *
 * Key concepts:
 * - Defining a base class with shared fields and behavior
 * - Protected vs private fields for inheritance
 * - Methods that subclasses can override
 */
public class Animal
{
  
    protected String name;
    protected int age;

  
    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

  
    public void makeSound()
    {
        System.out.println("Some generic animal sound");
    }

  
    public void eat(String food)
    {
        System.out.println(name + " is eating " + food);
    }

  
    @Override
    public String toString()
    {
        return  """
                 Name : %s
                 Age  : %d
                """.formatted(name, age);
    }

  
    public static void main(String[] args)
    {
        Animal animal = new Animal("Generic", 5);
        System.out.println(animal);
        animal.makeSound();
        animal.eat("food");
    }


}

/*

   ------- Output -------
     Name : Generic
     Age  : 5
  
    Some generic animal sound
    Generic is eating food

*/
