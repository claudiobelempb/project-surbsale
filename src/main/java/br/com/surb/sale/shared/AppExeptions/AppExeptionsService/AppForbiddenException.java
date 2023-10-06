package br.com.surb.sale.shared.AppExeptions.AppExeptionsService;

public class AppForbiddenException  extends RuntimeException{
  public AppForbiddenException(String msg){
    super(msg);
  }
}
