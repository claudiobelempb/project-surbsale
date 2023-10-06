package br.com.surb.sale.shared.AppExeptions.AppExeptionsService;

public class AppDataIntegrityViolationException extends RuntimeException{
  public AppDataIntegrityViolationException(String message) {
    super(message);
  }
}
