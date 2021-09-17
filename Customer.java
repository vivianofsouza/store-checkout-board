import java.util.ArrayList;

/**
 * Creates Customer, which is an implementation of Observer. 
 * Serves as a template for any customer-observer of the checkouts. 
 * @author Vivian D'Souza
 */
public class Customer implements Observer{
  private String paymentMethod;
  private String name;
  private double billTotal;
  // private double change; - to be used later
  private ArrayList<Checkout> checkouts;
  private Subject subject;
  private double amountPaid;


  /**
  * Creates a Customer object.
  * @param name a String of the Customer's name
  * @param subject a subject object that the customer will register to observe (checkout)
  * @param paymentMethod a String holding how the customer will pay (cash/card)
  * @param billTotal a double holding the customer's bill total
  * @param amountPaid a double holding the amount a customer actually pays
  */
  public Customer(String name, Subject subject, String paymentMethod, double billTotal, double amountPaid) {
    this.subject = subject;
    this.billTotal = billTotal;
    this.paymentMethod = paymentMethod;
    this.amountPaid = amountPaid;
    this.name = name;
    subject.registerObserver(this);
    this.checkouts = new ArrayList<Checkout>();  
  }

  /**
  * Updates the checkout list.
  * @param checkout an object Checkout to be added to the list
  */
  public void update(Checkout checkout) {
    checkouts.add(checkout);
  }

  /**
  * Obtains a customer's payment method
  * @return paymentMethod, a string bearing cash or card
  */
  public String getPaymentMethod() {
    return paymentMethod;
  }

  /**
  * Obtains a customer's name
  * @return name, string of customer's name
  */
  public String getName() {
    return name;
  }

  /**
  * Obtains a customer's bill total
  * @return billTotal, a string with cutomer's bill total
  */
  public double getBillTotal() {
    return billTotal;
  }
  
  /**
  * Displays a customer's bill
  */
  public void display() {
    System.out.println(this.getName() + " requires " + getPaymentMethod() + " with a total bill of " + getBillTotal());
  }
}
