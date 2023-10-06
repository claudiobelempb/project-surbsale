package br.com.surb.sale.modules.user.validation;

import br.com.surb.sale.modules.user.dto.UserCreateDTO;
import br.com.surb.sale.modules.user.infra.entities.User;
import br.com.surb.sale.modules.user.infra.repositories.UserRepository;
import br.com.surb.sale.shared.AppConstants.AppValidatorConstants;
import br.com.surb.sale.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserCreateValidator implements ConstraintValidator<UserCreateValid, UserCreateDTO> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void initialize(UserCreateValid ann) {
  }

  @Override
  public boolean isValid(UserCreateDTO dto, ConstraintValidatorContext context) {

    List<AppFieldMessage> list = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User user = userRepository.findByEmail(dto.getEmail());
    /*Optional<User> optional = userRepository.findById(dto.getUserId());
    User user =
      optional.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + dto
      .getUserId()));*/

    if(user != null){
      list.add(new AppFieldMessage( "email", AppValidatorConstants.REQUIRED_EMAIL_EXIST));
    }

    for (AppFieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
        .addConstraintViolation();
    }
    return list.isEmpty();
  }
}
