// ----------Step 1: We create an Interface that generally represents "any database"----------
public interface Database
{
    void save(String data);
}



// -------Step 2: We configure the various applications -------
public class MySQLDatabase implements Database
{
      @Override
      public void save(String data)
      {
          System.out.println("The data was saved in MySQL: " + data);
      }
}


public class MongoDatabase implements Database
{
      @Override
      public void save(String data)
      {
          System.out.println("The data was saved in MongoDB: " + data);
      }
}


// -------Step 3: UserService no longer creates the rule itself; it receives it from an external source-------
public class UserService
{
      private Database database;


      // Constructor Injection
      UserService(Database database)
      {
          this.database = database;
      }

      public void registerUser(String username)
      {
          database.save(username);
      }

}





// ---------- Main Class ----------
public class Main
{
  
      public static void main(String[] args)
      {
  
          // We can choose MySQL, or we can choose MongoDB, without touching the UserService code at all!
          MySQLDatabase sqlDB = new MySQLDatabase();
          MongoDatabase monDB = new MongoDatabase();
  
          UserService service1 = new UserService(sqlDB);
          UserService service2 = new UserService(monDB);
  
          service1.registerUser("Ahmed");  // The data was saved in MySQL: Ahmed
          service2.registerUser("Ali");    // The data was saved in MongoDB: Ali
      }
  
}

