import java.util.ArrayList;

public class TransactionHandler {

   public void handleTransaction(ArrayList<Customer> customerQueue, CheckoutCounter checkouts, Observer checkoutBoard) {
    int z = 0; 
    while (z < customerQueue.size()) {
        
        System.out.println("Welcome, Customer " + customerQueue.get(z).getName() + "!");
        checkoutBoard.display();
        if (checkouts.isFull()) {
        System.out.println("All checkouts are in use. Please wait for the next available checkout.");
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        for (Checkout checkout: checkouts.getAllCheckouts()) {
            checkout.setStatus(true);
            checkouts.setNumInUse(-1);
        }
        checkouts.setStatus(false);
        }

        for (Checkout checkout: checkouts.getAllCheckouts()) {
        if (checkout.isOpen()) {
            System.out.println(customerQueue.get(z).getName() + ", please proceed to " + checkout);
            checkout.setStatus(false);
            checkouts.setNumInUse(1);
            System.out.println();
            break;
        }
        }
        z++; 
    }
   }
}
