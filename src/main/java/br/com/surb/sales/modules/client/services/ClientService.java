package br.com.surb.sales.modules.client.services;

import br.com.surb.sales.modules.client.dto.ClientDTO;
import br.com.surb.sales.shared.AppImterfaces.AppDAO;
import org.springframework.stereotype.Service;

@Service
public interface ClientService extends AppDAO<ClientDTO, Long> {

}
