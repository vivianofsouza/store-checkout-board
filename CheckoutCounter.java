import java.util.ArrayList;

/**THIS IS THE SUBJECT
 * Creates Bestsellers, an implementation of Subject. 
 * Allows observers to be registered, notified, and removed. 
 * Allows books to be added. 
 * @author Vivian D'Souza
 */
public class CheckoutCounter implements Subject {
  private ArrayList<Observer> observers; //arays list of observers (queue to be notified)
  private ArrayList<Checkout> checkouts; //array list of checkouts
  private boolean isFull;
  private int numInUse;

  /**
  * Creates a BestSellers object.
  */
  public CheckoutCounter() {
    observers = new ArrayList<Observer>();
    checkouts = new ArrayList<Checkout>();
    isFull = false;
    numInUse = 0;
  }

  /**
  * Registers an observer to the BestSellers subject. 
  * @param observer an observer Object which will subscribe to BestSellers
  */
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  /**
  * Removes an observer from subscription to the BestSellers subject. 
  * @param observer an observer Object which will be removed from BestSellers
  */
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
  * Notifies an observer when a new book is added.
  * @param book the book that the observers will be notified about.
  */
  public void notifyObservers(Checkout checkout) {
    for (Observer observer: observers) {
      observer.update(checkout);
    }
  }

  /**
  * Adds a new book to the list and notifies observers.
  * @param book an Book Object whose addition will be sent as a notification.
  */
  public void addCheckout(Checkout checkout) {
    checkouts.add(checkout);
    for (Observer observer : observers) {
      observer.update(checkout);
    }
  }

  public String useCheckout(Checkout checkout, Customer customer) {
    System.out.println("Processing Transaction....");

    try {
      Thread.sleep(4 * 1000);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }

    checkout.setStatus(true);
    return "Transaction successful! Please take your receipt. Have a great day!";
    /*if (customer.getPaymentMethod().equals("card")) {
      return "Transaction successful! Please take your receipt. Have a great day!";
    } else { //if paying with cash
      if (customer.getAmountPaid() == customer.getBillTotal()) { // if cash paid equals bill total
        return "Transaction successful! Please take your receipt. Have a great day!";
      } else if (customer.getAmountPaid() > customer.getBillTotal()){
        double status = checkout.giveChangeBack(customer.getBillTotal() - customer.getAmountPaid());
        if (status < 0) { // occurs if there is insufficient cash in machine
          return "Transaction failed. Not enough cash. Please take your cash and use the next available register.";
        } else { // occurs if transaction is successful
          customer.setChange(status);
          return "Transaction successful! Please take your receipt. Have a great day!";
        }
      } else { // if cash is not enough to satisfy the bill
        return "Not enough cash deposited. Please deposit enough cash to meet your bill total.";
      }*/
    }

  public void setNumInUse(int i) {
    numInUse += i;

    if (numInUse >= 8) {
      isFull = true;
    } else {
      isFull = false;
    }
  }

  public boolean isFull() {
    return isFull;
  }

  public ArrayList<Checkout> getAllCheckouts() {
    return checkouts;
  }

  /*  public Checkout findCheckout(int i) {
    for (Checkout c:checkouts) {
      if (c.getNum() == i) {
        return c;
      }
    }
    return null;
  }*/
}
