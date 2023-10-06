package br.com.surb.sale.modules.role.infra.repositories;

import br.com.surb.sale.modules.role.infra.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByAuthority(String name);
}
