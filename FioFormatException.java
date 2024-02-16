class FioFormatException extends Exception {
  String fio;

  public FioFormatException(String message, String fio) {
    super(message);
    this.fio = fio;
  }

  public String getFio() {
    return fio;
  }

}