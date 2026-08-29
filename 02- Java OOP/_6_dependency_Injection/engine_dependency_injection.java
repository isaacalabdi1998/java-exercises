
// ------- interface Engine -------
public interface  Engine
{
      void start();
}




// ========== PetrolEngine Class implements  ---> Engine ==========
public class PetrolEngine implements Engine
{
  
      @Override
      public void start()
      {
          System.out.println("Petrol   engine started.......");
      }
  
}  




// ========== ElectricEngine Class implements  ---> Engine ==========
public class ElectricEngine implements Engine
{
  
      @Override
      public void start()
      {
          System.out.println("Electric engine started.......");
      }
  
}




// ========== Car Class ==========
public class Car
{

      private Engine engine;

  
      Car(Engine engine)
      {
          this.engine = engine;
      }

  
      void start()
      {
        engine.start();
      }

}



// ========== Main Class ==========
public class Main
{

    public static void main(String[] args)
    {

        Engine petrol   = new PetrolEngine();
        Engine electric = new ElectricEngine();


        Car car1 = new Car(petrol);
        Car car2 = new Car(electric);

        car1.start(); // Petrol   engine started.......
        car2.start(); // Electric engine started.......

    }

}

