package br.com.surb.sale.modules.client.services;

import br.com.surb.sale.modules.client.dto.ClientDTO;
import br.com.surb.sale.shared.AppImterfaces.AppDAO;
import org.springframework.stereotype.Service;

@Service
public interface ClientService extends AppDAO<ClientDTO, Long> {

}
