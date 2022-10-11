package com.usa.doctor.repository.crudrepository;

import com.usa.doctor.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
