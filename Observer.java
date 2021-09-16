/**
 * Creates interface Observer.
 * @author Vivian D'Souza
 */
public interface Observer {
  /**
  * Updates a list of subjects.
  * @param checkout an object Checkout to be added to the observer's (customer's) watch list
  */
  public void update(Checkout checkout);
  
  /**
  * Displays contents of a list of subjects.
  */
  public void display();
}
