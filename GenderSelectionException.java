public class GenderSelectionException extends Exception {
  String gender;

  public GenderSelectionException(String message, String gender) {
    super(message);
    this.gender = gender;
  }

  public String getGender() {
    return gender;
  }
}
