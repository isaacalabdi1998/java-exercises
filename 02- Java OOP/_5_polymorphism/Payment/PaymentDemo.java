import java.util.ArrayList;
import java.util.List;

public class PaymentDemo
{

  
    public static void main(String[] args)
    {

        List<Payment> payments = new ArrayList<>();
        payments.add(new CreditCardPayment("1234-5678"));
        payments.add(new PayPalPayment("user@gmail.com"));
        payments.add(new BankTransferPayment("ACC-12345"));


        PaymentProcessor processor = new PaymentProcessor();
        processor.processAllPayments(payments, 100.0);




        Payment payment = new CreditCardPayment("1234-5678");
        payment.processPayment(99.0);
    }

  

}


/*
--------------------------------- Output ---------------------------------
      Processing credit card payment of $100.0 with card 1234-5678
      Receipt: $100.0 paid via Credit Card
      
      Processing PayPal  payment of $100.0 from user@gmail.com
      Receipt: $100.0 paid via PayPal
      
      Processing bank transfer of $100.0 from account ACC-12345
      Receipt: $100.0 paid via Bank Transfer
      
      Processing credit card payment of $99.0 with card 1234-5678


*/
