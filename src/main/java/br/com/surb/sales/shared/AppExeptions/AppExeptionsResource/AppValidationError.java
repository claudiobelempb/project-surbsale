package br.com.surb.sales.shared.AppExeptions.AppExeptionsResource;

import java.util.ArrayList;
import java.util.List;

public class AppValidationError extends AppStandarError {
  private final List<AppFieldMessage> errors = new ArrayList<>();

  public List<AppFieldMessage> getErrors() {
    return errors;
  }

  public void addError( String fieldName, String message) {
    errors.add(new AppFieldMessage( fieldName, message));
  }
}
