package br.com.surb.sale.shared.AppExeptions.AppExeptionsService;

public class AppUnauthorizedException extends RuntimeException {
  public AppUnauthorizedException(String msg) {
    super(msg);
  }

}
