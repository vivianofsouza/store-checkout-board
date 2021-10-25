import java.io.*;
import java.util.*;
/**
 * Runs the Self Checkout Board
 * @author Vivian D'Souza
 */
public class SelfCheckoutBoardDriver {
    
  /**
     * Initalizes the lists of Customers and Checkouts, along with the CheckoutBoard
     * Runs the simulation
     */
  public void run() {
    ArrayList<Customer> customerQueue = new ArrayList<Customer>(); // line of customers 
    CheckoutCounter checkouts = new CheckoutCounter(); // line of checkouts - holder of subjects (checkouts)
    Observer checkoutBoard = new CheckoutBoard(checkouts); // Checkout Board - view of observers (the customers)
    TransactionHandler transactionHandler = new TransactionHandler(); // handles the transactions

    // Reading in selected simulation file
    System.out.println("Please enter the name of the file from which the simulation would be read");
    Scanner fileInput = new Scanner(System.in);
    String fileName = fileInput.next();

    try { 
      fileInput.close();
      File setting = new File(fileName);
      Scanner scanner = new Scanner(setting);
      while (scanner.hasNextLine()) {
        // intializing customer list with lines from file
        Customer myCustomer = new Customer(scanner.next(), checkouts, scanner.next(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        customerQueue.add(myCustomer);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error while reading file.");
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

    // Starting simulation
    System.out.println("-----SIMULATION BEGIN------");
    transactionHandler.handleTransaction(customerQueue, checkouts, checkoutBoard);
    System.out.println("-----SIMULATION END------");
  }

  public static void main(String[] args){
    SelfCheckoutBoardDriver driver = new SelfCheckoutBoardDriver();
    driver.run();
  }
}
