package br.com.surb.sales.modules.client.services.ipml;

import static java.util.Objects.requireNonNull;
import br.com.surb.sales.modules.client.dto.ClientDTO;
import br.com.surb.sales.modules.client.dto.mapper.ClientMapper;
import br.com.surb.sales.modules.client.infra.entities.Client;
import br.com.surb.sales.modules.client.infra.repositories.ClientRepository;
import br.com.surb.sales.modules.client.services.ClientService;
import br.com.surb.sales.shared.AppConstants.AppExceptionConstants;
import br.com.surb.sales.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.sales.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private ClientRepository clientRepository;

  @Override
  @Transactional(readOnly = true)
  public Page<ClientDTO> index(Pageable pageable) {
    Page<Client> movies = clientRepository.findAll(pageable);
    return movies.map(movie -> ClientMapper.toCreateDTO(movie));
  }

  @Override
  @Transactional(readOnly = true)
  public ClientDTO show(Long id) {
    requireNonNull(id);
    Optional<Client> optional = clientRepository.findById(id);
    Client entity =
      optional.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id));
    return ClientMapper.toCreateDTO(entity);
  }

  @Override
  @Transactional
  public ClientDTO create(ClientDTO dto) {
    Client entity = new Client();
    ClientMapper.toCreateDTO(entity);
    Optional<Client> optional = clientRepository.findById(dto.getClientId());
    Client obj =
      optional.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + dto.getClientId()));
    entity = clientRepository.save(obj);
    return ClientMapper.toCreateDTO(entity);
  }

  @Override
  @Transactional
  public ClientDTO update(Long id, ClientDTO dto) {
    try {
      Optional<Client> optional = clientRepository.findById(id);
      Client obj =
        optional.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + dto.getClientId()));
      ClientMapper.toUpdateDTO(obj);
      obj = clientRepository.save(obj);
      return ClientMapper.toCreateDTO(obj);
    } catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }

  @Override
  public void delete(Long id) {
    try {
      clientRepository.deleteById(id);
    }catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }catch (EmptyResultDataAccessException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND  + id);
    }catch (DataIntegrityViolationException e){
      throw new AppDataIntegrityViolationException(AppExceptionConstants.INTEGRITY_VIOLATION + id);
    }
  }
}
