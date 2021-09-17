import java.util.ArrayList;

/*
 * Creates CheckCounter, an implementation of Subject. 
 * Allows observers (customers) to be added and removed. 
 * Allows checkouts to be added.
 * @author Vivian D'Souza
 */
public class CheckoutCounter implements Subject {
  private ArrayList<Observer> observers; //arays list of observers (queue to be notified)
  private ArrayList<Checkout> checkouts; //array list of checkouts
  private boolean isFull;
  private int numInUse;

  /**
  * Creates a CheckoutCounter object.
  */
  public CheckoutCounter() {
    observers = new ArrayList<Observer>();
    checkouts = new ArrayList<Checkout>();
    isFull = false;
    numInUse = 0;
  }

  /**
  * Registers an observer to a checkout subject. 
  * @param observer an observer Object which will subscribe to checkouts
  */
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  /**
  * Removes an observer from subscription to the CheckoutCounter subject. 
  * @param observer an observer Object which will be removed from CheckoutCounter
  */
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
  * Adds a new checkout to the list and notifies observers.
  * @param checkout an Checkout Object whose addition will be seen as an update on the checkoutBoard
  */
  public void addCheckout(Checkout checkout) {
    checkouts.add(checkout);
    for (Observer observer : observers) {
      observer.update(checkout);
    }
  }

  /**
  * To be implemented later
  */
  /*public String useCheckout(Checkout checkout, Customer customer) {
    System.out.println("Processing Transaction....");
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
      }
    }*/

  /**
  * Increments/Decrements numInUse any time a checkout's state changes 
  * @param i an int of new checkouts in use/open
  */
  public void setNumInUse(int i) {
    numInUse += i;
    if (numInUse >= 8) {
      isFull = true;
    } else {
      isFull = false;
    }
  }

  /**
  * Returns numInUse
  * @return numInUse, int holding # of checkouts in use
  */
  public int getNumInUse() {
    return numInUse;
  }

  /**
  * Returns isFull
  * @return isFull, a boolean stating whether the entire counter is full or not
  */
  public boolean isFull() {
    return isFull;
  }

  /**
  * Sets isFull
  * @param isFull, a boolean stating whether the entire counter is full or not
  */
  public void setStatus(boolean isFull) {
    this.isFull = isFull;
  }

  /**
  * Returns checkouts
  * @return checkouts, an arrayList holding all the checkouts
  */
  public ArrayList<Checkout> getAllCheckouts() {
    return checkouts;
  }

}
