import java.util.List;

public class PaymentProcessor
{
  
  
    void processAllPayments(List<Payment> payments, double amount)
    {
        for (Payment obj : payments)
        {
            obj.processPayment(amount);
            obj.printReceipt(amount);
        }
    }
  
  
}
