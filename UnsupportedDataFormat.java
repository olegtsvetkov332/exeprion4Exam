public class UnsupportedDataFormat extends Exception {

  String date;

  public UnsupportedDataFormat(String message, String date) {
    super(message);
    this.date = date;
  }

  public String getDate() {
    return date;
  }
}
