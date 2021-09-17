import java.util.ArrayList;
/**
 * Simulates the Customer and Checkout interaction
 * @author Vivian D'Souza
 */
public class TransactionHandler {
   /**
   * Handles transactions between customers and checkouts.
   * @param customerQueue an ArrayList of Customers
   * @param checkouts an object of CheckoutCounter type, holds all checkouts
   * @param checkoutBoard an object of Observer type
   */ 
   public void handleTransaction(ArrayList<Customer> customerQueue, CheckoutCounter checkouts, Observer checkoutBoard) {
    int z = 0; 
    while (z < customerQueue.size()) {
        
        System.out.println("Welcome, Customer " + customerQueue.get(z).getName() + "!"); // greeting
        checkoutBoard.display();   // displays current state of checkout board

        if (checkouts.isFull()) { // if all checkouts are in use
          System.out.println("All checkouts are in use. Please wait for the next available checkout.");

          // simulates time taken to use checkouts
          try {
              Thread.sleep(4 * 1000);
          } catch (InterruptedException ie) {
              Thread.currentThread().interrupt();
          }

          // resets all checkouts to open state
          for (Checkout checkout: checkouts.getAllCheckouts()) {
              checkout.setOpenStatus(true);
              checkouts.setNumInUse(-1);
          }
          checkouts.setStatus(false); // resets to all open
        }

        // else, direct customer to an open checkout
        for (Checkout checkout: checkouts.getAllCheckouts()) {
            if (checkout.isOpen()) { // finding an open checkout
                System.out.println(customerQueue.get(z).getName() + ", please proceed to " + checkout);
                checkout.setOpenStatus(false);
                checkouts.setNumInUse(1);
                System.out.println();
                break;
            }
        }
        z++; 
    }
   }
}
