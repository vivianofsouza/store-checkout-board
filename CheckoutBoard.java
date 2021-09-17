import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Creates CheckoutBoard which implements Observer and acts as a queue of checkouts.
 * @author Vivian D'Souza
 */
public class CheckoutBoard implements Observer {
  private Subject subject;
  private String title;
  private Queue<Checkout> checkouts;

  /**
  * Creates a CustomerQueue object and initalizes a queue of checkouts. 
  * @param subject a subject to which the customer will be assigned to.
  */
  public CheckoutBoard(Subject subject) {
    this.subject = subject;
    subject.registerObserver(this);
    checkouts = new LinkedList<Checkout>();   
  }

  /**
  * Updates the checkout list.
  * @param checkout the checkout to be added
  */
  public void update(Checkout checkout) {
    checkouts.add(checkout);
  }

  /**
  * Displays the Checkouts board.
  */
  public void display() {
    System.out.println("\n");
    System.out.println("Open Checkouts:"); 
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
