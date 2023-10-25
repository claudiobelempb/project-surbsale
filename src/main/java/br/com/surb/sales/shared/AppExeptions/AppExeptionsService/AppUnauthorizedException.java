package br.com.surb.sales.shared.AppExeptions.AppExeptionsService;

public class AppUnauthorizedException extends RuntimeException {
  public AppUnauthorizedException(String msg) {
    super(msg);
  }

}
