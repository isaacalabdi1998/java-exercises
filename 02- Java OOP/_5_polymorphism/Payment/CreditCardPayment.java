public class CreditCardPayment implements Payment
{
  
    private String cardNumber;


    public CreditCardPayment(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }


  
    @Override
    public boolean processPayment(double amount)
    {
        System.out.println("Processing credit card payment of $" + amount + " with card " + cardNumber);
        return true;
    }


  
    @Override
    public String getPaymentMethod()
    {
        return "Credit Card";
    }
  


}
