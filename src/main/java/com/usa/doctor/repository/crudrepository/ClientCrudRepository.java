package com.usa.doctor.repository.crudrepository;

import com.usa.doctor.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
