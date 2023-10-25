package br.com.surb.sales.modules.user.infra.repositories;

import br.com.surb.sales.modules.user.infra.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
  //Optional<User> findByEmail(String email);
}
