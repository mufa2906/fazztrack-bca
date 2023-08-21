package exceptions;

public class EmptyNumberOfOrder extends RuntimeException {
  public EmptyNumberOfOrder(String message) {
    super(message);
  }
}
