import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**THIS IS AN OBSERVER
 * Creates Store which implements Observer and acts as a queue of bestsellers.
 * @author Vivian D'Souza
 */
public class CustomerQueueManager implements Observer {
  private Subject subject;
  private String title;
  private Queue<Checkout> checkouts;

  /**
  * Creates a CustomerQueue object and initalizes a queue of checkouts. 
  * @param subject a subject to which the customer will be assigned to.
  */
  public CustomerQueueManager(Subject subject) {
    this.subject = subject;
    subject.registerObserver(this);
    checkouts = new LinkedList<Checkout>(); //needs to be an implementation of a queue    
  }

  /**
  * Updates the bestsellers list.
  * @param book the book to be added
  */
  public void update(Checkout checkout) {
    checkouts.add(checkout);
  }

  /**
  * Displays the bestsellers list.
  */
  public void display() {
    System.out.println("\n");
    System.out.println("Open Checkouts:"); //This is what the customer line sees.
    for (Checkout checkout : checkouts) {
      String output = "";

      if (checkout.isOpen()) {
        output += "Checkout #" + checkout.getNum() + " is open.";

        if (checkout.getCardStatus()) {
          output += " Card: Yes,";
        } else {
          output += " Card: No,";
        }
  
        if (checkout.getCashStatus()) {
          output += " Cash: Yes";
        } else {
          output += " Cash: No";
        }
        System.out.println(output);
      } 
      
      
    }
    System.out.println("\n");
  }
  
}
