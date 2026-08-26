public class BankTransferPayment implements Payment
{

    private String bankAccountId;

    public BankTransferPayment(String bankAccountId)
    {
        this.bankAccountId = bankAccountId;
    }

  
    @Override
    public boolean processPayment(double amount) 
    {
        System.out.println("Processing bank transfer of $" + amount + " from account " + bankAccountId
        );

        return true;
    }


  
    @Override
    public String getPaymentMethod()
    {
        return "Bank Transfer";
    }



}
