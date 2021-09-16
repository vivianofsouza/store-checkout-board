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
    Observer customerQueueManager = new CustomerQueueManager(checkouts); //holder of observers

    /*try {
      File morningSetting = new File("morning.txt");
      Scanner scanner = new Scanner(morningSetting);
      while (scanner.hasNextLine()) {
        Customer myCustomer = new Customer(scanner.next(), checkouts, scanner.next(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        customerQueue.add(myCustomer);
        myCustomer.display();
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error while reading in file");
      e.printStackTrace();
    }*/


    customerQueue.add(new Customer("Customer A", checkouts, "cash", 100.0, 100.0));
    customerQueue.add(new Customer("Customer B", checkouts, "cash", 10.0, 10.0));
    customerQueue.add(new Customer("Customer C", checkouts, "cash", 1.0, 1.0));

    

    //randomize checkouts systems
    checkouts.addCheckout(new Checkout(1, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(2, 500.00, true, true, false));
    checkouts.addCheckout(new Checkout(3, 500.00, true, false, true));
    checkouts.addCheckout(new Checkout(4, 500.00, true, true, false));
    checkouts.addCheckout(new Checkout(5, 500.00, true, true, true));
    checkouts.addCheckout(new Checkout(6, 500.00, true, true, false));

    for (Customer customer : customerQueue) {
      System.out.println("Welcome, " + customer.getName() + "!");

      for (Checkout checkout: checkouts.getAllCheckouts()) {
        if (checkout.isOpen()) {
          System.out.println(customer.getName() + ", proceed to " + checkout);
          checkout.setStatus(false);
          break;
        }
        
      }
      
    }
    
    customerQueueManager.display();


    //checkouts.useCheckout(one, customer1, true);
  }

  public static void main(String[] args){
    SelfCheckoutBoardDriver driver = new SelfCheckoutBoardDriver();
    driver.run();
  }
}
