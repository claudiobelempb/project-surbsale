package br.com.surb.sales.shared.AppImterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppDAO<DT, ID> {

  Page<DT> index(Pageable pageable);

  DT show(ID id);

  DT create(DT dto);

  DT update(ID id, DT dto);

  void delete(ID id);

}
