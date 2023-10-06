package br.com.surb.sale.modules.client.infra.repositories;

import br.com.surb.sale.modules.client.infra.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  @Query(value = " SELECT c FROM Client c WHERE c.name LIKE :name ")
  List<Client> searchNamePsql(@Param("name") String name);

  @Query(value = " SELECT * FROM tb_client c WHERE c.name LIKE '%:name%' ", nativeQuery = true)
  List<Client> searchNameSql(@Param("name") String name);

  List<Client> findByNameLike(String name);
  List<Client> findByNameOrClientId(String name, Long clientId);
  List<Client> findByNameOrClientIdOrderByClientId(String name, Long clientId);
  Client findOneByName(String name);
  void deleteByName(String name);
  boolean existsByName(String name);
}
