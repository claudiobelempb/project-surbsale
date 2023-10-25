package br.com.surb.sales.shared.AppExeptions.AppExeptionsService;

public class AppForbiddenException  extends RuntimeException{
  public AppForbiddenException(String msg){
    super(msg);
  }
}
