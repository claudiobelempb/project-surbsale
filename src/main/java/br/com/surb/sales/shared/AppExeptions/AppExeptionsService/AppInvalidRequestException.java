package br.com.surb.sales.shared.AppExeptions.AppExeptionsService;

import br.com.surb.sales.shared.AppValidator.AppValidateErrors;

public class AppInvalidRequestException extends RuntimeException {

  private final AppValidateErrors validationErrors;

  public AppInvalidRequestException(AppValidateErrors validationErrors) {
    super(validationErrors.toString());
    this.validationErrors = validationErrors;
  }

  public AppValidateErrors getValidateErrors() {
    return validationErrors;
  }
}