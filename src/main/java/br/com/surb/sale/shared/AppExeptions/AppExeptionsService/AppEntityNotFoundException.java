package br.com.surb.sale.shared.AppExeptions.AppExeptionsService;

public class AppEntityNotFoundException extends RuntimeException{
  public AppEntityNotFoundException(String message) {
    super(message);
  }
}
