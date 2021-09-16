import java.util.ArrayList;
//This is an ArrayList type

/**THIS IS AN OBSERVER
 * Creates Customer, which is an implementation of Observer. 
 * Serves as a template for any customer-observer of the bookstore; has a wishlist. 
 * @author Vivian D'Souza
 */
public class Customer implements Observer{
  private String paymentMethod;
  private String name;
  private double billTotal;
  private double amountPaid;
  private double change;
  private ArrayList<Checkout> checkouts;
  private Subject subject;

  /**
  * Creates a Customer object.
  * @param subject a subject object that the customer will register to observe
  * @param firstName a String of the Customer's first name
  * @param lastName a String of the Customer's last name
  */
  public Customer(String name, Subject subject, String paymentMethod, double billTotal,  double change) {
    this.subject = subject;
    this.billTotal = billTotal;
    this.paymentMethod = paymentMethod;
    this.amountPaid = amountPaid;
    this.change = change;
    this.name = name;
    subject.registerObserver(this);
    this.checkouts = new ArrayList<Checkout>();  
  }

  /**
  * Updates the wishlist.
  * @param book an object Book to be added to wishlist list
  */
  public void update(Checkout checkout) {
    checkouts.add(checkout);
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public String getName() {
    return name;
  }

  public double getBillTotal() {
    return billTotal;
  }

  public double getAmountPaid() {
    return amountPaid;
  }

  public void setChange(double amountPaid) {
    this.amountPaid = amountPaid;
  }
  
  public void display() {
    System.out.println(this.getName() + " requires " + getPaymentMethod() + " with a total bill of " + getBillTotal());
  }
}
