/*
 * Creates Checkout which implements Observer and acts as a queue of checkouts.
 * Serves as a template for any Checkout in the program.
 * @author Vivian D'Souza
 */
class Checkout {
  private int number;
  private double change;
  private boolean cash;
  private boolean card; 
  private boolean isOpen;

  /**
  * Creates a Checkout object.
  * @param number an int id of the checkout
  * @param change a double holding the amount of change present in the machine
  * @param cash a boolean that determines whether the checkout will accept cash 
  * @param card a boolean that determines whether the checkout will accept card 
  * @param isOpen a boolean that determines wether a checkout is open or not
  */
  public Checkout(int number, double change, boolean cash, boolean card, boolean isOpen) {
    this.number = number;
    this.change = change;
    this.cash = cash;
    this.card = card; 
    this.isOpen = isOpen;
  }

  /**
  * Returns cash status
  * @return cash an boolean that determines if the machine takes cash
  */
  public boolean getCashStatus() {
      return cash;
  }

  /**
  * Returns card status
  * @return card an boolean that determines if the machine takes card
  */
  public boolean getCardStatus() {
    return card;
  }

  /**
  * Returns cash amount
  * @return change a double holding the amount of money present in machine
  */
  public double getChange() {
    return change;
  }

  /**
  * Returns int id
  * @return int holding id of checkout
  */
  public int getNum() {
    return number;
  }

  /**
  * Returns availability
  * @return isOpen an boolean that determines if the checkout is/is not in use
  */
  public boolean isOpen() {
    return isOpen;
  }

  /**
  * Sets availability
  * @param isOpen a boolean holding open/closed state
  */
  public void setOpenStatus(boolean isOpen) {
    this.isOpen = isOpen;
  }

  /**
  * Completes change requests
  * @return amountToBePaid a double holding requested amount
  */
  public double giveChangeBack(double amountToBePaid) {
    return (this.change = amountToBePaid);
  }

  /**
  * Prints id of checkout
  * @return String bearing Checkout id
  */
  public String toString() {
    return "Checkout #" + getNum();
  }
}