package _1_encapsulation;
/**
 * Exercise: Encapsulation with BankAccount
 *
 * Learn how to protect data using private fields, provide controlled access
 * through getters, and enforce business rules in methods.
 *
 * Key concepts:
 * - Private fields to hide internal state
 * - Public methods to provide controlled access
 * - Validation logic inside setters/methods
 * - Private helper methods
 */

public final class BankAccount
{

  
    private String accountNumber;
    private double balance;
    private String ownerName;

  
    public BankAccount(String accountNumber, String ownerName, double initialBalance)
    {
        if (initialBalance < 0)
        {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }


  
    ///  ---------- Getters ----------
    public double getBalance()
    {
        return balance;
    }


  
    ///  ---------- Deposit ----------
    public double deposit(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        logTransaction("Deposited: " + amount);

        return balance;
    }


  
    ///  ---------- withdraw ----------
    public double withdraw(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance)
        {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        logTransaction("Withdrawn: " + amount);

      
        return balance;
    }



    private void logTransaction(String message)
    {
        System.out.println(message);
    }
  

    @Override
    public String toString()
    {
        return "BankAccount{accountNumber='" + accountNumber
                + "', ownerName='" + ownerName
                + "', balance=" + balance + "}";
    }



  /// -------------- Main Method --------------

    public static void main(String[] args)
    {

        BankAccount account = new BankAccount("ACC-001", "Alice", 1000.0);
        System.out.println(account);

        System.out.println("Before deposit: " + account.getBalance());
        account.deposit(500.0);
        System.out.println("After  deposit: " + account.getBalance());

        account.withdraw(200.0);
        System.out.println("After withdrawal: " + account.getBalance());

        // These should throw exceptions:
        // account.deposit(-100); 
        // account.withdraw(999999); 
    }

}

/*
-------Output-------
    BankAccount{accountNumber='ACC-001', ownerName='Alice', balance=1000.0}
    
    Before deposit: 1000.0
    Deposited: 500.0
    After  deposit: 1500.0
    
    Withdrawn: 200.0
    After withdrawal: 1300.0
*/
