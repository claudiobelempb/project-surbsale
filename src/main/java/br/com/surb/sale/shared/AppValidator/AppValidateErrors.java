package br.com.surb.sale.shared.AppValidator;

import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppValidateErrors implements Streamable<AppValidateError> {

  private final List<AppValidateError> validationErrors;

  public AppValidateErrors() {
    this.validationErrors = new ArrayList<>();
  }

  public AppValidateErrors addErrors(String field, String errorCode) {
    return addErrors(new AppValidateError(field, errorCode));
  }

  public AppValidateErrors addErrors(AppValidateError validationError) {
    validationErrors.add(validationError);
    return this;
  }

  public AppValidateError getErrorIndex(int index) {
    return validationErrors.get(index);
  }

  public int getErrorOfNumber() {
    return validationErrors.size();
  }

  public boolean hasErrors(){
    return !validationErrors.isEmpty();
  }

  @Override
  public String toString() {
    return "AppValidateErrors{" +
      "validationErrors=" + validationErrors +
      '}';
  }

  @Override
  public Iterator<AppValidateError> iterator() {
    return validationErrors.iterator();
  }
}
