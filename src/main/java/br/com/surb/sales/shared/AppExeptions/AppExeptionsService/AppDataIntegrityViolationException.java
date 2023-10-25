package br.com.surb.sales.shared.AppExeptions.AppExeptionsService;

public class AppDataIntegrityViolationException extends RuntimeException{
  public AppDataIntegrityViolationException(String message) {
    super(message);
  }
}
