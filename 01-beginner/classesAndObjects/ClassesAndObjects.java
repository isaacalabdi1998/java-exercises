import java.util.Objects;
public class ClassesAndObjects
{


    // ------- Person inner class -------
    static class Person
    {
      
        private String name;
        private int age;



        // no-args constructor
        public Person()
        {
            this("Unknown", 0);
        }

        public Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }


        // toString() method
        @Override
        public String toString()
        {
            return "Person{name='" + name + "', age=" + age + "}";
        }

      
        // equals() method
        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (! (obj instanceof Person))
            {
                return false;
            }

            Person other = (Person) obj;

            return age == other.age && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(name, age);
        }

    }



  /// --------------- Main method ---------------
    public static void main(String[] args)
    {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person();
        Person person3 = new Person("Alice", 30);

        // Print all persons
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        // Test equals()
        System.out.println("===Test equals()===");
        System.out.println("person1 equals person3 ?: " + person1.equals(person3));
        System.out.println("person1 equals person2 ?: " + person1.equals(person2));

        System.out.println("No-args person: " + person2);
    }



}
