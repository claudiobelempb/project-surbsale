package br.com.surb.sales.shared.AppExeptions.AppExeptionsService;

public class AppEntityNotFoundException extends RuntimeException{
  public AppEntityNotFoundException(String message) {
    super(message);
  }
}
