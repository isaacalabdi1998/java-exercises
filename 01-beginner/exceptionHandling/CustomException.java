public class CustomException 
{



    // 1. InsufficientFundsException (Checked)
    public static class InsufficientFundsException extends Exception
    {
        private final double amount;
      
        public InsufficientFundsException(String message, double amount)
        {
            super(message);
            this.amount = amount;
        }
        public double getAmount()
        {
            return amount;
        }
    
    }  


  
    // 2. InvalidAgeException (Unchecked)
    public static class InvalidAgeException extends RuntimeException
    {
        public InvalidAgeException(String message)
        {
            super(message);
        }
        public InvalidAgeException(String message, Throwable cause)
        {
            super(message, cause);
        }
    }


  
    // 3. BankAccount Class
    public static class BankAccount
    {
        private double balance;
      
        public BankAccount(double initialBalance)
        {
            this.balance = initialBalance;
        }

        public void withdraw(double amount) throws InsufficientFundsException
        {
            if (amount > balance)
            {
                double shortfall = amount - balance;
                throw new InsufficientFundsException("Insufficient funds for withdrawal.", shortfall);
            }
            balance -= amount;
        }
        public double getBalance()
        {
            return balance;
        }
    }


  
    // 4. validateAge Method
    public static void validateAge(int age)
    {
        if (age < 0 || age > 150)
        {
            throw new InvalidAgeException("Age must be between 0 and 150. Provided: " + age);
        }
        System.out.println("Age " + age + " is valid.");
    }




  // -------------- Main Method Execution --------------
    public static void main(String[] args)
    {
      
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");
        BankAccount account = new BankAccount(100.0);
        try
        {
            account.withdraw(50);
            System.out.println("Successfully withdrawn $50. Remaining balance: $" + account.getBalance());
          
            account.withdraw(75);
        } catch (InsufficientFundsException e)
        {
            System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Shortage Amount: $" + e.getAmount());
        }
      
        try
        {
            validateAge(25);
            validateAge(-5);
        } catch (InvalidAgeException e)
        {
            System.out.println("Caught Exception: " + e.getMessage());
        }



        System.out.println("\n=== Exception Chaining ===");
        try
        {
            try
            {
                String input = "abc";
                Integer.parseInt(input);
            } catch (NumberFormatException e)
            {
                throw new InvalidAgeException("Failed to parse age from input string", e);
            }
        } catch (InvalidAgeException e)
        {
            System.out.println("Caught Outer Exception: " + e.getMessage());
            System.out.println("Underlying Cause: " + e.getCause());
        }
    }



}
