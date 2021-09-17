import java.io.*;
import java.util.*;
/**
 * Runs the Self Checkout Board
 */
public class SelfCheckoutBoardDriver {
    
  /**
     * Creates the CheckoutArea and Checkouts along with the queue of Customers
     * Displays checkouts and their states
     * Displays customers
     */
  public void run() {
    ArrayList<Customer> customerQueue = new ArrayList<Customer>(); //line of customers - observer 1
    CheckoutCounter checkouts = new CheckoutCounter(); //holder of subjects
    Observer checkoutBoard = new CheckoutBoard(checkouts); //holder of observers
    TransactionHandler transactionHandler = new TransactionHandler();
    Scanner fileInput = new Scanner(System.in);
    String fileName = fileInput.next();

    // Reading in selected simulation file
    try {
      
      fileInput.close();
      File setting = new File(fileName);
      Scanner scanner = new Scanner(setting);
      while (scanner.hasNextLine()) {
        Customer myCustomer = new Customer(scanner.next(), checkouts, scanner.next(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        customerQueue.add(myCustomer);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error while reading in file");
      e.printStackTrace();
    }

    // Initializing checkouts and adding to Checkout Queue
    checkouts.addCheckout(new Checkout(1, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(2, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(3, 500.00, true, false, true));
    checkouts.addCheckout(new Checkout(4, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(5, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(6, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(7, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(8, 500.00, true, true, true));

    System.out.println("-----SIMULATION BEGIN------");
    transactionHandler.handleTransaction(customerQueue, checkouts, checkoutBoard);
    System.out.println("-----SIMULATION END------");
  }

  public static void main(String[] args){
    SelfCheckoutBoardDriver driver = new SelfCheckoutBoardDriver();
    driver.run();
  }
}
