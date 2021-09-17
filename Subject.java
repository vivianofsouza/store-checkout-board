/**
 * Creates interface Subject.
 * @author Vivian D'Souza
 */
public interface Subject {

  /**
  * Registers an observer to the subject.
  * @param observer an object Observer to be added to subscription list
  */
  public void registerObserver(Observer observer);

  /**
  * Removes an observer of the subject.
  * @param observer an object Observer to be removed from subscription list
  */
  public void removeObserver(Observer observer);
}
