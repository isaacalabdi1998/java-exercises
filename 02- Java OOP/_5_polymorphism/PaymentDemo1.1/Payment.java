public interface Payment
{

  
    boolean processPayment(double amount);

    String getPaymentMethod();

    default void printReceipt(double amount) 
    {
        System.out.println("Receipt: $" + amount + " paid via " + getPaymentMethod() + "\n");
    }

  
}
