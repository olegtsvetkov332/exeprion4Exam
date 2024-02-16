public class PhoneNumberException extends Exception {
  int number;

  public PhoneNumberException(String message, int number) {
    super(message);
    this.number = number;
  }

  public int getNumber() {
    return number;
  }
}
