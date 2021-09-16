
class Checkout {
  private int number;
  private double change;
  private boolean cash;
  private boolean card; 
  private boolean isOpen;

  public Checkout(int number, double change, boolean cash, boolean card, boolean isOpen) {
    this.number = number;
    this.change = change;
    this.cash = cash;
    this.card = card; 
    this.isOpen = isOpen;
  }

  public boolean getCashStatus() {
      return cash;
  }

  public boolean getCardStatus() {
    return card;
  }

  public double getChange() {
    return change;
  }

  public int getNum() {
    return number;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setStatus(boolean isOpen) {
    this.isOpen = isOpen;
  }

  public double giveChangeBack(double amountToBePaid) {
    return (this.change = amountToBePaid);
  }

  public String toString() {
    return "Checkout #" + getNum();
  }
}